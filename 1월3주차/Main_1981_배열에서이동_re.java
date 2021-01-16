package retry01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
import java.awt.*;

public class Main_1981_배열에서이동_re {
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] {  0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visit;
	static int N;
	private static boolean bfs(int min, int max , int mid) {
		for(int k = min; k <= max - mid; k++) {
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					visit[i][j] = false;
				}
			}
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] < k) {
						visit[i][j] = true;
					}
					else if(map[i][j] <= k + mid) {
						visit[i][j] = false;
					}
					else {
						visit[i][j] = true;
					}
				}
			}
			if(visit[0][0]) {
				continue;
			}
			visit[0][0] = true;
			
			Queue<Point> queue = new LinkedList<Point>();
			
			queue.add(new Point(0,0));
			
			while(!queue.isEmpty()) {
				Point temp = queue.poll();
				
				if(temp.x == N -1 && temp.y == N - 1) {
					return true;
				}
				
				for(int i = 0; i < 4; i++) {
					int nr = temp.x + dx[i];
					int nc = temp.y + dy[i];
					
					if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visit[nr][nc]) {
						visit[nr][nc] = true;
						queue.add(new Point(nr, nc));
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		int start = 0;
		int end = max - min;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(bfs(min , max , mid)) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println(end + 1);
	}
}
