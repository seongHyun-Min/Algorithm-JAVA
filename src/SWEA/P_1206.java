package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class P_1206 {
    static int T = 10;
    static int N;
    static int[] arr;

    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N + 4]; //양옆으로 2개 추가
            for (int i = 2; i < N + 2; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            count =0;
            for(int i=2; i< N+2; i++){
                int left = Math.max(arr[i-2], arr[i-1]);
                int right = Math.max(arr[i+1], arr[i+2]);
                int max = Math.max(left, right);
                if(arr[i] > max){
                    count += arr[i] -max;
                }
            }
            System.out.println("#" + t + " " + count);
        }
    }
}

