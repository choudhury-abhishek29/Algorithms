import collections
from typing import List


class NumberOfIsland:
    def numIslands(self, grid: List[List[str]]) -> int:
        numIslands=0
        rows = len(grid)
        cols = len(grid[0])
        visited = set()

        def bfs(row, col):
            q = collections.deque()
            visited.add((row, col))
            q.append((row, col))

            while q:
                cr, cc = q.popleft()
                directions = [[1,0],[-1,0],[0,1],[0,-1]]
                for dr, dc in directions:
                    nr = cr+dr
                    nc = cc+dc
                    if ((nr) in range(rows) and (nc) in range(cols) and grid[nr][nc]=="1" and (nr, nc) not in visited):
                        q.append((nr, nc))
                        visited.add((nr, nc))

        def dfs(row, col, grid):
            if row<0 or row>=len(grid) or col<0 or col>=len(grid[0]) or grid[row][col]=="0" or (row, col) in visited:
                return 0
            else:
                visited.add((row, col))
                dfs(row+1, col, grid)
                dfs(row, col+1, grid)
                dfs(row-1, col, grid)
                dfs(row, col-1, grid)
                return 1

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == "1" and (r,c) not in visited:
                    bfs(r,c)
                    numIslands+=1
                # numIslands+=dfs(r, c, grid)


        return numIslands;

ni = NumberOfIsland()
grid=[["1","1","0","0","0"],
     ["1","1","0","0","0"],
     ["0","0","1","0","0"],
     ["0","0","0","1","1"]]
# grid = [["1"],["1"]]
num = ni.numIslands(grid)

print(num)