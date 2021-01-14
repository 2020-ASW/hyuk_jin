package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	static int[] dx = new int[] { -1, 1, 2, 2, 1, -1, -2, -2, 1, -1, 0, 0 };
	static int[] dy = new int[] {  2, 2, 1, -1, -2, -2, -1, 1, 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(str.nextToken());
		int N = Integer.parseInt(str.nextToken());
		
		int[][] map = new int[N][M];
		boolean[][][] visit = new boolean[31][N][M];
		
		for(int i = 0; i < N; i++) {
			str = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {0, 0, K, 0});
		visit[K][0][0] = true;
		int sol = -1;
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			
			if(tmp[0] == N -1 && tmp[1] == M - 1) {
				sol = tmp[3];
				break;
			}
			
			int k = 8;
			if(tmp[2] > 0) {
				k = 0;
			}
			
			for(int i = k; i < 12; i++) {
				int nr = tmp[0] + dx[i];
				int nc = tmp[1] + dy[i];
				
				if(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
					if(i >= 8) {
						if(!visit[tmp[2]][nr][nc]) {
							visit[tmp[2]][nr][nc] = true;
							queue.add(new int[] { nr, nc , tmp[2], tmp[3] + 1});
						}
					}
					else {
						if(!visit[tmp[2]-1][nr][nc]) {
							visit[tmp[2]-1][nr][nc] = true;
							queue.add(new int[] { nr, nc, tmp[2] - 1, tmp[3] + 1});
						}
					}
				}
			}
		}
		System.out.println(sol);
	}
}
