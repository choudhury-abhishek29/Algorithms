from typing import List


class OrigXorArray:
    def findArray(self, pref: List[int]) -> List[int]:
        xor=[None]*len(pref)
        xor[0]=pref[0]
        res = xor[0]
        for i in range(1,len(pref)):
            xor[i] = pref[i-1] ^ pref[i]
            # res ^= xor[i]

        return xor

# [5,2,0,3,1] -> [5,7,2,3,2]

oxa = OrigXorArray()
print(oxa.findArray([5,2,0,3,1]))
