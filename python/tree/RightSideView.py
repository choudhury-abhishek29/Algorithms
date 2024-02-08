from typing import List
from typing import Optional
from collections import deque
from tree import TreeNode


class RightSideView:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root:
            return res

        q = deque()
        q.append(root)

        while (len(q) > 0):
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if i == 0:
                    res.append(curr.val)

                if curr.right:
                    q.append(curr.right)
                if curr.left:
                    q.append(curr.left)

        return res