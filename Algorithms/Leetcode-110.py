"""
LeetCode 110 平衡二叉树
"""
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
    
    def __str__(self):
        return str(self.val)

class Solution(object):
    def isBalanced(self, root): 
        if root == None:
            return True
        return self.helper(root) != -1

    def helper(self, node):
        if node == None:
            return 0
        left = self.helper(node.left)
        right = self.helper(node.right)
        if left == -1 or right == -1 or abs(left - right) > 1:
            return -1
        return max(left, right) + 1
    

if __name__ == "__main__":
    root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right.left = TreeNode(15)
    root.right.right = TreeNode(7)
    print(Solution().isBalanced(root))

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(3)
    root.left.left.left = TreeNode(4)
    root.left.left.right = TreeNode(4)
    print(Solution().isBalanced(root))


        

