from typing import Optional

from tree.TreeNode import TreeNode


class BalancedBinaryTree:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        def dfs(node: Optional[TreeNode]) -> int:
            if not node:
                return 0

            return 1 + max(dfs(node.left), dfs(node.right))

        return (abs(dfs(root.left) - dfs(root.right)) < 2
                and BalancedBinaryTree.isBalanced(self, root.left)
                and BalancedBinaryTree.isBalanced(self, root.right))
