"""
LeetCode-144. 二叉树的前序遍历

给定一个二叉树，返回它的 前序 遍历。

示例:

输入: [1, null, 2, 3, 4]
输出: [1, 2, 3, 4]
进阶: 递归算法很简单，你可以通过迭代算法完成吗?
"""
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
    
    def __str__(self):
        return str(self.val)
class Solution(object):

    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root: return []

        res = []
        stack = []

        while root or stack:
            while root:
                stack.append(root)
                res.append(root.val)
                root = root.left
            root = stack.pop()
            root = root.right
        return res

if __name__ == "__main__":
    sol = Solution()
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(7)
    print(sol.preorderTraversal(root))

