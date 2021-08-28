package main.java.coding.tree;

public class ConstructMaximumBinaryTree {

    public static void main(String[] args) {
        TreeNode node =  constructMaximumBinaryTree(new int[] {3,2,1,6,0,5});
        System.out.println(node);
    }

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }


    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = null;
        // find maximum element
        // build root
        // push root to stack
        // find left max
        // build left root
        // find right max
        // build right root
        return constructMaximumBinaryTree(root,nums,0,nums.length-1);
    }

    public static TreeNode constructMaximumBinaryTree(TreeNode root, int[] nums, int a, int b) {
        if(b<a) return root;
        int max = a;
        for(int i=a+1; i<=b; i++){
            if(nums[max]<nums[i])
                max=i;
        }

        root = new TreeNode(nums[max]);

        root.left = constructMaximumBinaryTree(root.left, nums,a,max-1);
        root.right = constructMaximumBinaryTree(root.right, nums,max+1,b);
        return root;
    }
}
