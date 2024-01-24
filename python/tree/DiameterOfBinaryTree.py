from typing import Optional
from tree.TreeNode import TreeNode


class DiameterOfBinaryTree:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        res = [0]

        def dfs(root: Optional[TreeNode]):
            if not root:
                return -1

            left = dfs(root.left)
            right = dfs(root.right)
            res[0] = max(res[0], 2+left+right)

            return 1 + max(left, right)

        dfs(root)
        return res[0]