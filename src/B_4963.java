import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//섬의 개수
public class B_4963 {
    static int[] dx = {1, 0, -1, 0, -1, -1, 1, 1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    // 상하좌우 4측의 대각선 탐색
    static int[][] arr;
    static boolean[][] visited;
    static int w; // 열
    static int h; // 행

    //보통 행 열 순서대로 문제가 나오는 열 행 순서로 받아서 열받게 한 문제
    // 앞으로 문제를 잘읽자!!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) { //테스트 브레이크
            int count = 0;
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            // 0, 0 받으면 탈출
            if(w==0 && h ==0) break;


            arr = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine()); //i는 그냥 st를 받기 위한 변수
                for(int j=0; j< w; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }


            }
            // System.out.println(Arrays.deepToString(arr)); 입력 테스트 코드

            for (int a = 0; a < h; a++) { //a =행
                for (int b = 0; b < w; b++) { //b =열
                    if (arr[a][b] != 0 && visited[a][b] == false) {
                        count++;
                        dfs(a, b);
                    }
                }
            }
            System.out.println(count);
        }
    }


    public static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < h && y < w) { //배열 인덱스 넘어가지 않도록 설정
                if (arr[x][y] != 0 && visited[x][y] == false) {
                    dfs(x, y);
                }
            }
        }
    }
}