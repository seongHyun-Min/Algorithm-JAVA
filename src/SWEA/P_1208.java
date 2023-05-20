package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1208 {
    static int T;
    static int N; //덤프 횟수
    static int[] arr;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = 10;
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            arr = new int[100];
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            for (int i = 0; i < N; i++) {
                int maxIndex = 0;
                int minIndex = 0;
                int max = 0;  //인덱스 저장
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < 100; j++) {
                    if (arr[j] > max) {
                        maxIndex = j;
                        max = arr[j];
                    }
                    if (arr[j] < min) {
                        minIndex = j;
                        min = arr[j];
                    }
                }
                arr[maxIndex]--;
                arr[minIndex]++;
            }
            Arrays.sort(arr);
            System.out.println("#" + t + " " + (arr[99] - arr[0]));
        }


    }
}
