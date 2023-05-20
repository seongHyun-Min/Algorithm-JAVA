package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1244 {
    //DFS 완전 탐색으로 구현
    static String num;
    static int change;
    static int T;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            num = st.nextToken();
            change = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;

            //목표는 최대값이기 떄문에
            // 모든 경우의수를 구할 필요가 없다
            // change횟수가 num.length보다 크다면
            // change횟수를 num.length로 바꾸면 최대값을 항상 구할수 있다

            if (num.length() < change) {
                change = num.length();
            }
            DFS(0, num.toCharArray());
            System.out.println("#" + t + " " + max);
        }

    }

    //매개변수로 start로 넣어서 중복을 제거해주면 더 빠르게 계산할수 있으나
    //문제에서 중복을 허용했기 때문에 start 매개변수를 사용하지 않았다.
    static void DFS(int count, char[] arr) {
        if (count == change) {
            int value = Integer.parseInt(String.valueOf(arr));
            max = Math.max(max, value);
        } else {
            //DFS 실행
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    char tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                    DFS(count + 1, arr);
                    //다시 바꿔줘
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
