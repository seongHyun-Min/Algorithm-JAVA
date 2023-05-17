package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_9280 {
    static int T;
    static int N, M;
    static int[] parking; //주차장의 무게당 요금
    static boolean[] visited; //주차장확인
    static int parkCount;
    static int[] weight; //차량의 무게
    static Queue<Integer> q; //차량대기열
    static int sum;

    static int[] car;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parking = new int[N];
            visited = new boolean[N];
            parkCount = 0;
            weight = new int[M + 1];
            sum = 0;
            car = new int[M + 1];
            for (int i = 0; i < N; i++) {
                parking[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 1; i <= M; i++) {
                weight[i] = Integer.parseInt(br.readLine());
            }
            q = new LinkedList<>();
            for (int i = 0; i < 2 * M; i++) {
                int num = Integer.parseInt(br.readLine());

                if (num > 0) {
                    //주차장에 들어옴
                    if (parkCount != N) {
                        //빈 공간이 있다면
                        parkCount++;
                        for (int j = 0; j < N; j++) {
                            if (visited[j]) continue; //있으면 안돼
                            visited[j] = true;
                            car[num] = j; //어느 주차장에 있었는지 확인
                            sum += (weight[num] * parking[j]);

                            break;
                        }
                    } else {
                        //빈 공간이 없으면 대기시켜야지
                        q.offer(num);
                    }
                } else {
                    //주차장에서 빠저나옴
                    int out = Math.abs(num);
                    visited[car[out]] = false;
                    parkCount--;

                    if (!q.isEmpty()) {
                        //차가 나갔어도 그자리에 차를 넣는것이 아니고
                        //주차장의 번호가 가장 작은 번호에 차량 넣기
                        int in = q.poll();
                        parkCount++;
                        for (int j = 0; j < N; j++) {
                            if (visited[j]) continue;
                            visited[j] = true;
                            car[in] = j; //어느 주차장에 있었는지 확인
                            sum += (weight[in] * parking[j]);
                            break;


                        }
                    }
                }
            }
            System.out.println("#" + t + " " + sum);

        }
    }

}
