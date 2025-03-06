"""
LeetCode-145. 二叉树的后序遍历
"""
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self):
        return str(self.val)


class Solution(object):
    
    def postorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root: return []

        stack = []
        res = []
        prevAccess = None

        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if not root.right or root.right == prevAccess:
                res.append(root.val)
                prevAccess = root
                root = None
            else:
                stack.append(root)
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
    print(sol.postorderTraversal(root))
