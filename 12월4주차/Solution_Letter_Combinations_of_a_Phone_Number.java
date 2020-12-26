package Algo_Study_LeetCode;

import java.util.*;

public class Solution_Letter_Combinations_of_a_Phone_Number {
	
	static List<String> output = new LinkedList<String>();
	static String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	static int len;
	public static void dfs(int cnt, String str, String digits) {

		if(cnt == len) {
			output.add(str);
			return;
		}
		String tmp = map[digits.charAt(cnt) - '0'];
		for(int i = 0; i < tmp.length(); i++) {
			dfs(cnt + 1, str + tmp.charAt(i), digits);
		}
		
	}
    public static List<String> letterCombinations(String digits) {
    
    	len = digits.length();
    	if(len == 0) {
    		return output;
    	}
    	dfs(0, "" , digits);
    	return output;
    }
	public static void main(String[] args) {
		
		String digits = "";
		System.out.println(letterCombinations(digits));
	}
}
