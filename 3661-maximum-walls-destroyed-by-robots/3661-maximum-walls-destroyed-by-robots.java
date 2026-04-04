class Solution {
    // Memoization table: dp[i][j] stores max walls for robots 0 to i
    // j = 0: robot i pushed left, j = 1: robot i pushed right
    private Integer[][] dp;
  
    // Array to store robot positions and push distances
    // robotData[i][0] = position, robotData[i][1] = push distance
    private int[][] robotData;
  
    // Sorted array of wall positions
    private int[] walls;
  
    // Number of robots
    private int robotCount;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        robotCount = robots.length;
      
        // Initialize robot data array with positions and distances
        robotData = new int[robotCount][2];
        for (int i = 0; i < robotCount; i++) {
            robotData[i][0] = robots[i];
            robotData[i][1] = distance[i];
        }
      
        // Sort robots by position (left to right)
        Arrays.sort(robotData, Comparator.comparingInt(a -> a[0]));
      
        // Sort walls for binary search
        Arrays.sort(walls);
        this.walls = walls;
      
        // Initialize memoization table
        dp = new Integer[robotCount][2];
      
        // Start DFS from last robot, initially considering it pushed right
        return dfs(robotCount - 1, 1);
    }

    /**
     * Dynamic programming function to find max walls covered
     * @param robotIndex - current robot index (0 to n-1)
     * @param nextRobotDirection - direction of next robot (i+1)
     *                            0: next robot pushed left
     *                            1: next robot pushed right
     * @return maximum walls that can be covered from robots 0 to robotIndex
     */
    private int dfs(int robotIndex, int nextRobotDirection) {
        // Base case: no more robots to process
        if (robotIndex < 0) {
            return 0;
        }
      
        // Return memoized result if available
        if (dp[robotIndex][nextRobotDirection] != null) {
            return dp[robotIndex][nextRobotDirection];
        }

        // Option 1: Push current robot to the left
        int leftBoundary = robotData[robotIndex][0] - robotData[robotIndex][1];
      
        // Ensure no overlap with previous robot (if exists)
        if (robotIndex > 0) {
            leftBoundary = Math.max(leftBoundary, robotData[robotIndex - 1][0] + 1);
        }
      
        // Count walls in range [leftBoundary, currentPosition)
        int leftIndex = lowerBound(walls, leftBoundary);
        int rightIndex = lowerBound(walls, robotData[robotIndex][0] + 1);
        int wallsIfPushedLeft = dfs(robotIndex - 1, 0) + (rightIndex - leftIndex);

        // Option 2: Push current robot to the right
        int rightBoundary = robotData[robotIndex][0] + robotData[robotIndex][1];
      
        // Ensure no overlap with next robot (if exists)
        if (robotIndex + 1 < robotCount) {
            if (nextRobotDirection == 0) {
                // Next robot is pushed left, so its left boundary is a constraint
                rightBoundary = Math.min(rightBoundary, 
                    robotData[robotIndex + 1][0] - robotData[robotIndex + 1][1] - 1);
            } else {
                // Next robot is pushed right, so only its position matters
                rightBoundary = Math.min(rightBoundary, 
                    robotData[robotIndex + 1][0] - 1);
            }
        }
      
        // Count walls in range [currentPosition, rightBoundary]
        leftIndex = lowerBound(walls, robotData[robotIndex][0]);
        rightIndex = lowerBound(walls, rightBoundary + 1);
        int wallsIfPushedRight = dfs(robotIndex - 1, 1) + (rightIndex - leftIndex);
      
        // Choose the option that covers more walls
        int maxWalls = Math.max(wallsIfPushedLeft, wallsIfPushedRight);
      
        // Memoize and return result
        dp[robotIndex][nextRobotDirection] = maxWalls;
        return maxWalls;
    }

    /**
     * Binary search to find the leftmost position >= target
     * @param arr - sorted array to search
     * @param target - target value to find
     * @return index of first element >= target
     */
    private int lowerBound(int[] arr, int target) {
        int index = Arrays.binarySearch(arr, target);
      
        // If exact match found, return its index
        // If not found, binarySearch returns -(insertion point) - 1
        // So we convert it back to insertion point
        if (index < 0) {
            return -index - 1;
        }
        return index;
    }
}