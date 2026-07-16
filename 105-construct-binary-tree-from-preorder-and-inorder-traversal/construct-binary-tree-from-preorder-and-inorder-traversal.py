# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        #preorder: root,left,right
        #inorder: left,root,right

        inorder_map={val: i for i, val in enumerate(inorder)}
        self.pre_idx=0

        def helper(start,end):
            if start>end:
                return None
            root_val = preorder[self.pre_idx]
            root = TreeNode(root_val)
            self.pre_idx += 1

            in_idx = inorder_map[root_val]

            root.left=helper(start,in_idx-1)
            root.right=helper(in_idx+1,end)

            return root
        
        return helper(0,len(inorder) -1)
