package Algo_Study_Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

class Road implements Comparable<Road> {

	int r;
	int c;
	int cost;
	int direction; // 0 -> 가로 1 -> 세로
	
	public Road(int r, int c, int cost, int direction) {
		this.r = r;
		this.c = c;
		this.cost = cost;
		this.direction = direction;
	}
	
	@Override
	public int compareTo(Road o) {
		return cost - o.cost; // 지금까지 값이 작은 길 먼저
	}
	
}
public class Solution_경주로건설 {
	static PriorityQueue<Road> pq;
	static final int STRAIGHT = 100;
	static final int CORNER = 500;
	static int[][] map = new int[26][26];
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] {  0, 0, 1, -1};
    public static int solution(int[][] board) {
    	
    	pq = new PriorityQueue<Road>();
    	pq.add(new Road(0, 0, 0, 0));
    	pq.add(new Road(0, 0, 0, 1));
    	
    	for(int i = 0; i < board.length; i++) {
    		Arrays.fill(map[i], (STRAIGHT + CORNER) * 25);
    	}
    	
    	while(!pq.isEmpty()) {
    		Road road = pq.poll();
    		
    		for(int i = 0; i < 4; i++) {
    			int nr = road.r + dx[i];
    			int nc = road.c + dy[i];
    			// 갈 수 있는데
    			if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 0) {
    				int ndirection = 1;
    				int ncost = 0;
    				if(road.r == nr) {
    					ndirection = 0;
    				}
    				if(road.direction == ndirection) {
    					ncost = road.cost + STRAIGHT;
    				}
    				else {
    					ncost = road.cost + STRAIGHT + CORNER;
    				}
        			if(map[nr][nc] >= ncost) {
        				map[nr][nc] = ncost;
        				pq.add(new Road(nr, nc, ncost, ndirection));
        			}
    			}
    		}
    	} 
    	return map[board.length - 1][board[0].length - 1];
    }
	public static void main(String[] args) {
		int[][] board = new int[][] {{ 0,0,0 }, {0,0,0},{0,0,0}};
		System.out.println(solution(board));
	}
}
