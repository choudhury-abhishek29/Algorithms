from tree.TreeNode import TreeNode


class NumberOfGoodNodes:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(curr, maxVal):
            if not curr:
                return 0

            res = 1 if curr.val >= maxVal else 0
            maxVal = max(curr.val, maxVal)
            res += dfs(curr.left, maxVal)
            res += dfs(curr.right, maxVal)

            return res

        return dfs(root, -999999)