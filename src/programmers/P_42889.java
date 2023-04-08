package programmers;

import java.util.Arrays;

public class P_42889 {

    public static void main(String[] args) {
        solution(5, new int[]{3, 3, 3, 3});
    }

    static Game[] games;

    public static int[] solution(int N, int[] stages) {
        games = new Game[N];
        int[] answer = new int[N];
        for (int i = 1; i <= N; i++) {
            int player = 0;
            int failPlayer = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] >= i) {
                    player++;
                    if (stages[j] == i) {
                        failPlayer++;
                    }
                }
            }
            //스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0
            double failer;
            if(player !=0){
                 failer = (double) failPlayer / player;
            }else{
                failer =0;
            }

            games[i-1] = new Game(i, failer);
        }
        //정렬
        Arrays.sort(games);
        for(int i=0; i<games.length; i++){
            answer[i] = games[i].stage;
        }

        return answer;
        //인덱스를 리턴
    }

    static class Game implements Comparable<Game> {
        int stage;
        double fail;

        public Game(int stage, double fail) {
            this.stage = stage;
            this.fail = fail;
        }

        @Override
        public int compareTo(Game o) {
            //실패율이 큰 순서로 리턴
            if (this.fail == o.fail) {
                //실패율이 같으면 스테이지가 빠른순서로 정렬
                return this.stage - o.stage;
            } else {
                return Double.compare(o.fail, this.fail);
            }
        }

        @Override
        public String toString() {
            return "Game{" +
                    "stage=" + stage +
                    ", fail=" + fail +
                    '}';
        }
    }
}
