from _ast import List


class MaxWater:
    def maxArea(self, height) -> int:
        maxWater = 0
        left = 0
        right = len(height)-1

        while left < right:
            if height[left] < height[right]:
                maxWater = max(maxWater, (right-left)*height[left])
                left+=1
            else:
                maxWater = max(maxWater, (right - left) * height[right])
                right-=1

        return maxWater

mw = MaxWater()
print(mw.maxArea([1,8,6,2,5,4,8,3,7]))