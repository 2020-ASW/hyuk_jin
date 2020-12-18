package Algo_Study_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution_준환이의양팔저울 {
    public static int N;
    public static int[] arr;
    public static int cntPossible;
    public static int arrSum;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine()); // 추 갯수 1<= N <= 9
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                arrSum += arr[i];// 전체 합
            } // end of input
            Arrays.sort(arr);
 
            cntPossible = 0;
            perm(N, 0); // i개에 대한 순열
 
            sb.append("#").append(testCase).append(" ").append(cntPossible).append("\n");
        } // end of testCase
        System.out.println(sb);
    }// end of main
 
    /* n:몇개 뽑을 지 , k: 현재 단계 */
    public static void perm(int n, int k) {
        if (k == n) { // 재귀 종료
            //System.out.println(Arrays.toString(arr)); // 순열 완성
            // 만든 순열 L-R 나누기
            dfs(0, 0, 0); // index, left, right
             
            return;
        } else { // 재귀
            for (int i = k; i < n; i++) {
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                perm(n, k + 1);
                temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
 
            }
        }
    }// end of perm
 
    public static void dfs(int index, int left , int right) {
        //left값과 right값 비교시 right가 크면 종료
        if(index == N) { // 가능한경우
            cntPossible++;
            return ;
        }
        //재귀
        dfs(index+1,left+arr[index],right);
        if(left < right+ arr[index] ) return ;
        dfs(index+1,left,right+arr[index]);
     
    }
}// end of class