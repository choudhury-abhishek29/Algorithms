def lengthOfLongestSubstring(self, s: str) -> int:
    maxLength = 0
    left, right = 0, 0
    cset = set()

    while right < len(s):
        if s[right] not in cset:
            cset.add(s[right])
            right += 1
            maxLength = max(maxLength, len(cset))
        else:
            cset.remove(s[left])
            left += 1

    return maxLength