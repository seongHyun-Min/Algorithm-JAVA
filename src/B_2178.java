import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//dfs: 깊이우선탐색 : 모든 노드를 방문하고 싶을때 사용한다 bfs 보다 구현이 쉬우나 검색속도가 bfs보다 느리다
//dfs: 최단거리(경로)를 구할때 경로에 특징을 저장해야할때 큐로 구현한 dfs를 사용해야 탐색속도가 빠르다!!

public class B_2178 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visitied;
    static int N; // 행
    static int M; // 열
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visitied = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }
        bfs(0,0);
        System.out.println(arr[N-1][M-1]);
//        System.out.println(Arrays.deepToString(arr)); //배열 확인 코드
    }
    public static void bfs(int i, int j){
        visitied[i][j] =true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >=0 && y>= 0 && x<N && y<M){ //ArrayIndexOut
                    if(arr[x][y] !=0 && visitied[x][y] ==false){
                        arr[x][y] = arr[now[0]][now[1]]+1; //시작은 항상 1에서 시작
                        //depth 한번당 갈수 있는 배열들을 모두 1씩 늘려주자
                        // 그럼 depth당 최단 경로가 나올 것이다!!
                        visitied[x][y] =true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
