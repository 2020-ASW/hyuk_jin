package Algo_Study_Programmers;

import java.io.BufferedReader;

public class Solution_최고의집합 {

    public static int[] solution(int n, int s) {
        
    	if( n > s ) { 
    		return new int[] { -1 };
    	}
    	
    	int[] answer = new int[n];
    	
    	for(int i = 0; i < n; i++) {
    		answer[i] = s / n;
    	}
    	
    	for(int i = 0; i < s % n; i++) {
    		
    	}

        
        
        
        return answer;
    }
	public static void main(String[] args) {
		int n = 2;
		int s = 9;
		
		solution(n, s);
	}
}
