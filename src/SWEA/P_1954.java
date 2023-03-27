package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P_1954 {
    static int T;
    static int N;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int count = 1;
            int dir = 0; //왼쪽부터 시작해서 아래 오른쪽 위 순으로 들어갈거야
            int x = 0;
            int y = 0;


            while (count <= N*N) {
                arr[x][y] = count++;

                int nx = x + dx[dir];
                int ny = y + dy[dir];
                //방향 전환을 통해 현재 nx , ny


                if (nx < 0 || nx>=N || ny < 0 || ny>= N || arr[nx][ny] != 0) {
                    //인덱스 아웃이 나거나 배열에 0이 아닌 값이 있다면 방향전환
                    // 0 1 2 3 0 1 2 3`
                    dir = (dir + 1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                    //이 과정에서도 현재 방향을 바꿔야함
                }
                x = nx;
                y = ny;
                //이전에 있던 기본값을 바꿔줘
            }
            System.out.println("#" + t);
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }



        }

    }
}
