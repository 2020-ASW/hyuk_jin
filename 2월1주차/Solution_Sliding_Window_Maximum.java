package Algo_Study_LeetCode;

import java.util.*;

public class Solution_Sliding_Window_Maximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
    	
    	int[] answer = new int[nums.length - k + 1];
    	
    	if(nums.length == 0 || k == 0) {
    		return new int[0];
    	}
    	Deque<Integer> queue = new LinkedList<>();
    	
    	for(int i = 0; i < nums.length; i++) {
    		
    		while(!queue.isEmpty() && queue.peekFirst() <= i - k) {
    			queue.pollFirst();
    		}
    		
    		while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
    			queue.pollLast();
    		}
    		
    		queue.add(i);
    		
    		if(i >= k - 1) {
    			answer[i - k + 1] = nums[queue.peekFirst()];
    		}
    	}
    	return answer;
    }
    
	public static void main(String[] args) {
		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
		int k = 3;
		maxSlidingWindow(nums, k);
	}
}
