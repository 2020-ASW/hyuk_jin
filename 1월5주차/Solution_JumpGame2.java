package Algo_Study_LeetCode;

public class Solution_JumpGame2 {

	public static int jump(int[] nums) {

		int jump_cnt = 0;
		
		int curMax = 0;
		
		int nextMax = 0;
		
		for(int i = 0; i < nums.length - 1; i++) {
			
			// 지금 시점에서 봤을 때 가장 크게 갈 수 있는 값
			nextMax = Math.max(nextMax, i + nums[i]);
			
			// 크게 갈 수 있는 범위까지 가면서 다음 점프로 가장 크게 갈 수 있는 범위 갱신
			if(i == curMax) {
				jump_cnt++;
				curMax = nextMax;	
			}
			
		}
		return jump_cnt;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 1 };
		System.out.println(jump(nums));
	}
}
