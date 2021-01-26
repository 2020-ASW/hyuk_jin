package Algo_Study_LeetCode;

public class Solution_Target_Sum {
	static int answer;
	static int[] num_arr;
	static int target;
	static int N;
	private static void dfs(int[] nums, int cnt, int sum) {
		
		if(cnt == N) {
			
			if(sum == target) {
				answer++;
				return;
			}
		}
		else {
			dfs(nums, cnt + 1, sum + nums[cnt]);
			dfs(nums, cnt + 1, sum - nums[cnt]);
		}
	}
    public static int findTargetSumWays(int[] nums, int S) {
        answer = 0;    	
        target = S;
        N = nums.length;
        
        dfs(nums, 0, 0);
        
    	return answer;
    }
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 1, 1 };
		int S = 3;
 		
		System.out.println(findTargetSumWays(nums, S));
	}
}
