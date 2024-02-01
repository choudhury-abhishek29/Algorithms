from typing import Optional
from tree.TreeNode import TreeNode

class IsSameBinaryTree:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        def dfs(p:Optional[TreeNode], q:Optional[TreeNode]) -> bool:
            if not p and not q:
                return True

            if not p or not q:
                return False

            if p.val != q.val:
                return False

            left = dfs(p.left, q.left)
            right = dfs(p.right, q.right)

            return (left and right)

        return dfs(p, q)