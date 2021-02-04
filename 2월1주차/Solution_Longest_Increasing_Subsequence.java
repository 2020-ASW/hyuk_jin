package Algo_Study_LeetCode;

public class Solution_Longest_Increasing_Subsequence {
	
	private static int search(int[] dp, int len, int target) {
		int left = 0;
		int right = len - 1;
		
		if(dp[right] < target) {
			return len;
		}
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(dp[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return right;
	}
    public static int lengthOfLIS(int[] nums) {
        
    	if(nums.length == 1) {
    		return 1;
    	}
    	int[] dp = new int[nums.length];
    	
    	
    	dp[0] = nums[0];
    	
    	int len = 1;
    	for(int i = 1; i < nums.length; i++) {
    		int idx = search(dp, len , nums[i]);
    		dp[idx] = nums[i];
    		
    		if(idx == len) {
    			len++;
    		}
    	}
    	return len;
    }
	public static void main(String[] args) {
		int[] nums = new int[] {10,9,2,5,3,7,101,18};
		lengthOfLIS(nums);
	}
}
