import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_14502 {
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, 1, 0, -1};
    static int M;
    static int N;
    static int [][] arr;
    // 카피 맵이 필요한 이유??
    static boolean [][] visited;

    static int maxCount = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        visited = new boolean[M][N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 2차원 입력 배열 확인
        dfs(0);
        System.out.println(maxCount);

    }
    public static void dfs(int depth){ //경우의수 찾기 단순 중첩문으로 구하기 힘들때 재귀형식으로 구현해서 모든 경우의수를 구한다 (벽 3개 찾기)
        if(depth ==3){
            bfs();
            return;
        }
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++) {
                if(arr[i][j] ==0){
                    arr[i][j] =1;
                    dfs(depth+1); // 하나 선택할때마다 depth를 올려준다
                    arr[i][j]=0; //재귀 함수를 돌려주고 다시 0으로 초기화 해야 모든 배열을 탐색할수 있다..
                 }
            }
        }
    }

    public static void bfs() {
        int[][] copyArr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(copyArr[i][j] ==2){
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!(q.isEmpty())) {
            int[] now = q.poll();
            for (int k = 0; k < 4; k++) {
                int nextX = dx[k] + now[0];
                int nextY = dy[k] + now[1];
                if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
                    if(copyArr[nextX][nextY] ==0){
                        copyArr[nextX][nextY] =2;
                        q.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
        //System.out.println("arr :" + Arrays.deepToString(arr));
        //System.out.println(" copyArr :" +Arrays.deepToString(copyArr));
        find(copyArr); //재귀 형식으로 0의 개수 찾자
    }

    public static void find(int[][] findArr){
        int count =0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(findArr[i][j] ==0){
                    count ++;
                }
            }
        }
        //System.out.println(count);
        maxCount = Math.max(maxCount, count);
    }
}
