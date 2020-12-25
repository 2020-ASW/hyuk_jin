package Algo_Study_LeetCode;

import java.util.LinkedList;
import java.util.*;

public class Solution_Median_of_Two_Sorted_Arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
    	int len = nums1.length + nums2.length;
    	
    	List<Integer> list = new LinkedList<Integer>();

    	for(int i = 0; i < nums1.length; i++) {
    		list.add(nums1[i]);
    	}
    	for(int i = 0; i < nums2.length; i++) {
    		list.add(nums2[i]);
    	}
    	Collections.sort(list);
    	
    	if(len % 2 == 0) {
    		return (float)(list.get(len / 2) + list.get((len / 2) - 1)) / 2;
    	}
    	return (float) list.get(len / 2);

    }
	public static void main(String[] args) {
		
		int[] nums1 = new int[] { 1,2 };
		int[] nums2 = new int[] { 3,4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
