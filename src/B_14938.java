import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_14938 {
    static class Node implements Comparable<Node>{
        int node;
        int weight;

        public Node(int node, int weight){
            this.node = node;
            this.weight =weight;


        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static ArrayList<ArrayList<Node>> arr; //인접 리스트
    static int[] dist; // 거리 리스트
    static boolean[] visited; //방문 리스트
    static int[] item; // 아이템 리스트
    static final int INF = Integer.MAX_VALUE;
    static int n, m, r;

    static PriorityQueue<Node> pq;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for(int i=1; i<=n+1; i++){
            arr.add(new ArrayList<>());
        }
        item = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr.get(u).add(new Node(v, w)); //무방향 그래프
            arr.get(v).add(new Node(u, w));
        }
        int sumMax = 0;
        for(int i=1; i<item.length; i++){
            //System.out.println(i +"번쨰 다이크스트라 : " + dijkstra(i));
            sumMax = Math.max(sumMax, + dijkstra(i));
        }
        System.out.println(sumMax);
    }
    public static int dijkstra(int start){
        int sum =0;
        pq = new PriorityQueue<>();
        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[start] =0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(visited[current.node]) continue;
            visited[current.node] =true;

            for(Node next: arr.get(current.node)){
                if(dist[next.node] > dist[current.node] + next.weight){
                    dist[next.node] = dist[current.node] +next.weight;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
        for(int i=1; i<dist.length; i++){
           if(dist[i] <= m) sum += item[i]; // 거리의 최소값을 구하는것이 아닌 수색범위 안에 포함된 아이템의 최대 값을 구하는 것이기 때문에 sum 에 dist[i] 가 아닌 item[i] 이 들어가야한다
        }
        return sum;
    }
}
