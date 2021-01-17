package retry01;

import java.util.Stack;

public class Solution_Maximal_Rectangle {
	public static int maximalRectangle(char[][] matrix) {
		int answer = 0;
		if(matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int[] height = new int[matrix[0].length + 1];

		for (int i = 0; i < matrix.length; i++) {
			Stack<Integer> st = new Stack<Integer>();
			for (int j = 0; j <= matrix[0].length; j++) {

				if (j == matrix[0].length || matrix[i][j] == '0') {
					height[j] = 0;
				} else {
					height[j]++;
				}

				while (!st.isEmpty() && height[st.peek()] >= height[j]) {
					int Height = height[st.pop()];
					int width = 0;
					if (st.isEmpty()) {
						width = j;
					} else {
						width = j - st.peek() - 1;
					}
					answer = Math.max(answer, width * Height);
				}
				st.add(j);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		System.out.println(maximalRectangle(matrix));
	}
}
