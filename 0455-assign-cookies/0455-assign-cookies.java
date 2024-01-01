class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
    Arrays.sort(g);
        int children=0;
        int cookies=0;
        while(cookies<s.length && children<g.length){
            if(s[cookies]>=g[children]){
                children++;
            }
            cookies++;
        }
        return children;

    }
}