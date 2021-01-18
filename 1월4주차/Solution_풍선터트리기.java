package Algo_Study_Programmers;

public class Solution_풍선터트리기 {
    public static int solution(int[] a) {
        // a가 1,000,000 이므로 O(N) 이상으로 구현하면 시간 초과
    	int answer = 0;
        
        int len = a.length;
        // 크기가 1인 입력
        if(len == 1) {
        	return 1;
        }
        
        answer += 2; // 양 끝은 무조건 살아남을 수 있음
        
        int[] lmin = new int[len];
        int[] rmin = new int[len];
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < len; i++) {
        	if(min > a[i]) {
        		min = a[i];
        	}
        	lmin[i] = min;
        }
        
        min = Integer.MAX_VALUE;
        
        for(int i = len - 1; i >= 0; i--) {
        	if(min > a[i]) {
        		min = a[i];	
        	}
        	rmin[i] = min;
        }
        
        // 양 쪽중 한쪽만 나보다 작다면 1회의 기회로 삭제하고 살아남을 수 있음
        // 하지만 둘다 작으면 반드시 없어지게됨
        for(int i = 1; i < len -1; i++) {
        	if(lmin[i] < a[i] && rmin[i] < a[i]) {
        		continue;
        	}
        	answer++;
        }
        
        return answer;
    }
	public static void main(String[] args) {
		
		int[] a = new int[] {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};
		System.out.println(solution(a));
	}
}
