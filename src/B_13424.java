import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_13424 { //다익스트라 풀이
    public static class Node implements Comparable<Node>{
        int node;
        int weight;

        public Node(int node, int weight){
            this.node = node;
            this.weight = weight;


        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static ArrayList<ArrayList<Node>> arr;

    static boolean[] visited;

    static int[] dist;

    static int N, M; // N = node , M=edge

    static int K; //친구의 수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); // 테스트 코드 개수 받기
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N =Integer.parseInt(st.nextToken());
            M =Integer.parseInt(st.nextToken());
            arr = new ArrayList<>();
            for(int i=1; i<=N+1; i++){
                arr.add(new ArrayList<>());
            }
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                arr.get(u).add(new Node(v, w));
                arr.get(v).add(new Node(u, w)); // 양방향 노드 삽입
            }
            K = Integer.parseInt(br.readLine());
            int[] answer = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                int friend = Integer.parseInt(st.nextToken());
                dijkstra(friend);
                for(int j=1; j<=N; j++){
                    answer[j] += dist[j];
                }
                //System.out.println("dist 1st :" +Arrays.toString(dist));
            }
            //System.out.println(Arrays.toString(answer));
            // min index를 출력해주자
            int min = answer[1];
            int minindex =1;
            for(int i=1; i<=N; i++){
                if(answer[i] < min){
                    min = answer[i];
                    minindex = i;
                    }
                }
            System.out.println(minindex);
            }



        }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N+1]; // 거리 배열 매번 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N+1]; //방문 배열도 매번 초기화
        dist[start] = 0; //자기 자신의 거리 =0
        pq.offer(new Node(start, 0));

        while(!(pq.isEmpty())){
            Node tmp = pq.poll();
            if(visited[tmp.node]) continue;
            visited[tmp.node] = true;

            for(Node n: arr.get(tmp.node)){
                if(dist[n.node] > dist[tmp.node] + n.weight){
                    dist[n.node] = dist[tmp.node] + n.weight;
                    pq.offer(new Node(n.node, dist[n.node]));
                }
            }
        }
    }
}
