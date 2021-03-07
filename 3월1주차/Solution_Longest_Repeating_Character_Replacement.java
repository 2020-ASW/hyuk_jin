package Algo_Study_LeetCode;

import java.util.Arrays;

public class Solution_Longest_Repeating_Character_Replacement {
	
    public static int characterReplacement(String s, int k) {
        
    	int left = 0;
    	
    	int[] charMap = new int[26];
    	int maxCount = 0;
    	int maxLen = 0;
    	
    	for(int right = 0; right < s.length(); right++) {
    		
    		int size = right - left + 1;
    		
    		int idx = s.charAt(right) - 'A';
    		
    		charMap[idx]++;
    		maxCount = Arrays.stream(charMap).max().getAsInt();
    		while(size - maxCount > k) {
    			charMap[s.charAt(left) - 'A']--;
    			left++;
    			
    			size = right - left + 1;
    			
    			Arrays.stream(charMap).max().getAsInt();
    		}
    		maxLen = Math.max(maxLen, size);
    	}
    
    	return maxLen;
    }
	public static void main(String[] args) {
		String s = "ABAB";
		int k = 2;
		
		System.out.println(characterReplacement(s, k));
	}
}
