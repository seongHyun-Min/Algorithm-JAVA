package 백준8708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P_3758 {
    static int T;
    static int N, K, My, M;

    static ArrayList<Team> teams;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            My = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            teams = new ArrayList<>();
            int[][] maxScore = new int[N + 1][K + 1]; //팀별 문제별 점수
            int cnt[] = new int[N + 1]; //팀별 제출 횟수
            int time[] = new int[N + 1]; //팀별 마지막 제출시간
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken()); //문제 번호
                int s = Integer.parseInt(st.nextToken()); //점수
                maxScore[num][j] = Math.max(s, maxScore[num][j]);
                cnt[num]++;
                time[num] = i;
            }
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 1; j <= K; j++) {
                    sum += maxScore[i][j];
                }
                teams.add(new Team(i, sum, cnt[i], time[i]));
            }
            Collections.sort(teams);
            result = 0;
            for (int i = 0; i < teams.size(); i++) {
                if (teams.get(i).num == My) {
                    result = i + 1;
                    break;
                }
            }
            System.out.println(result);
        }

    }

    static class Team implements Comparable<Team> {
        int num;
        int score;
        int count;
        int time;

        public Team(int num, int score, int count, int time) {
            this.num = num;
            this.score = score;
            this.count = count;
            this.time = time;
        }

        @Override
        //최종점수가 같은 경우 풀이를 제출한 횟수가 적은 팀
        //최종 점수도 같고 제출횟수도 같은 경우 마지막 제출 시간이 더 빠른 순
        public int compareTo(Team o) {
            if (this.score != o.score) {
                //스코어 내림차순
                return o.score - this.score;
            } else if (this.count != o.count) {
                //최종점수가 같은데 제출 횟수가 다르면
                //제출 횟수 오름차순
                return count - o.count;
            } else {
                //최종점수도 같고 제출횟수도 같으면
                //제출시간 오름차순
                return time - o.time;
            }
        }
    }
}
