package Algo_Study_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_햄버거다이어트 {
	static int[] score;
	static int[] kcal;
	static int N, L, result;
	
	private static void dfs(int cnt, int point, int cal) {
		if(cal > L) {
			// 제한 칼로리를 초과한 경우
			return;
		}
		if(cnt == N) {
			// 모두 확인한 경우 현재 최대값과 비교
			result = Math.max(result, point);
			return;
		}
		dfs(cnt + 1, point + score[cnt], cal + kcal[cnt]); // cnt 번째 음식을 포함하는경우
		dfs(cnt + 1, point, cal); // cnt 번째 음식을 포함하지 않은 경우
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(str.nextToken());
			L = Integer.parseInt(str.nextToken());
			
			score = new int[N];
			kcal = new int[N];
			
			for(int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(str.nextToken());
				kcal[i] = Integer.parseInt(str.nextToken());
			}
			result = 0;
			dfs(0, 0, 0);
			
			System.out.println("#" + T + " " + result);
		} 
	}

}
