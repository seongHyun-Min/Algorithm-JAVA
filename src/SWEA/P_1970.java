package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1970 {
    static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    static int[] count;
    static int T;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            //5만 , 1만 , 5천, 1천, 500, 100, 50 , 10;
            count = new int[8];
            for (int i = 0; i < money.length; i++) {
                if (N / money[i] > 0) {
                    //거스름돈을 줄수 있다면
                    count[i] = N / money[i];
                    N -= (N / money[i]) * money[i];
                }
            }

            System.out.println("#" + t);
            for (int i = 0; i < count.length; i++) {
                System.out.print(count[i] + " ");
            }
            System.out.println();
        }
    }
}

