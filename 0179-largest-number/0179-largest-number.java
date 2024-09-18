class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        
        // Sort the strings using the custom comparator
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0"
        if (numStrs[0].equals("0")) {
            return "0";
        }
        
        // Use StringBuilder for efficient concatenation of the sorted numbers
        StringBuilder result = new StringBuilder();
        for (String numStr : numStrs) {
            result.append(numStr);
        }
        
        return result.toString();
    }
}