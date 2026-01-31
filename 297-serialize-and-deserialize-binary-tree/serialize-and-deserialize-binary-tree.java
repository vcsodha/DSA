/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        String s="";
        if(root==null) return "N,";
        s=s+root.val+",";
        s+=serialize(root.left);
        s+=serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    int i=0;
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return insert(arr);
    }

    private TreeNode insert(String[] arr) {
       
        if (i==arr.length ||arr[i].equals("N")) {
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
        i++;
        node.left = insert(arr);
        node.right = insert(arr);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));