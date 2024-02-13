from typing import Optional
from tree import TreeNode


class ValidBinaryTree:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        def dfs(node: Optional[TreeNode], min: int, max: int) -> bool:
            if not node:
                return True

            if not (min < node.val < max):
                return False

            return dfs(node.left, min, node.val) and dfs(node.right, node.val, max)

        return dfs(root, float("-inf"), float("inf"))