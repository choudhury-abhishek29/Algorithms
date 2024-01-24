class IntToRoman:
    def romanToInt(self, s: str) -> int:
        symMap = { "M": 1000, "D": 500, "C": 100, "L": 50, "X": 10, "V": 5, "I": 1}
        res = 0
        for c in range(0,len(s)):
            if c+1 < len(s) and symMap[s[c]] < symMap[s[c+1]]:
                res -= int(symMap[s[c]])
            else:
                res += int(symMap[s[c]])

        return res




    def intToRoman(self, num: int) -> str:
        symList = [(1000, "M"), (900, "CM"), (500, "D"), (400, "CD"), (100, "C"),
                  (90, "XC"), (50, "L"), (40, "XL"), (10, "X"), (9, "IX"),
                  (5, "V"), (4, "IV"), (1, "I")]

        res = ""
        for val, sym in symList:
            if num//val:
                count = num // val
                res += (sym * count)
                num = num % val

        return res

itr = IntToRoman()
# print(itr.intToRoman(1989))
print(itr.romanToInt('MCMLXXXIX'))