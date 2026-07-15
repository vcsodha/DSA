# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.ans=0
        def get_height(node):
            if not node:
                return 0
            left_node=get_height(node.left)
            right_node=get_height(node.right)
            self.ans = max(self.ans, left_node + right_node)
            return 1+max(left_node,right_node)
        get_height(root)
        return self.ans