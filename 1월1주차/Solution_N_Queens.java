package Algo_Study_LeetCode;

import java.util.*;

public class Solution_N_Queens {
	static int[] col;
	static int N;
	static List<List<String>> list = new LinkedList<List<String>>();
	
	private static boolean isOk(int i) {
		for (int j = 0; j < i; j++) {
			if (col[j] == col[i] || Math.abs(col[i] - col[j]) == (i - j))
				return false;
		}
		return true;
	}
    public static List<List<String>> solveNQueens(int n) {

    	if(n == N) {
    		List<String> tmp = new LinkedList<String>();
    		for(int i = 0; i < col.length; i++) {
    			String t = "";
    			for(int j = 0; j < col.length; j++) {
    				if(j == col[i]) {
    					t += "Q"; 
    				}
    				else {
    					t += ".";
    				}
    			}
    			tmp.add(t);
    		}
    		list.add(tmp);
    	}
    	else {
    		for(int j = 0; j < N; j++) {
    			col[n] = j;
    			if(isOk(n)) {
    				solveNQueens(n + 1);
    			}
    		}
    	}
		return list;
    }

	public static void main(String[] args) {
		N = 1;
		col = new int[N];
		System.out.println(solveNQueens(0));
	}
}
