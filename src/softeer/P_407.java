package softeer;

import java.util.Scanner;

public class P_407 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int p = sc.nextInt();
        int n = sc.nextInt();

        long ans = k;
        for (int i = 0; i < n; i++) {
            ans = (ans * p) % 1000000007;
        }

        System.out.println(ans);
    }
}