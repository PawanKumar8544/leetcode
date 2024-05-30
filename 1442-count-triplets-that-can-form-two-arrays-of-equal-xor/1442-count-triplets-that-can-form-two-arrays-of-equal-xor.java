class Solution {
    public int countTriplets(int[] arr) {
        int[] prefixXor = new int[arr.length + 1]; 

    
        for (int i = 0; i <arr.length; ++i) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }

        int count = 0; // The result count for triplets.

        // Iterate through all possible starts i of subarray (arr[i] to arr[k]).
        for (int i = 0; i <arr.length - 1; ++i) {
            // Iterate through all possible ends j (where i < j <= k) of subarray starting at arr[i].
            for (int j = i + 1; j <arr.length; ++j) {
                // Iterate for all possible ends k of the second subarray, starting from arr[j].
                for (int k = j; k <arr.length; ++k) {
                    // XOR of subarray arr[i] to arr[j-1].
                    int xorA = prefixXor[j] ^ prefixXor[i];
                    // XOR of subarray arr[j] to arr[k].
                    int xorB = prefixXor[k + 1] ^ prefixXor[j];
                  
                    if (xorA == xorB) { // If the XOR of both subarrays is equal, it's a valid triplet.
                        count++; // Increment the count of valid triplets.
                    }
                }
            }
        }

        return count; // Return the final count of triplets.
    }
}