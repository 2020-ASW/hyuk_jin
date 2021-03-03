package Algo_Study_Programmers;

import java.util.Arrays;

public class Solution_입국심사 {
    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        Arrays.sort(times);
        
        long left = 0;
        long right = 0;
        
        for (int time : times) {
            if (time > right) {
                right = time;
            }
        }

        right *= n;
        
        long mid = 0;
        
        while(left <= right) {
        	long cnt = 0;
        	mid = (left + right) / 2;
        	
        	for(int time : times) {
        		cnt += (mid / time);
        	}
        	
        	if(cnt < n) {
        		left = mid + 1;
        	}
        	else {
        		if(mid <= answer) {
        			answer = mid;
        		}
        		right = mid - 1;
        	}
        }
        return answer;
    }
	public static void main(String[] args) {
		int n = 6;
		int[] times = new int[] { 7, 10 };
		
		System.out.println(solution(n, times));
	}
}
