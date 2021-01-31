package Algo_Study_BOJ;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17071_숨바꼭질5 {
	static int[][] visit = new int[2][500001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		Arrays.fill(visit[0], -1);
		Arrays.fill(visit[1], -1);
		
		visit[0][N] = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		int time = 0;
		
		if(N == K) {
			System.out.println(0);
			return;
		}
		while(!queue.isEmpty()) {
			
			int len = queue.size();
			time++;
			int mod = time % 2;

			for(int i = 0; i < len; i++) {
				int tmp = queue.poll();
				
				if(tmp - 1 >= 0) {
					if(visit[mod][tmp - 1] == -1) {
						queue.add(tmp - 1);
						visit[mod][tmp - 1] = time;
					}
				}
				
				if(tmp + 1 <= 500000) {
					if(visit[mod][tmp + 1] == - 1) {
						queue.add(tmp + 1);
						visit[mod][tmp + 1] = time;
					}
				}
				
				if(tmp * 2 <= 500000) {
					if(visit[mod][tmp * 2] == - 1) {
						queue.add(tmp * 2);
						visit[mod][tmp * 2] = time;
					}
				}
			}
			
			int find = K + (time * ( time + 1) / 2);
			if(find > 500000) {
				break;
			}
			if(visit[mod][find] != -1) {
				System.out.println(time);
				return;
			}
		}
		System.out.println(-1);
		return;
	}
}
