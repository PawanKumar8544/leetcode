class Solution {
    /**
     * Calculates the earliest finish time for completing tasks from two different categories.
     * Tasks can be completed in either order: land tasks first then water tasks, or vice versa.
     *
     * @param landStartTime array of start times for land tasks
     * @param landDuration array of durations for land tasks
     * @param waterStartTime array of start times for water tasks
     * @param waterDuration array of durations for water tasks
     * @return the minimum time to complete all tasks
     */
    public int earliestFinishTime(
        int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        // Calculate finish time if land tasks are done first, then water tasks
        int landThenWater = calculateFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);

        // Calculate finish time if water tasks are done first, then land tasks
        int waterThenLand = calculateFinishTime(waterStartTime, waterDuration, landStartTime, landDuration);

        // Return the minimum of both approaches
        return Math.min(landThenWater, waterThenLand);
    }

    /**
     * Helper method to calculate the finish time when completing first category tasks
     * followed by second category tasks.
     *
     * @param firstStartTimes array of start times for first category tasks
     * @param firstDurations array of durations for first category tasks
     * @param secondStartTimes array of start times for second category tasks
     * @param secondDurations array of durations for second category tasks
     * @return the total time to complete all tasks in the specified order
     */
    private int calculateFinishTime(int[] firstStartTimes, int[] firstDurations,
                                   int[] secondStartTimes, int[] secondDurations) {

        // Find the earliest possible completion time for all first category tasks
        int earliestFirstCategoryEnd = Integer.MAX_VALUE;
        for (int i = 0; i < firstStartTimes.length; i++) {
            int taskEndTime = firstStartTimes[i] + firstDurations[i];
            earliestFirstCategoryEnd = Math.min(earliestFirstCategoryEnd, taskEndTime);
        }

        // Find the minimum total completion time considering all second category tasks
        int minimumTotalTime = Integer.MAX_VALUE;
        for (int i = 0; i < secondStartTimes.length; i++) {
            // Second task can only start after both: first category ends and its own start time
            int secondTaskStart = Math.max(earliestFirstCategoryEnd, secondStartTimes[i]);
            int totalTime = secondTaskStart + secondDurations[i];
            minimumTotalTime = Math.min(minimumTotalTime, totalTime);
        }

        return minimumTotalTime;
    }
}