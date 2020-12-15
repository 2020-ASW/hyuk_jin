package Algo_Study_LeetCode;

public class Solution_Container_With_Most_Water {
    public static int maxArea(int[] height) {
    	int max = 0;
    	int front = 0;
    	int back = height.length - 1;
    	
    	while(front < back) {
    		int col = back - front;
    		int row = Math.min(height[front], height[back]);
    		
    		max = Math.max(max, col * row);
    		
    		if(height[front] < height[back]) {
    			front++;
    		}
    		else {
    			back--;
    		}
    	}
    	return max;
    }
	public static void main(String[] args) {
		int[] height = new int[] { 1, 8, 6, 2, 5 , 4 , 8, 3 , 7 };
		System.out.println(maxArea(height));
	}
}
