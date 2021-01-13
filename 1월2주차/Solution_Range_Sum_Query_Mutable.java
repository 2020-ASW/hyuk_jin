package Algo_Study_LeetCode;

public class Solution_Range_Sum_Query_Mutable {

	static class NumArray {
		private int[] nums;

		public NumArray(int[] nums) {
			this.nums = nums;
		}

		public void update(int i, int val) {
			nums[i] = val;
		}

		public int sumRange(int i, int j) {

			int sum = 0;

			for(int k = i; k <= j; k++) {
				sum += nums[k];
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		NumArray nums = new NumArray(new int[] { 1, 3, 5 });

		System.out.println(nums.sumRange(0, 2));
		nums.update(1, 2);
		System.out.println(nums.sumRange(0, 2));
	}
}
