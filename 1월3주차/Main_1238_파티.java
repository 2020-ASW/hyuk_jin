package Algo_Study_BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1238_파티 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken()); // 학생 수(노드)
		int M = Integer.parseInt(str.nextToken()); // 도로 수(간선)
		int X = Integer.parseInt(str.nextToken()); // 축제하는 마을
		
		int[][] map = new int[N + 1][N + 1]; // 비용 배열
		int[] dist = new int[N + 1]; // 거리 배열
		boolean[] check = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE / 2;
		}
		
		for(int i = 0; i < M; i++) {
			str = new StringTokenizer(br.readLine());
			
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			int distance = Integer.parseInt(str.nextToken());
			
			map[st][ed] = distance;
		}
		//축제 마을에서 각 집으로 돌아가는 거리먼저 측정
		dist[X] = 0;
		check[X] = true;
		
		for(int i = 1; i <= N; i++) {
			if(!check[i] && map[X][i] != 0) {
				dist[i] = map[X][i];
			}
		}
		
		for(int k = 0; k < N - 1; k++) {
			int min = Integer.MAX_VALUE / 2;
			int min_idx = -1;
			
			for(int i = 1; i <= N; i++) {
				if(!check[i] && dist[i] != Integer.MAX_VALUE / 2) {
					if(dist[i] < min) {
						min = dist[i];
						min_idx = i;
					}
				}
			}
			check[min_idx] = true;
			
			for(int i = 1; i <= N; i++) {
				if(!check[i] && map[min_idx][i] != 0) {
					if(dist[i] > dist[min_idx] + map[min_idx][i]) {
						dist[i] = dist[min_idx] + map[min_idx][i];
					}
				}
			}
		}
		
		for(int g = 1; g <= N; g++) {
			if(g == X) {
				continue;
			}
			
			int[] distance2 = new int[N + 1];
			check = new boolean[N + 1];
			
			for(int i = 1; i <= N; i++) {
				distance2[i] = Integer.MAX_VALUE / 2;
			}
			
			distance2[g] = 0;
			check[g] = true;
			
			for(int i = 1; i <= N; i++) {
				if(!check[i] && map[g][i] != 0) {
					distance2[i] = map[g][i];
				}
			}

			for(int k = 0; k < N - 1; k++) {
				int min2 = Integer.MAX_VALUE / 2;
				int min_idx2 = -1;
				
				for(int i = 1; i <= N; i++) {
					if(!check[i] && distance2[i] != Integer.MAX_VALUE / 2) {
						if(distance2[i] < min2) {
							min2 = distance2[i];
							min_idx2 = i;
						}
					}
				}
				
				check[min_idx2] = true;
				
				for(int i = 1; i <= N; i++) {
					if(!check[i] && map[min_idx2][i] != 0) {
						if(distance2[i] > distance2[min_idx2] + map[min_idx2][i]) {
							distance2[i] = distance2[min_idx2] + map[min_idx2][i];
						}
					}
				}
			}
			dist[g] += distance2[X];
		}
		int max = 0;
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, dist[i]);
		}
		System.out.println(max);
	}
}
