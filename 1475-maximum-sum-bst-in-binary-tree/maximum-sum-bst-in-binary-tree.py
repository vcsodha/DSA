class Solution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        self.max_sum = 0
        
        # Returns (is_bst, min_val, max_val, sum_val)
        def traverse(node):
            if not node:
                # Base case: empty node is a BST, sum 0, range (-inf, inf)
                return True, float('inf'), float('-inf'), 0
            
            left_is_bst, left_min, left_max, left_sum = traverse(node.left)
            right_is_bst, right_min, right_max, right_sum = traverse(node.right)
            
            # Check if current node forms a BST with its children
            if left_is_bst and right_is_bst and left_max < node.val < right_min:
                current_sum = node.val + left_sum + right_sum
                self.max_sum = max(self.max_sum, current_sum)
                
                # New bounds for this subtree
                new_min = min(node.val, left_min)
                new_max = max(node.val, right_max)
                
                return True, new_min, new_max, current_sum
            
            # If not a BST, return False to parent
            return False, 0, 0, 0
        
        traverse(root)
        return self.max_sum