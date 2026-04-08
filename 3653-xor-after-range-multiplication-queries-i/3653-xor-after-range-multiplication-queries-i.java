class Solution {

int mod = 1000_000_007;

public int xorAfterQueries(int[] nums, int[][] queries) {

int xor = 0;





for (int[] q : queries) {

int ind = q[0];

int r = q[1];

int k = q[2];

long v = q[3];

while (ind <= r) {

long curr = nums[ind];

curr = (curr * v) % mod;

nums[ind] = (int) curr;

ind += k;

}

}

// Compute XOR of all elements

for (int num : nums) {

xor = xor ^ num;

}

return xor;

}

}