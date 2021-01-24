package Algo_Study_Programmers;

import java.util.*;

public class Solution_보석쇼핑 {

	public static int[] solution(String[] gems) {
		int[] answer = new int[] { 0, gems.length};

		Map<String, Integer> map = new HashMap<String, Integer>();		
		Set<String> check = new HashSet<String>();
	
		for(int i = 0; i < gems.length; i++) {
			check.add(gems[i]);
		}
		
		int left = 0; 
		int right = 0;
		
		while(left < gems.length) {
			
			if(check.size() <= map.size()) {
				
				if(map.get(gems[left]) == 1) {
					map.remove(gems[left]);
					left++;
				}
				else {
					map.put(gems[left], map.get(gems[left]) - 1);
					left++;
				}
			}
			else if(right == gems.length) {
				break;
			}
			
			else {
				if(!map.containsKey(gems[right])) {
					map.put(gems[right], 1);
					right++;
				}
				else {
					map.put(gems[right], map.get(gems[right]) + 1);
					right++;
				}
			}
			
			if(check.size() == map.size()) {
				if(answer[1] - answer[0] > right - left) {
					answer[0] = left;
					answer[1] = right;
				}
				else if(answer[1] - answer[0] == right - left) {
					if(answer[0] > left) {
						answer[0] = left;
						answer[1] = right;
					}
				}
			}
		}
		answer[0]++;
		return answer;
	}

	public static void main(String[] args) {
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		System.out.println(Arrays.toString(solution(gems)));
	}
}

// 효율성 미통과 코드 

//class Dist implements Comparable<Dist> {
//	int st;
//	int ed; 
//	
//	public Dist(int st, int ed) {
//		this.st = st;
//		this.ed = ed;
//	}
//
//	@Override
//	public int compareTo(Dist o) {
//		return (o.st - o.ed) - (st - ed);
//	}
//}
//public class Solution_보석쇼핑 {
//
//    public static int[] solution(String[] gems) {
//        
//        Set<String> check = new HashSet<String>();
//        PriorityQueue<Dist> pq = new PriorityQueue<>();
//        // 중복안되는 보석의 수 추리기. 
//        for(String gem : gems) {
//        	check.add(gem);
//        }
//        
//        for(int i = 0; i < gems.length; i++) {
//        	Set<String> find = new HashSet<String>();
//        	
//        	find.add(gems[i]);
//        	for(int j = i; j < gems.length; j++) {
//        		
//        		find.add(gems[j]);
//        		
//        		if(check.size() == find.size()) {
//        			pq.add(new Dist(i, j));
//        		}
//        	}
//        }
//        Dist result = pq.poll();
//        int[] answer = new int[] { result.st + 1, result.ed + 1 };
//      
//        return answer;
//        
//    }
