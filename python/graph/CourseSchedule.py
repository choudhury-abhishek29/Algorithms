def canFinish(numCourses, prerequisites):
    preMap = { i : [] for i in range(len(prerequisites))}
    print(preMap)

canFinish(5, [[1,0],[2,0],[3,1],[3,2]])