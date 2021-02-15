package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
	static int[][] map;
	static int N, M;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] {  0, 0, 1, -1};
	
	private static boolean isAllClear() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 || map[i][j] == 2) {
					map[i][j] = 1;
					cnt++;
				}
				else {
					map[i][j] = 0;
				}
			}
		}
		if(cnt == 0) {
			return true;
		}
		return false;
	}
	
	private static void dfs(int r, int c) {
		
		map[r][c] = -1;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
				if(map[nr][nc] == 0) {
					dfs(nr, nc);
				}
				else if(map[nr][nc] > 0) {
					map[nr][nc]++;
				}
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		int answer = 0;
		while(!isAllClear()) {
			dfs(0, 0);
			answer++;
		}
		System.out.println(answer);
	}
}
