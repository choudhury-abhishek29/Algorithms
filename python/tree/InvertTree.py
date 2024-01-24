from collections import deque
from typing import Optional
from tree.TreeNode import TreeNode


class InvertTree:
    # bfs solution
    # def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
    #     if not root:
    #         return root

    #     q = deque()
    #     q.append(root)

    #     while len(q) > 0:
    #         curr = q.popleft()
    #         temp = curr.left
    #         curr.left = curr.right
    #         curr.right = temp

    #         if curr.left:
    #             q.append(curr.left)
    #         if curr.right:
    #             q.append(curr.right)

    #     return root

    # dfs solution
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root

        tmp = root.left
        root.left = root.right
        root.right = tmp

        self.invertTree(root.left)
        self.invertTree(root.right)

        return root