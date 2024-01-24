from typing import List


class DivideTeamsOfEqualSkill:
    def dividePlayers(self, skill: List[int]) -> int:
        res=[]
        chem=0
        skill = sorted(skill)
        temp_sum = skill[0]+skill[len(skill)-1]
        left = 0
        right = len(skill)-1
        while left < right:
            if skill[left]+skill[right] == temp_sum:
                res.append([skill[left], skill[right]])
                left+=1
                right-=1
            else:
                return -1

        for team in res:
            chem+=team[0]*team[1]

        return chem




dtes = DivideTeamsOfEqualSkill()
# print(dtes.dividePlayers([3,2,5,1,3,4]))
print(10 / 2)