from typing import Optional

from tree import TreeNode


class KthSmallestElementBST:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        def dfs(node: Optional[TreeNode], list:[int]) -> [int]:
            if node:
                dfs(node.left, list)
                list.append(node.val)
                dfs(node.right, list)
            return list
        sortedList = dfs(root, [])
        return sortedList[k-1]