package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1915_가장큰정사각형 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken()); // N
		int M = Integer.parseInt(str.nextToken()); // M
		
		int[][] map = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];
		for(int i = 1; i <= N; i++) {
			String tmp = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = tmp.charAt(j - 1) - '0';
			}
		}
		int max = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == 1) {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;

					max = Math.max(dp[i][j], max);
				}
			}
		}
		System.out.println(max * max);
	}
	
}
