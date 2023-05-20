package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1954 {
    static int T;
    static int N;

    static int[][] arr;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    //방향전환 우, 하 , 좌, 상 순서로 입력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            int count = 1;
            int x = 0;
            int y = 0;
            int D = 0; //초기 왼쪽으로 이동
            //1부터 초기값 입력

            while (count <= N * N) {
                //count가 N*N 까지만 입력
                //x와 y의 이동
                arr[x][y] = count;
                count++;
                int nx = x + dx[D];
                int ny = y + dy[D];
                //방향전환이 필요한 순간은 배열에 이미 값이 있거나 인덱스를 벗어나거나
                if ((nx < 0 || nx >= N  || ny < 0 || ny >= N) || arr[nx][ny] != 0) {
                    D = (D + 1) % 4;
                    //0 1 2 3 우 하 좌 상
                    nx = x + dx[D];
                    ny = y + dy[D];
                }
                x = nx;
                y = ny;
            }
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
