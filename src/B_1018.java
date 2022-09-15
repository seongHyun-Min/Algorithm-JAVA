import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1018 {
    static boolean[][] arr;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //N 행
        M = Integer.parseInt(st.nextToken()); //M 열
        arr = new boolean[N][M];
        //하얀색을 받을때만 true로 바꿔줄거야
        for(int i=0; i<N; i++){
            String tmp =br.readLine() ;
            for(int j=0; j<M; j++){
                if(tmp.charAt(j) =='W'){
                    arr[i][j] =true;
                }
            }
        }
        Integer max = Integer.MAX_VALUE;
        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                //경우의 수를 탐색하는거라 인덱스는 상관없이 탐색
                max = Math.min(max, find(i,j));
            }
        }
        System.out.println(max);
    }

    public static int find(int i, int j){
        int count =0;
        boolean tmp = arr[i][j]; //탐색한경우의 수의 왼쪽 첫번째가 흰색인지 검은색인지 저장
        for(int x=i; x<i+8; x++){
            for(int y=j; y<j+8; y++){
                if(arr[x][y] !=tmp){
                    count ++;
                }
                tmp = !tmp; //흰색다음엔 검은색이 나와야대니까
                //계속 계속 바꿔줘야대
            }
            tmp = !tmp; //WBWBWBWB 라면
                        //BWBWBWBW 로 행이 바뀔때마다 B B가 일치되야되니 행이 변할때마다도 tmp의 값을 바꿔준다
        }
        return Math.min(count, 64-count); // 64-count를 해주는 이유는 배열은 8 8 64 경우의수에서 첫째가 화이트인 경우 count이고
        //두번쨰가 블랙인 경우 64-count이기떄문
    }
}
