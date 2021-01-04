package Algo_Study_LeetCode;

import java.io.*;
import java.util.*;

public class Solution_Number_of_Islands {
	static boolean[][] visit;
	static int[] dx = new int[] { 1 , 0, -1, 0 };
	static int[] dy = new int[] { 0 , 1,  0, -1};
	static int N, M;
	private static void bfs(int row, int col, char[][] grid) {
		visit[row][col] = true;
		
		for(int i = 0; i < 4; i++) {
			int ni = row + dx[i];
			int nj = col + dy[i];
			
			if(ni >= 0 && ni < N && nj >= 0 && nj < M && grid[ni][nj] - '0' == 1 && !visit[ni][nj]) {
				bfs(ni, nj, grid);
			}
		}
	}
    public static int numIslands(char[][] grid) {
    	int cnt = 0;
    	
    	N = grid.length;
    	M = grid[0].length;
        visit = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < M; j++) {
        		if((grid[i][j] - '0' == 1) && !visit[i][j]) {
        			cnt++;       		
        			bfs(i, j, grid);
        		}
        	}
        }
        return cnt;
    }
	public static void main(String[] args) throws Exception {
		char[][] map = new char[][] {{'1', '1','0','0','0'},{'1', '1','0','0','0'},{'0', '0','1','0','0'},{'0', '0','0','1','1'}};
		System.out.println(numIslands(map));
		
	}
}
