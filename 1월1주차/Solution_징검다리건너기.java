package Algo_Study_Programmers;

public class Solution_징검다리건너기 {
	private static boolean isOk(int mid, int k, int[] stones) {
		int fail = 0;
		
		for(int i = 0; i < stones.length; i++) {
			if(stones[i] - mid < 0) {
				fail++;
			}
			else {
				fail = 0;
			}
			
			if(fail == k) {
				return false;
			}
		}
		return true;
	}
    public static int solution(int[] stones, int k) {
    	int answer = 0;
    	
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i < stones.length; i++) {
    		max = Math.max(max, stones[i]);
    		min = Math.min(min, stones[i]);
    	}
    	
    	int mid = 0;
    	
    	while(max >= min) {
    		mid = ( max + min ) / 2;
    		// 중간값의 친구만큼 이동이 가능?
    		if(isOk(mid, k , stones)) {
    			// 할 수 있으면 작은값을 mid 보다 1 크게 가능?
    			answer = mid;
    			min = mid + 1;
    		}
    		else {
    			// 못하면 큰 값을 mid 보다 1작게 가능?
    			max = mid - 1;
    		}
    	}
        return answer;
    }
	public static void main(String[] args) {
		int[] stones = new int[] { 2,4,5,3,2,1,4,2,5,1 };
		int k = 3;
		solution(stones, k);
	}
}
