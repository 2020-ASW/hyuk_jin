package Algo_Study_Programmers;

public class Solution_합승택시요금 {
	
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		if(i == j) {
        			dp[i][j] = 0;
        			continue;
        		}
        		dp[i][j] = 20000000;
        	}
        }
        
        for(int i = 0; i < fares.length; i++) {
        	int st = fares[i][0];
        	int ed = fares[i][1];
        	int cost = fares[i][2];
        	
        	dp[st][ed] = cost;
        	dp[ed][st] = cost;
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			
        			dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        		}
        	}
        }
        
        answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
        	answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
        }
        return answer;
    }
	
    public static void main(String[] args) {
    	int n = 6;
    	int s = 4;
    	int a = 6;
    	int b = 2;
    	
    	int[][] fares = new int[][] {{ 4, 1, 10},
    								 { 3, 5, 24},
    								 { 5, 6, 2 },
    								 { 3, 1, 41},
    								 { 5, 1, 24},
    								 { 4, 6, 50},
    								 { 2, 4, 66},
    								 { 2, 3, 22},
    								 { 1, 6, 25}};
    	System.out.println(solution(n, s, a, b, fares));
	}
}
