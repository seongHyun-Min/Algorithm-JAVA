package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1948 {
    static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int T;
    static int day = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int day = 0;
            int firstMonth = Integer.parseInt(st.nextToken());
            int firstDay = Integer.parseInt(st.nextToken());
            int secondMonth = Integer.parseInt(st.nextToken());
            int secondDay = Integer.parseInt(st.nextToken());
            if (firstMonth == secondMonth) {
                day = secondDay - firstDay + 1;
            } else {
                day += secondDay + month[firstMonth] - firstDay + 1;
                for (int i = firstMonth + 1; i < secondMonth; i++) {
                    day += month[i];
                }
            }
            System.out.println("#" + t + " " + day);


        }
    }
}
