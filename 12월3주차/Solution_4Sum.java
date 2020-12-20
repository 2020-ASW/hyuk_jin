package Algo_Study_LeetCode;

import java.util.*;
public class Solution_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
		
    	List<List<Integer>> list = new LinkedList<List<Integer>>();
    	Arrays.sort(nums);
    	
    	if(nums.length < 4) {
    		return list;
    	}
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(i > 0 && nums[i] == nums[i - 1]) {
    			continue;
    		}
    		int num1 = nums[i];
    		
    		for(int j = i + 1; j < nums.length; j++) {
    			
    			if(j > i + 1 && nums[j] == nums[j-1]) {
    				continue;
    			}
    			int num2 = nums[j];
    			
    			int start = j + 1;
    			int end = nums.length - 1;
    			
    			while(start < end) {
    				int num3 = nums[start];
    				int num4 = nums[end];
    				
    				if(num1 + num2 + num3 + num4 == target) {
    					List<Integer> tmp = new LinkedList<Integer>();
    					tmp.add(num1);
    					tmp.add(num2);
    					tmp.add(num3);
    					tmp.add(num4);
    					list.add(tmp);
    					start++;
    					end--;
    					while(start < end && nums[start] == nums[start - 1]) {
    						start++;
    					}
    					while(start < end && nums[end] == nums[end + 1]) {
    						end--;
    					}
    				}
    				else if(num1 + num2 + num3 + num4 < target) {
    					start++;
    					while(start < end && nums[start] == nums[start - 1]) {
    						start++;
    					}
    				}
    				else {
    					end--;
    					while(start < end && nums[end] == nums[end + 1]) {
    						end--;
    					}
    				}
    			}
    		}
    	}
    	
    	return list;
    }
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 0, -1, 0, -2 , 2 };
		int target = 0;
		
		System.out.println(fourSum(nums, target));
	}
}
