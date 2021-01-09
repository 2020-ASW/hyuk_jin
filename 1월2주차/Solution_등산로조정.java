package Algo_Study_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_등산로조정 {
	static int N, K;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = new int[] { -1 , 1, 0 , 0 };
	static int[] dy = new int[] { 0, 0, -1 , 1};
	static int result , maxHeight = 0;
	
	private static void dfs(int r, int c, int height, int len, boolean check) {
		
		if(result <= len) {
			result = len;
		}
		for(int i = 0; i < 4; i++) {
			
			int nr = r + dx[i];
			int nc = c + dy[i];
			
			// 방문은 가능한데
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visit[nr][nc]) {
				
				// 높이 떄문에 못가는 거면
				if(map[nr][nc] >= height) {
					if(check == false) {
						if(map[nr][nc] - K < height) {
							visit[nr][nc] = true;
							check = true;
							dfs(nr, nc, height - 1, len + 1 , check);
							visit[nr][nc] = false;
						}
					}
				}
				else {
					visit[nr][nc] = true;
					dfs(nr, nc , map[nr][nc], len + 1, check);
					visit[nr][nc] = false;
				}
			}
		}
	}
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());
			
			map = new int[N][N];
			visit = new boolean[N][N];
			maxHeight = 0;
			result = 0;
			for(int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
					if(map[i][j] > maxHeight) {
						maxHeight = map[i][j];
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == maxHeight) {
						visit[i][j] = true;
						dfs(i, j ,maxHeight, 1, false);
						visit[i][j] = false;
					}
				}
			}
			System.out.print("#" + tc + " " + result);
		} 
	}
}
