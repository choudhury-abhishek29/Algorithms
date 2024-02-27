from typing import List

class FizzBuzz:
    def fizzBuzz(self, n: int) -> List[str]:
        res = [None] * n
        for i in range(n):
            curr = i + 1
            if curr % 3 == 0 and curr % 5 == 0:
                res[i] = 'FizzBuzz'
            elif curr % 3 == 0:
                res[i] = 'Fizz'
            elif curr % 5 == 0:
                res[i] = 'Buzz'
            else:
                res[i] = curr

        return res

fb = FizzBuzz()
print(fb.fizzBuzz(5))