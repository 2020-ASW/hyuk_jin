package Algo_Study_SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_선표의축구경기예측 {
	// nCr => nPr / r!  ||  nPr => n * (n-1) --- ( n - r + 1)  
	private static double combination(int n, int r) {
		
		double numerator = 1;
		
		for(double i = 0; i < r; i++) {
			numerator *= (n - i); 
		}
		
		double denominator = 1;
		for(double i = r; i > 0; i--) {
			denominator *= i;
		}
		return numerator / denominator;
	}
	static int[] notDecimal = new int[] { 0,1,4,6,8,9,10,12,14,15,16,18,20,21,22,24,25,26,27,28,30 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			double aTeamPercen = (double) Integer.parseInt(str.nextToken()) / 100;
			double bTeamPercen = (double) Integer.parseInt(str.nextToken()) / 100;
			
			double sum = 0;
			
			for(int i = 0; i < notDecimal.length; i++) {
				for(int j = 0; j < notDecimal.length; j++) {
					double aTeam = combination(30, notDecimal[i]) * Math.pow(aTeamPercen, notDecimal[i]) * Math.pow(1 - aTeamPercen, 30 - notDecimal[i]);
					double bTeam = combination(30, notDecimal[j]) * Math.pow(bTeamPercen, notDecimal[j]) * Math.pow(1 - bTeamPercen, 30 - notDecimal[j]);
					sum += (aTeam * bTeam);
				}
			}
			// 적어도 하나가 소수일 확률 => 전체 - 둘다 소수가 아닌경우
			System.out.printf("#%d %.5f", TC,  (1 - sum));
		}
	}
}
