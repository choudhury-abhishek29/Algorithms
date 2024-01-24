def characterReplacement(self, s: str, k: int) -> int:
    maxLength = 0
    char_count = {}
    left = 0

    for right in range(len(s)):
        char_count[s[right]] = char_count.get(s[right], 0) + 1
        while (right - left + 1) - max(char_count.values()) > k:
            char_count[s[left]] = char_count.get(s[left]) - 1
            left += 1
        maxLength = max(maxLength, right - left + 1)
    return maxLength