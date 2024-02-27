from typing import List


class DiagonalSort:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        diag_lib = {}
        for row in range(len(mat)):
            for col in range(len(mat[0])):
                print("["+str(row)+":"+str(col)+"] : "+str(mat[row][col]))
                if row-col in diag_lib:
                    diag = diag_lib[row-col]
                    diag.append(mat[row][col])
                    diag.sort()
                    diag_lib[row - col] = diag
                else:
                    diag = [mat[row][col]]
                    diag_lib[row - col] = diag

        for row in range(len(mat)):
            col: int
            for col in range(len(mat[0])):
                mat[row][col] = diag_lib[row - col].pop(0)

        print(mat)

ds = DiagonalSort()
mat = [[3,3,1,1],
       [2,2,1,2],
       [1,1,1,2]]
ds.diagonalSort(mat)