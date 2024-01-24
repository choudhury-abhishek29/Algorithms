from collections import deque

from tree.TreeNode import TreeNode


class TreeTraversal:
    def bfsTraversal(self, root : [TreeNode]):
        q = deque()
        q.append(root)

        while len(q)>0:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                print(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)

    def dfsTraversal(self, root : [TreeNode], nodes : int):
        if root:
            print(root.val)
            nodes = max(nodes, nodes+1)
            self.dfsTraversal(root.left, nodes)
            self.dfsTraversal(root.right, nodes)
        print('nodes so far : '+str(nodes))







node1 = TreeNode(1)
node2 = TreeNode(2)
node3 = TreeNode(3)
node4 = TreeNode(4)
node5 = TreeNode(5)
node6 = TreeNode(6)

node1.left = node2
node2.left = node3
node2.right = node4
node3.left = node5
node4.right = node6

tt = TreeTraversal()
# tt.bfsTraversal(node1)
tt.dfsTraversal(node1, 0)

