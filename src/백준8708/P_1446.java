package 백준8708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P_1446 {
    static int N, D;
    static ArrayList<ArrayList<Edge>> arr;
    static int[] dist;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        for (int i = 0; i < 10001; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //역주행 불가능 일방통행
            //지름길이 아니면 지름길에 넣지 말자
            if (end - start < cost) continue;
            //30 에서 50으로 가는 비용이 20보다 크다면 넣지마
            arr.get(start).add(new Edge(end, cost));
        }
        dist = new int[10001]; //0에서 만까지 최단거리 구하기
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (current.cost > dist[current.node]) continue;
            //다익스트라
            for (Edge next : arr.get(current.node)) {
                if (dist[next.node] > dist[current.node] + next.cost) {
                    dist[next.node] = dist[current.node] + next.cost;
                    pq.offer(new Edge(next.node, dist[next.node]));
                }
            }
            //DFS
            if (current.node + 1 <= D && dist[current.node + 1] > dist[current.node] + 1) {
                dist[current.node + 1] = dist[current.node] + 1;
                pq.offer(new Edge(current.node + 1, dist[current.node + 1]));
            }
        }
        System.out.println(dist[D]);


    }


    static class Edge implements Comparable<Edge> {
        int node;
        int cost;


        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
            //비용 오름차순 정렬
        }
    }

}