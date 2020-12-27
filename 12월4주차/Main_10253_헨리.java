package Algo_Study_BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10253_헨리 {
	private static int Gcd(int a, int b) {

		if (a > b) {
			while (b > 0) {
				int tmp = a;
				a = b;
				b = tmp % b;
			}
			return a;
		} else {
			while (a > 0) {
				int tmp = b;
				b = a;
				a = tmp % a;
			}
			return b;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());

			while (a != 1) {
				int x = (b / a) + 1; // (b / a) 가 소수 이므로 1을 더하면 그거보다 큰 정수

				a = (a * x) - b;
				b = b * x;

				int gcd = Gcd(a, b);

				a /= gcd;
				b /= gcd;
			}
			System.out.println(b);
		}
	}
}
