import sys

class BestTimeToBuySellStock:
    def maxProfit(self, prices) -> int:
        minVal = sys.maxsize
        maxProfit = 0

        for price in prices:
            if price < minVal:
                minVal = price
            elif maxProfit < price-minVal:
                maxProfit = price - minVal

        return maxProfit

bss = BestTimeToBuySellStock()
print(bss.maxProfit([7,1,5,3,6,4]))