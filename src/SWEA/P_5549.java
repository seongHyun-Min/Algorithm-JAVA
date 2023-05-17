package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_5549 {
    static String target;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; T <= T; t++) {
            target = br.readLine();
            if ((target.charAt(target.length() - 1) - '0') % 2 == 0) {
                System.out.println("#" + t + " " + "Even");
            } else {
                System.out.println("#" + t + " " + "Odd");

            }

        }


    }
}
