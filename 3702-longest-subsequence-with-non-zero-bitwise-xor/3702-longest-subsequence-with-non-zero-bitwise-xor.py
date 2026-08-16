class Solution:
    def longestSubsequence(self, nums: List[int]) -> int:
        n = len(nums)
        x = 0
        for v in nums: x ^= v
        if x != 0: return n
        if any(v != 0 for v in nums): return n - 1
        return 0 