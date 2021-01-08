package Algo_Study_LeetCode;
/*
input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
*/
import java.util.*;
class Point {
	int r; 
	int c;
	int level;
	
	public Point(int r, int c, int level) {
		this.r = r;
		this.c = c;
		this.level = level;
	}
}
public class Solution_01Matrix {
	static int[][] answer;
	static boolean[][] visit;
	static int row, col;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] {  0, 0, 1, -1};
	public static void clear() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				visit[i][j] = false;
			}
		}
	}
	
	private static int find(Point point, int[][] matrix) {
		
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.add(point);
		
		while(!queue.isEmpty()) {
			
			Point tmp = queue.poll();
			
			if(matrix[tmp.r][tmp.c] == 0) {
				queue.clear();
				return tmp.level;
			}
			for(int i = 0; i < 4; i++) {
				int ni = tmp.r + dx[i];
				int nj = tmp.c + dy[i];
				
				if(ni >= 0 && ni < row && nj >= 0 && nj < col && !visit[ni][nj]) {
					visit[ni][nj] = true;
					queue.add(new Point(ni, nj, tmp.level + 1));
				}
			}
		}
		return 0;
	}
    public static int[][] updateMatrix(int[][] matrix) {
    	    	
    	row = matrix.length;
    	col = matrix[0].length;
    	
    	answer = new int[row][col];
    	visit = new boolean[row][col];
    	
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < col; j++) {
    			if(matrix[i][j] != 0) {
    				clear(); // 맵 초기화
    				visit[i][j] = true;
    				answer[i][j] = find(new Point(i, j, 0), matrix);
    			}
    		}
    	}
    	
    	return answer;
    }
	public static void main(String[] args) {
		int[][] matrix = new int[][] {{ 0,0,0 }, { 0,1,0 }, { 1,1,1 }};
		int[][] result = updateMatrix(matrix);
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
}
