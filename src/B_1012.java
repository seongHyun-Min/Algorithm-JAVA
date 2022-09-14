import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1012{
    static int[] dx = {1, 0, -1, 0}; //인접리스트 dx 생성
    static int[] dy = {0, 1, 0 ,-1}; //인접 리스트 dy 생성 //for문 4번돌린다고 했을때 (1,0) ->우로 이동, (0,1) -> 하로 이동, (-1, 0) 좌로 이동, (0, -1) 상으로 이동
    static int[][] arr; //2차원 배열 초기화
    static boolean[][] visit; //방문 리스트 초기화
    static int M; // 가로길이 초기화
    static int N; // 세로길이 초기화
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 입력
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken()); // k는 항상 초기화 bfs에서도 안써 인스턴스 변수 선언
            arr = new int[M][N]; // 2차원 배열 생성
            visit = new boolean[M][N]; // 방문리스트 생성
            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] =1;
            }
//            System.out.println(Arrays.deepToString(arr)); //테스트 코드 출력

            // bfs 탐색 걸어서 bfs 횟수 만큼 출력
            int count =0;
            for(int a=0; a<M; a++){
                for(int b=0; b<N; b++){
                    if(arr[a][b] !=0 && visit[a][b] ==false){
                        count ++;
                        bfs(a,b);
                    }
                }
            }
            System.out.println(count);


        }
    }
    public static void bfs(int i, int j){ //bfs 구현
        visit[i][j] =true;
        for(int k=0; k<4; k++){
            //인접 리스트 순회
            int x = i +dx[k];
            int y = j +dy[k];
            if( x>=0 && y>=0 && x<M && y<N){//배열 인덱스 오류 발생 방지 ArrayIndexOutOfBoundsException
                if(arr[x][y] !=0 && visit[x][y] ==false){ //0인 배열은 방문할 필요없고 방문 하지않은 배열로 조건
                    bfs(x,y); // 재귀로 방문 구현
                }
            }

        }

    }
}