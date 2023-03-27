import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1916 {

    static ArrayList<ArrayList<Node>> arr; //인접 리스트 선언

    static boolean[] visited;

    static PriorityQueue<Node> pq;

    static int[] dist; //거리배열 생성
    // 계속계속 바꿔줘야 해  O(NlongN)

    static int city; //vertex

    static int bus; //edge

    static int A;

    static int B;


    public static class Node implements Comparable<Node>{

        int startNode;

        int endNode;

        int weight;

        public Node(int startNode, int endNode, int weight){
            this.startNode = startNode;
            this.endNode = endNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) { //우선순위 큐 우선순위 선언
            return this.weight - o.weight;
        }
    }
    //방문 배열이 반드시 있어야 하는가?? 2개 다 구현
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new ArrayList<>();
        int INF = Integer.MAX_VALUE;
        dist = new int[city+1];
        Arrays.fill(dist, INF);
        for(int i=1; i<=city+1; i++){
            arr.add(new ArrayList<>()); //인접리스트 생성
        }
        for(int i=0; i<bus; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            //단방향 노드 삽입
            arr.get(u).add(new Node(u, v, w));
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        dijkestra(A);
        System.out.println(dist[B]);



    }
    public static void dijkestra(int start){
        pq = new PriorityQueue<>();
        visited = new boolean[city+1];
        //end가 5라면 더이상 탐색할 필요없어 continue;
        pq.offer(new Node(start, start, 0));
        dist[start] =0;

        while(!(pq.isEmpty())){
            Node tmp = pq.poll();
            if(visited[tmp.endNode]) continue;
            visited[tmp.endNode] =true;



            for(Node e: arr.get(tmp.endNode)) {
                if(dist[e.endNode] > dist[tmp.endNode] + e.weight){
                    dist[e.endNode] = dist[tmp.endNode] +e.weight;

                    pq.offer(new Node(tmp.endNode, e.endNode, dist[e.endNode]));
                }
            }
        }
    }
}
