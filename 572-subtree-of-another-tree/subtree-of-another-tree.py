# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        
        def isIdentical(n1, n2):
            if not n1 and not n2: return True
            if not n1 or not n2 or n1.val != n2.val: return False
            return isIdentical(n1.left, n2.left) and isIdentical(n1.right, n2.right)

        if not subRoot: return True
        if not root: return False
        
        if isIdentical(root, subRoot): return True
        
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)