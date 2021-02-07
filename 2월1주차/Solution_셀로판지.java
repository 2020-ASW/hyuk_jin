package Algo_Study_SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_셀로판지 {
	static int p, q, r, a, b, c, d;
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	private static boolean isInRect() {
		if(p + r > c || p - r < a || q + r > d || q - r < b) {
			return true;
		}
		return false;
	}
	private static boolean isInCircle() {
		
		if(cal(a, b) || cal(a,d) || cal(c, b) || cal(c, d)) {
			return true;
		}
		return false;
	}
	
	private static boolean cal(int x, int y) {
		
		if(Math.pow(x - p, 2) + Math.pow(y - q, 2)  > Math.pow(r, 2)) {
			return true;			
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			p = stoi(str.nextToken());
			q = stoi(str.nextToken());
			r = stoi(str.nextToken());

			str = new StringTokenizer(br.readLine());
			
			a = stoi(str.nextToken());
			b = stoi(str.nextToken());
			c = stoi(str.nextToken());
			d = stoi(str.nextToken());
			
			String result = "";
			if(isInRect()) {
				result += "Y";
			}
			else {
				result += "N";
			}
			
			if(isInCircle()) {
				result += "Y";
			}
			else {
				result += "N";
			}
			
			System.out.println("#" + " " + tc + " " + result);
		}
	}
}
