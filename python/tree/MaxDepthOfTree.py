from collections import deque
from typing import Optional

from tree.TreeNode import TreeNode

class MaxDepthOfTree:
    #DFS Solution
    def maxDepthDFS(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

        # BFS Solution
    def maxDepthBFS(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        level = 0
        q = deque()
        q.append(root)
        while len(q) > 0:
            level += 1
            size = len(q)
            for i in range(size):
                curr = q.popleft()

                if curr.left:
                    q.append(curr.left)

                if curr.right:
                    q.append(curr.right)

        return level