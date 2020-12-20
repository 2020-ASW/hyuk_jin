package Algo_Study_SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_이상한피라미드 {
    static int answer;
    public static void main(String[] args) throws Exception{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ra = 0;
            int ca = 0;
            while(true) {
                int temp = ra*(ra+1)/2 +1;
                int next = (ra+1)*(ra+2)/2+1;
                if(next > a) {
                    ca = a - temp;
                    break;
                }else ra++;
            }
            int rb = 0;
            int cb = 0;
            while(true) {
                int temp = rb*(rb+1)/2 +1;
                int next = (rb+1)*(rb+2)/2+1;
                if(next > b) {
                    cb = b - temp;
                    break;
                }else rb++;
            }
            if((ra-rb)*(ca-cb) > 0)
                answer = Math.max(Math.abs(ra-rb), Math.abs(ca-cb));
            else {
                answer = Math.abs(ra-rb) + Math.abs(ca-cb);
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
 
}