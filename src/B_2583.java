import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_2583 {
    static int[] dx ={1, 0, -1, 0};
    static int[] dy ={0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visitied;
    static int M; //행
    static int N; //열
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M =Integer.parseInt(st.nextToken());
        N =Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        visitied = new boolean[M][N];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); //문제에선 배열을 (0,0)부터 시작하지 않고
            int y1 = Integer.parseInt(st.nextToken()); //상관없다 우리는 어처피 넓이만 구하면 되는거니까
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int j=y1;j<y2; j++){
                for(int k=x1; k<x2; k++){
                    arr[j][k] =1; // 직사각형을 1로 칠해
                }
            }
        }
//        System.out.println(Arrays.deepToString(arr));  배열 테스트 코드
        ArrayList<Integer> answer = new ArrayList<>();
        // 배열을 안만들고 ArrayList를 만드는 이유는 cnt의 갯수가 몇인지 알수 없기 때문에
        // 공간제약이 없는 ArrayList를 선언했다.
        int cnt =0; //분리된 영역의 개수
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] !=1 && visitied[i][j] ==false){
                    count =1; //갯수 1로 초기화
                    cnt++;
                    answer.add(dfs(i,j));
                }
            }
        }
        Collections.sort(answer); // 넓이 오름차순 정렬
        System.out.println(cnt); //분리된 영역의 개수
        answer.forEach(s -> System.out.print(s + " "));
        //forEach로 오름차순 출력


    }
    public static int dfs(int i, int j){
        visitied[i][j] = true;
        for(int k=0; k<4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >=0 && y >= 0 && x<M && y<N){//배열 인덱스 오류 검사
                if(arr[x][y] !=1 && visitied[x][y] ==false){
                    count++;
                    dfs(x,y);
                }

            }
        }
        return count;
    }
}
