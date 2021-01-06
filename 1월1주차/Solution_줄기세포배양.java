package Algo_Study_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_줄기세포배양 {
	static class Cell implements Comparable<Cell> {
		int r, c; 
		int waitTime;
		int life;
		int status;
		
		public Cell(int r, int c, int life) {
			this.r = r;
			this.c = c;
			this.waitTime = this.life = life;
		}
		@Override
		public int compareTo(Cell o) {
			return Integer.compare(o.life, life);
		}
		
	}
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] {  0, 0,-1, 1 };
	static int N, M, K; // 가로 , 세로 , 시간 
	static int active = 1, dead = -1, unactive = 0; // 활성, 죽음, 비활성
	static boolean[][] visit;
	static PriorityQueue<Cell> serviveCell;
	static Queue<Cell> nextTimeCell;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1; tc <= TC; tc++) {
			
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());
			
			visit = new boolean[N + K + 2][M + K + 2];
			serviveCell = new PriorityQueue<>();
			nextTimeCell = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					int life = Integer.parseInt(str.nextToken());
					if(life > 0) {
						Cell cell = new Cell(i + K / 2, j + K / 2, life);
						visit[cell.r][cell.c] = true;
						serviveCell.add(cell);
					}
				}
			} 
			for(int time = 0; time < K; time++) {
				
				nextTimeCell.clear();
				
				while(!serviveCell.isEmpty()) {
					Cell cell = serviveCell.poll();
					
					if(cell.status == unactive) {
						cell.waitTime--;
						if(cell.waitTime == 0) {
							cell.status = active;
						}
						nextTimeCell.add(cell);
					}
					else if(cell.status == active) {
						for(int i = 0; i < 4; i++) {
							int ni = cell.r + dx[i];
							int nj = cell.c + dy[i];
							
							Cell nCell = new Cell(ni , nj , cell.life);
							// 방문 한적이 없다면 추가, 기존에 있다면 원래부터 있었거나 동일 시간에 더 큰 값의 세포
							if(!visit[ni][nj]) {
								visit[ni][nj] = true;
								nextTimeCell.add(nCell);
							}
						}
						cell.life--;
						if(cell.life > 0) {
							nextTimeCell.add(cell);
						}
					}
				}
				while(!nextTimeCell.isEmpty()) {
					serviveCell.add(nextTimeCell.poll());
				}				
			}
			System.out.println("#" + tc + " " + serviveCell.size());
		}
	}
}
