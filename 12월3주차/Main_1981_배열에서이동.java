package Algo_Study_BOJ;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_1981_배열에서이동 {
	static int[] dx;
	static int[] dy;
	static int N;
	static int min, max;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Point> queue;
	private static void clear() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				visit[i][j] = false;
			}
		}
		queue.clear();
	}

	private static boolean bfs(int mid) {
		for(int k = min; k <= max - mid; k++) {
			
			clear(); // 초기화
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] < k) {
						visit[i][j] = true;
					}
					else if(map[i][j] >= k && map[i][j] <= k + mid) {
						visit[i][j] = false;
					}
					else{
						visit[i][j] = true;
					}
				}
			}
			if(visit[0][0]) {
				continue;
			}
			visit[0][0] = true;
			
			queue.add(new Point(0,0));
			
			while(!queue.isEmpty()) {
				Point tmp = queue.poll();
				int x = tmp.x;
				int y = tmp.y;
				
				if(x == (N - 1) && y == (N - 1)) {
					return true;
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]) {
						visit[nx][ny] = true;
						queue.add(new Point(nx, ny));
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dx = new int[] { -1, 0, 1, 0 };
		dy = new int[] { 0, 1, 0, -1 };
		
		map = new int[N][N];
		visit = new boolean[N][N];
		queue = new LinkedList<Point>();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		int start = 0; // 시작값
		int end = max - min; // 입력받으면서 받는 차이의 최대값
		
		while(start <= end) {
			int mid = (start + end) / 2;
			// 중간값 수치의 차이로 갈 수 있는지 탐색
			if(bfs(mid)) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println(end + 1);
	}
}
