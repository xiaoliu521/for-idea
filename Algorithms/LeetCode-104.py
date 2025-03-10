""" 
LeetCode-104. Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.
"""
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self):
        return str(self.val)    


class Solution(object):
    def maxDepth(self, root):
        if not root:
            return 0
        else:
            return max(self.maxDepth(root.left), self.maxDepth(root.right) + 1)

    def maxDepth2(self, root):
        if not root: return 0
        stack = [(root, 1)]
        res = 0
        while stack:
            node, depth = stack.pop()
            res = max(res, depth)
            if node.left:
                stack.append((node.left, depth + 1))
            if node.right:
                stack.append((node.right, depth + 1 ))
        return res

    def maxDepth3(self, root):
        if not root: return 0
        queue = [root]
        res = 0
        while queue:
            res += 1
            for _ in range(len(queue)):
                node = queue.pop(0)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return res


if __name__ == "__main__":
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)
    print(Solution().maxDepth(root))
    print(Solution().maxDepth2(root))
    print(Solution().maxDepth3(root))