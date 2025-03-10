"""
LeetCode-101. Symmetric Tree
给定一个二叉树，检查它是否是镜像对称的。
"""
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self):
        return str(self.val)

class Solution(object):
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.isSymmetric(root.left, root.right)

    def isSymmetric(self, left, right):
        if not left and not right:
            return True
        if not left or not right:
            return False
        if left.val != right.val:
            return False
        return self.isSymmetric(left.left, right.right) and self.isSymmetric(left.right, right.left)