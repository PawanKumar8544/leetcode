class Solution {
    /**
     * Calculates the earliest possible finish time for completing two types of tasks.
     * Tasks can be completed in either order: land tasks first then water tasks, or vice versa.
     *
     * @param landStartTime array of start times for land tasks
     * @param landDuration array of durations for land tasks
     * @param waterStartTime array of start times for water tasks
     * @param waterDuration array of durations for water tasks
     * @return the minimum finish time across both possible orderings
     */
    public int earliestFinishTime(
        int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        // Calculate finish time if land tasks are done first, then water tasks
        int landThenWaterTime = calculateSequentialFinishTime(
            landStartTime, landDuration, waterStartTime, waterDuration);

        // Calculate finish time if water tasks are done first, then land tasks
        int waterThenLandTime = calculateSequentialFinishTime(
            waterStartTime, waterDuration, landStartTime, landDuration);

        // Return the minimum of the two possible orderings
        return Math.min(landThenWaterTime, waterThenLandTime);
    }

    /**
     * Calculates the finish time when completing first set of tasks before second set.
     *
     * @param firstStartTimes array of start times for first task set
     * @param firstDurations array of durations for first task set
     * @param secondStartTimes array of start times for second task set
     * @param secondDurations array of durations for second task set
     * @return the total finish time for this task ordering
     */
    private int calculateSequentialFinishTime(
        int[] firstStartTimes, int[] firstDurations,
        int[] secondStartTimes, int[] secondDurations) {

        // Find the earliest completion time among all first tasks
        int earliestFirstTaskCompletion = Integer.MAX_VALUE;
        for (int i = 0; i < firstStartTimes.length; i++) {
            int taskEndTime = firstStartTimes[i] + firstDurations[i];
            earliestFirstTaskCompletion = Math.min(earliestFirstTaskCompletion, taskEndTime);
        }

        // Find the earliest total completion time when starting second tasks
        // after completing at least one first task
        int earliestTotalCompletion = Integer.MAX_VALUE;
        for (int i = 0; i < secondStartTimes.length; i++) {
            // Second task can only start after both:
            // 1. Its own start time constraint
            // 2. At least one first task is complete
            int actualSecondTaskStart = Math.max(earliestFirstTaskCompletion, secondStartTimes[i]);
            int totalCompletionTime = actualSecondTaskStart + secondDurations[i];
            earliestTotalCompletion = Math.min(earliestTotalCompletion, totalCompletionTime);
        }

        return earliestTotalCompletion;
    }
}