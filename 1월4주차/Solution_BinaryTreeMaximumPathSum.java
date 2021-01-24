package Algo_Study_LeetCode;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution_BinaryTreeMaximumPathSum {
	
	static int maxSum = Integer.MIN_VALUE;
	
	private static int findMaxSum(TreeNode node) {
		if(node == null) {
			return 0;
		}
		
		int left = Math.max(0, findMaxSum(node.left));
		int right = Math.max(0, findMaxSum(node.right));
		
		maxSum = Math.max(maxSum, left + right + node.val);
		
		return Math.max(left + node.val, right + node.val);
	}

    public static int maxPathSum(TreeNode root) {
        
    	if(root == null) {
    		return 0;
    	}
    	findMaxSum(root);
    	
    	return maxSum;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2, null, null);
		root.right = new TreeNode(3, null, null);
		
		System.out.println(maxPathSum(root));
	}
}
