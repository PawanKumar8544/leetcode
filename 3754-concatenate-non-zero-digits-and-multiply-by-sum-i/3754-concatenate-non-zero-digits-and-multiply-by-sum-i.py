class Solution:
    def sumAndMultiply(self, n: int) -> int:
        digits = [int(d) for d in str(n) if d != '0']
        if digits:
            x = int("".join(map(str, digits)))
        else:
            x = 0
        digit_sum = sum(digits)
        return x * digit_sum