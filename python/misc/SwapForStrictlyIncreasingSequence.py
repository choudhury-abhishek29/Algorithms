def solution(numbers):
    swaps = 0
    index = 0
    for i in range(len(numbers) - 1):
        if numbers[i] >= numbers[i + 1]:
            swaps += 1
            index = i
    if swaps > 1:
        return False
    elif not swaps:
        return True

    swappedI = swapToSmallest(numbers[index])
    if (index - 1 < 0 or numbers[index - 1] < swappedI) and numbers[index + 1] > swappedI:
        return True
    swappedIPlus1 = swapToSmallest(numbers[index])
    if (index + 1 > len(numbers) or numbers[index + 1] < swappedIPlus1) and numbers[index - 1] < swappedIPlus1:
        return True

    return False


def swapToSmallest(num) -> int:
    num = str(num)
    smallIndex = 0
    smallestRight = num[smallIndex]
    for i in range(1, len(num)):
        if num[i] <= smallestRight:
            smallestRight = num[i]
            smallIndex = i

    largeIndex = -1
    largeLeft = num[largeIndex]
    for i in range(len(num) - 2, -1, -1):
        if num[i] >= largeLeft:
            largeLeft = num[i]
            largeIndex = i

    res = ""
    for i, v in enumerate(num):
        if i == largeIndex:
            res += smallestRight
        elif i == smallIndex:
            res += largeLeft
        else:
            res += v

    return int(res)

#tests
numbers = [1, 5, 10, 20]
print(solution(numbers))

numbers = [1, 3, 900, 10]
print(solution(numbers))

numbers = [1000, 10, 100]
print(solution(numbers))

numbers = [1, 2, 10, 7]
print(solution(numbers))

numbers = [1, 3, 3, 3]
print(solution(numbers))

numbers = [1000, 10, 9]
print(solution(numbers))