class Solution {
    public int maxLength(List<String> arr) {
        int maxLen = 0; 
        List<Integer> bitMasks = new ArrayList<>(); 
        bitMasks.add(0); 


        for (String s : arr) {
            int bitMask = 0;
        
            for (int i = 0; i < s.length(); ++i) {
                int bitIndex = s.charAt(i) - 'a'; 
                if (((bitMask >> bitIndex) & 1) == 1) {
                    bitMask = 0;
                    break;
                }
                bitMask |= 1 << bitIndex; 
            }

        
            if (bitMask == 0) {
                continue;
            }

            int currentSize = bitMasks.size();
        
            for (int i = 0; i < currentSize; ++i) {
                int combinedMask = bitMasks.get(i);
               
                if ((combinedMask & bitMask) == 0) {
                    bitMasks.add(combinedMask | bitMask); 
                    maxLen = Math.max(maxLen, Integer.bitCount(combinedMask | bitMask)); 
                }
            }
        }

        return maxLen;
    }
}