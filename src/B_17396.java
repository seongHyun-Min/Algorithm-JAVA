import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_17396 {
    static class Node implements Comparable<Node>{
        int node;
        long weight;

        public Node(int node, long weight){
            this.node = node;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
            // return (int) this.weight - (int)o.weight;
        }
    }
    static ArrayList<ArrayList<Node>> arr; //인접
    static long [] dist; //거리
    static int[] outlook; //시야
    static boolean[] visited; //방문
    static int N, M; // n : 엣지 , M 노드
    static final long INF = 30000000000L; //Long.MAX_VALUE
    static PriorityQueue<Node> pq;

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        outlook = new int[N]; //0번 노드가 나오므로 인덱스 활용 x
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            outlook[i] = Integer.parseInt(st.nextToken());
        }
        arr = new ArrayList<>();
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }
        dist = new long[N];
        Arrays.fill(dist, INF);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr.get(u).add(new Node(v, w));
            arr.get(v).add(new Node(u, w));
        }
        visited = new boolean[N];
        dijkstra();
        long ans = dist[N-1];
        if(ans >=INF){
            System.out.println(-1);
        }else System.out.println(ans);

    }
    public static void dijkstra(){
        pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.offer(new Node(0, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(visited[current.node]) continue;
            visited[current.node] = true;

            for(Node next: arr.get(current.node)){
                if(outlook[current.node] ==1) continue; //여기에다 예외처리를 해주면 어처피 N-1은 항상 next.node 에 있으므로 N-1이 1이라도 종료 되지 않는다.
                if(dist[next.node] > dist[current.node] + next.weight){
                    dist[next.node] = dist[current.node] + next.weight;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
}
