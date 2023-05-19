package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2007 {
    static int T;
    static String target;
    static int count;
    static String mardi;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            target = br.readLine();
            count = 0;

            for (int i = 1; i < 10; i++) {
                //마디의 최대 길이는 10이야
                String first = target.substring(0, i);
                String second = target.substring(i, i + i);
                if (first.equals(second)) {
                    mardi = first;
                    break;
                }
            }

            System.out.println("#" + t + " " + mardi.length());
        }


    }
}
