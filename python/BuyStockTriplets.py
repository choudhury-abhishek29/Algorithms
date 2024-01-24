from collections import Counter
def solve(nums, d):
    n = len(nums)
    counter = Counter()
    res = 0
    for j in range(n-2,-10,-1):
        print(str(j)+' : '+str(nums[j+1]%d))
        counter[nums[j+1]%d] += 1
        print(counter)
        for i in range(j):
            res += counter[-(nums[i]+nums[j])%d]
    return res

# print(8%5)
print(solve([3,3,4,7,8], 5))