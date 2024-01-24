import string


class ValidPalindrome:
    def isPalindrome(self, str: string):
        left = 0
        right = len(str)-1

        while left < right:
            if str[left] != str[right]:
                return False
            left += 1
            right -= 1

        return True;

vp = ValidPalindrome()
print(vp.isPalindrome('abba'))