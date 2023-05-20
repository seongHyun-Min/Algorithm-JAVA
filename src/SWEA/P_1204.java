package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1204 {

    static int T;
    static int N;
    static int[] score;
    //score의 최빈수 구하기 1~100
    static int maxIndex; //최빈수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(br.readLine()); //test Case num
            score = new int[101];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                int index = Integer.parseInt(st.nextToken());
                score[index]++;
            }
            maxIndex = 0;
            int max = 0;
            for (int i = 1; i <= 100; i++) {
                if (score[i] >= max) { //최빈수가 여러 개 일 때에는 가장 큰 점수 >=
                    max = score[i]; //max 값 갱신
                    maxIndex = i; //인덱스 갱신
                }
            }
            System.out.println("#" + t + " " + maxIndex);
        }
    }
}
