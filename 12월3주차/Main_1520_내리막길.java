package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main_1520_내리막길 {
	static int[] dx = { 1, 0 , - 1, 0};
	static int[] dy = { 0 , 1,  0 , -1};
	static int[][] map;
	static int[][] check;
	static int M, N;
	
	private static int dfs(int x, int y) {
		if(x == 0 && y == 0) {
			return 1;
		}
		
		if(check[x][y] == -1) {
			check[x][y] = 0;
			
			for(int i = 0; i < 4; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;
				
				if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if(map[x][y] < map[nx][ny]) {
						check[x][y] += dfs(nx, ny);
					}
				}
			}
		}
		return check[x][y];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(str.nextToken());
		N = Integer.parseInt(str.nextToken());
		
		map = new int[M][N];
		check = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(tmp.nextToken());
				check[i][j] = -1;
			}
		}
        int result = dfs(M - 1, N - 1);
        System.out.println(result);
	}
}
