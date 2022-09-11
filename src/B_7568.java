import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_7568 {
    static class bulk{ //내부 클래스로 받아야징
        int weight =0;
        int height =0;

        bulk(int weight, int height){
            this.weight = weight;
            this.height = height;
        } //생성자 생성
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        bulk[] arr = new bulk[N]; // 객체 배열생성
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new bulk( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<N; i++){
            int rank =1;
            for(int j=0; j<N; j++){
                if(i ==j) continue; // 같은건 탐색할 필요가 없어
                if(arr[i].height <arr[j].height &&arr[i].weight <arr[j].weight){
                    rank ++;
                }
            }
            sb.append(rank + " ");
        }
        System.out.println(sb);
        // 2차원 배열로 생성하여 해결해도 되지만 객체 배열을 생성한 이유는?
        // 없다 그냥 심심해서 객체 배열로 생성해봤다
        // 다음문제는 2차원 배열로 생성해야지...
    }
}