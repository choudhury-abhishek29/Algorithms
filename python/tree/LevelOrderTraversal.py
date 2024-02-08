from collections import deque
from typing import Optional, List

from tree import TreeNode


class LevelOrderTraversal:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return root

        res = []

        q = deque()
        q.append(root)

        while len(q) > 0:
            size = len(q)
            temp = []
            for i in range(size):
                curr = q.popleft()
                temp.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(temp)

        return res