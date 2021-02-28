package Algo_Study_LeetCode;

import java.util.*;

class Node {
	int val;
	int index;
	int listIndex;
	
	public Node(int val, int index, int listIndex) {
		this.val = val;
		this.index = index;
		this.listIndex = listIndex;
	}
}
public class Solution_Smallest_Range_Covering_Elements_from_K_Lists {
    public static int[] smallestRange(List<List<Integer>> nums) {
    	
    	PriorityQueue<Node> minHeap = new PriorityQueue<Node>((a,b) -> (a.val - b.val));
    	
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	for(List<Integer> numList : nums) {
    		if(numList.size() != 0) {
    			minHeap.add(new Node(numList.get(0), nums.indexOf(numList), 0));
    			max = Math.max(numList.get(0), max);
    		}
    		else {
    			return new int[] { -1, 1};
    		}
     	}
    	
    	int st = -1, ed = -1;
    	int range = Integer.MAX_VALUE;
    	
    	while(minHeap.size() == nums.size()) {
    		Node cur = minHeap.poll();
    		
    		if(max - cur.val < range) {
    			range = max - cur.val;
    			st = cur.val;
    			ed = max;
    		}
    		
    		if(cur.listIndex < nums.get(cur.index).size() - 1) {
    			cur.listIndex++;
    			
    			cur.val = nums.get(cur.index).get(cur.listIndex);
    			
    			if(cur.val > max) {
    				max = cur.val;
    			}
    			
    			minHeap.add(cur);
    		}
    	}
    	return new int[] { st, ed };
    }
	
	public static void main(String[] args) {
		List<List<Integer>> nums;
		
		nums = new ArrayList<List<Integer>>();
		
		for(int i = 0; i < 3; i++) {
			nums.add(new ArrayList<>());
		}
		
		nums.get(0).add(4);
		nums.get(0).add(10);
		nums.get(0).add(15);
		nums.get(0).add(24);
		nums.get(0).add(26);
		
		nums.get(1).add(0);
		nums.get(1).add(9);
		nums.get(1).add(12);
		nums.get(1).add(20);
		
		nums.get(2).add(5);
		nums.get(2).add(18);
		nums.get(2).add(22);
		nums.get(2).add(30);			
		
		smallestRange(nums);
	}
}
