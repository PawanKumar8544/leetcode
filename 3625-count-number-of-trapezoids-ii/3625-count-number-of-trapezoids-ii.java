class Solution {

    public int countTrapezoids(int[][] points) {
        int n = points.length;

        Map<Slope, List<int[]>> map = new HashMap<>();

        // Group segments by slope
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Slope s = getSlope(points[i], points[j]);
                map.computeIfAbsent(s, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int count = 0;

        // Iterate segments in each slope bucket
        for (List<int[]> segs : map.values()) {
            int m = segs.size();
            for (int a = 0; a < m; a++) {
                for (int b = a + 1; b < m; b++) {

                    int i1 = segs.get(a)[0], j1 = segs.get(a)[1];
                    int i2 = segs.get(b)[0], j2 = segs.get(b)[1];

                    // must not share endpoints
                    if (i1 == i2 || i1 == j2 || j1 == i2 || j1 == j2)
                        continue;

                    int[][] quad = {
                        points[i1], points[j1], points[i2], points[j2]
                    };

                    if (isValidConvexQuad(quad))
                        count++;
                }
            }
        }

        return count;
    }

    // ---------------- Convex Quad Check ------------------
    private boolean isValidConvexQuad(int[][] pts) {
        // centroid
        double cx = 0, cy = 0;
        for (int[] p : pts) { cx += p[0]; cy += p[1]; }
        cx /= 4;
        cy /= 4;

        // allow lambda access
        final double CCX = cx, CCY = cy;

        // sort by polar angle around centroid
        Arrays.sort(pts, (a, b) -> {
            double angA = Math.atan2(a[1] - CCY, a[0] - CCX);
            double angB = Math.atan2(b[1] - CCY, b[0] - CCX);
            return Double.compare(angA, angB);
        });

        // convexity check
        int sign = 0;
        for (int i = 0; i < 4; i++) {
            long cross = cross(pts[i], pts[(i + 1) % 4], pts[(i + 2) % 4]);
            if (cross == 0) return false;
            int cur = cross > 0 ? 1 : -1;
            if (sign == 0) sign = cur;
            else if (sign != cur) return false;
        }
        return true;
    }

    private long cross(int[] a, int[] b, int[] c) {
        long x1 = b[0] - a[0], y1 = b[1] - a[1];
        long x2 = c[0] - a[0], y2 = c[1] - a[1];
        return x1 * y2 - y1 * x2;
    }

    // --------------- slope helper -----------------
    private Slope getSlope(int[] p1, int[] p2) {
        int dy = p2[1] - p1[1];
        int dx = p2[0] - p1[0];
        if (dx == 0) return new Slope(1, 0);
        if (dy == 0) return new Slope(0, 1);
        int g = gcd(Math.abs(dy), Math.abs(dx));
        dy /= g; dx /= g;
        if (dx < 0) { dx = -dx; dy = -dy; }
        return new Slope(dy, dx);
    }

    private int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    private static class Slope {
        int dy, dx;
        Slope(int dy, int dx) { this.dy = dy; this.dx = dx; }
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Slope)) return false;
            Slope s = (Slope) o;
            return dy == s.dy && dx == s.dx;
        }
        public int hashCode() { return dy * 31 + dx; }
    }
}
