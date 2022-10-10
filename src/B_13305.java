import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int dist[] = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        int cost[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        //우선 첫번째에 갈수 있는 기름을 넣는 것은 고정
        int sum = cost[0] * dist[0];
        int minCost = cost[0]; // 이전 까지의 과정 중 주유 최소 비용

        for(int i=1; i< N-1; i++){
            //현재 주유소가 이전 주유소의 기름값 보다 쌀 경우 minCost를 갱신해준다
            if(cost[i] < minCost){
                minCost = cost[i];
            }

            sum += (minCost * dist[i]);
        }

        System.out.println(sum);


    }
}
