import sys
from typing import List

class Find132Pattern:
    def find132pattern(self, nums: List[int]) -> bool:
        min_val = nums[0]
        stk = []

        for n in nums[1:]:
            while stk and n >= stk[-1][0]:
                stk.pop()

            if stk and n > stk[-1][1]:
                return True

            stk.append([n, min_val])
            min_val = min(min_val, n)

        return False

pat = Find132Pattern()
print(pat.find132pattern([1,0,1,-4,-3]))
