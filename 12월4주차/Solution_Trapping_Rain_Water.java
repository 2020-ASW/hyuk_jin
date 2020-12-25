package Algo_Study_LeetCode;

public class Solution_Trapping_Rain_Water {
	public static int trap(int[] height) {

		int len = height.length;
		int result = 0;

		int[] lview = new int[len]; // 왼쪽에서 보았을 때
		int[] rview = new int[len]; // 오른쪽에서 보았을 때

		lview[0] = height[0];
		rview[len - 1] = height[len - 1];

		for (int i = 1; i < len; i++) {
			lview[i] = Math.max(lview[i - 1], height[i]);
		}

		for (int i = len - 2; i >= 0; i--) {
			rview[i] = Math.max(rview[i + 1], height[i]);
		}

		for (int i = 0; i < len; i++) {
			result += Math.min(lview[i], rview[i]) - height[i];
		}
		return result;
	}

	public static void main(String[] args) {

		int[] height = new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 };
		System.out.println(trap(height));
	}
}
