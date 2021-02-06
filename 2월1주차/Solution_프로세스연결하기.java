package Algo_Study_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Process {
	
	int x;
	int y;
	
	public Process(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution_프로세스연결하기 {
	static int N, maxCore, minLen;
	static int[][] map;
	static int[] dx = { -1, 1, 0 ,0  };
	static int[] dy = {  0, 0, -1, 1 };
	static ArrayList<Process> list;
	
	private static void dfs(int idx, int coreCnt, int len) {
		
		if(idx == list.size()) {
			
			if(maxCore < coreCnt) {
				maxCore = coreCnt;
				minLen = len;
			}
			else if(maxCore == coreCnt) {
				if(minLen > len) {
					minLen = len;
				}
			}
			return;
		}
		
		int x = list.get(idx).x;
		int y = list.get(idx).y;
		
        for(int dir = 0; dir < 4; dir++) {
            int count = 0;
            int ori_x = x;
            int ori_y = y;
            int nx = x;
            int ny = y;
             
            while(true) {
                nx += dx[dir];
                ny += dy[dir];
                 
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    break;
                }
                 
                if(map[nx][ny] == 1) {
                    count = 0;
                    break;
                }
                count++;
            }
             
            for(int i = 0; i < count; i++) {
                ori_x += dx[dir];
                ori_y += dy[dir];
                 
                map[ori_x][ori_y] = 1;
            }
            if(count == 0) {
                dfs(idx + 1, coreCnt , len);
            }
            else {
                dfs(idx + 1 , coreCnt + 1, len + count);
                 
                ori_x = x;
                ori_y = y;
                for(int i = 0; i < count; i++) {
                    ori_x += dx[dir];
                    ori_y += dy[dir];
                     
                    map[ori_x][ori_y] = 0;
                }
            }
        }
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			
			map = new int[N][N];
			list = new ArrayList<Process>();
			for(int i = 0; i < N; i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str.nextToken());
					
					if(map[i][j] == 1) {
						
						if(i - 1 < 0 || i + 1 >= N || j - 1 < 0 || j + 1 >= N ) {
							continue;
						}
						else {
							list.add(new Process(i, j));
						}
					}
				}
			}
			maxCore = Integer.MIN_VALUE;
			minLen = Integer.MAX_VALUE;
			
			dfs(0,0,0);
			
			System.out.println("#" + tc + " " + minLen);
		}
	}
}
