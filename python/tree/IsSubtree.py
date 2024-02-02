from typing import Optional
from tree.TreeNode import TreeNode


class IsSubtree:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not root:
            return False

        if not subRoot:
            return True

        if self.isIdentical(root, subRoot):
            return True

        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    def isIdentical(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        if (root1 is None) or (root2 is None):
            return (root1 is None) and (root2 is None)

        return root1.val == root2.val and self.isIdentical(root1.left, root2.left) and self.isIdentical(root1.right, root2.right)