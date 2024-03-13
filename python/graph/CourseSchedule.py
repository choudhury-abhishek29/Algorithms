from typing import List

class CourseSchedule:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        preMap = []
        for i in range(numCourses):
            preMap.append([])

        for pr in prerequisites:
            preMap[pr[0]].append(pr[1])
        print(preMap)

        inStack = [False]*numCourses
        visited = set()

        for i in range(len(preMap)):
            if self.isCyclic(i, inStack, visited, preMap):
                return False

        return True

    def isCyclic(self, course: int, inStack: [bool], visited: set, preMap: List[List[int]]):
        if inStack[course]:
            return True

        if course in visited:
            return False

        inStack[course] = True
        visited.add(course)
        for pr in preMap[course]:
            if self.isCyclic(pr, inStack, visited, preMap):
                return True

        inStack[course] = False
        return False

cs = CourseSchedule()
print(cs.canFinish(4, [[0,1],[1,0],[2,0],[3,1],[3,2]]))