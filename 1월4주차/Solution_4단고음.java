package Algo_Study_Programmers;

public class Solution_4단고음 {
	static int answer;
	private static void find(int ed, int pCnt) {

		if(Math.pow(3, pCnt/2) > ed) {
			return;
		}
		if(ed == 3) {
			if(pCnt == 2) {
				answer++;
				return;
			}
			return;
		}
		else {
			if(ed % 3 == 0 && pCnt >= 2) {
				find(ed / 3, pCnt - 2);
			}
			find(ed - 1, pCnt + 1);
		}
	}
	
    public static int solution(int n) {
        answer = 0;
        
        find(n, 0);
        return answer;
    }
	public static void main(String[] args) {
		int n = 2147483647;
		System.out.println(solution(n));
	}
}
