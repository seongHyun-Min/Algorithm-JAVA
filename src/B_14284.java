import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_14284 {
    static class Node implements Comparable<Node>{ //간선 max 500,000,000
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

    static ArrayList<ArrayList<Node>> arr; //인접

    static int[] dist; // 거리

    static boolean[] visited; //방문

    static int n, m; // 노드의수 엣지의 수

    static int start, end; // s -> b가 연결된 가중치

    static PriorityQueue<Node> pq;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for(int i=1; i<=n+1; i++){
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr.get(u).add(new Node(v, w));
            arr.get(v).add(new Node(u, w)); //
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        visited = new boolean[n+1];
        dijkstra(start);
        System.out.println(dist[end]);


    }
    public static void dijkstra(int start){
        pq = new PriorityQueue<>();
        dist[start] =0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(visited[current.node]) continue;
            visited[current.node] =true;

            for(Node next: arr.get(current.node)){
                if(dist[next.node] > dist[current.node] + next.weight){
                    dist[next.node] = dist[current.node] + next.weight;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
    }

}

