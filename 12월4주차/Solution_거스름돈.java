package Algo_Study_Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_거스름돈 {
    public static int solution(int n, int[] money) {
        
        long[] pay = new long[n + 1];
        Arrays.sort(money);
        
        pay[0] = 1;
        for(int i = 0; i < money.length; i++) {
        	for(int j = money[i]; j <= n; j++) {
        		pay[j] = pay[j] + pay[j - money[i]];
        	}
        }
        return (int) (pay[n] % 1000000007);
    }
	public static void main(String[] args) {
		
		int N = 5;
		int[] money = new int[] { 1, 2, 5 };
		
		solution(N, money);
	}
}
