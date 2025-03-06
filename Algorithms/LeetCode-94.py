"""
LeetCode 94 中序遍历
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

什么是中序遍历：
中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。
若二叉树为空则结束返回，否则：
（1）中序遍历左子树
（2）访问根结点
（3）中序遍历右子树
如右图所示二叉树，中序遍历结果：DBEAFCGHI

""" 

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self):
        return str(self.val)

class Solution(object):

    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root: return []

        return self.inorderTraversal(root.left) + [root.val] + self.inorderTraversal(root.right)

    def inorderTraversal2(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root: return []
        stack = []
        res = []
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            res.append(root.val)
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
    print(sol.inorderTraversal2(root))