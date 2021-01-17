package retry01;

import java.util.*;

public class Solution_징검다리_re {
	public static int solution(int distance, int[] rocks, int n) {
		int answer = 0;

		Arrays.sort(rocks);

		int left = 0;
		int right = distance;
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;

			int preRock = 0;
			int cnt = 0;

			for (int i = 0; i < rocks.length; i++) {
				if (rocks[i] - preRock < mid) {
					cnt++;
					if (cnt > n) {
						break;
					}
				} else {
					preRock = rocks[i];
				}
			}
			// 너무 많이 제거
			if (cnt > n) {
				right = mid - 1;
			} else {
				if (mid > answer) {
					answer = mid;
				}
				left = mid + 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {

		int distance = 25;
		int[] rocks = new int[] { 2, 14, 11, 21, 17 };
		int n = 2;
		System.out.println(solution(distance, rocks, n));
	}
}
