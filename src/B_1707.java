import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1707 {
    static int T;
    static int V, E;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] check;
    static boolean isTrue; //이분 그래프 인지 확인하는 boolean 타입 isTure

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            check = new int[V + 1];
            arr = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            isTrue = true;
            for (int i = 1; i <= V; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a].add(b);
                arr[b].add(a);
            }
            for (int i = 1; i <= V; i++) {
                if (isTrue) {
                    DFS(i);
                } else break;
            }
            if (isTrue) {
                System.out.println("YES");
            } else System.out.println("NO");


        }
    }

    public static void DFS(int start) {
        //check 시작은 0부터
        visited[start] = true;
        for (int i : arr[start]) {
            if (!visited[i]) {
                check[i] = (check[start] + 1) % 2; // 0, 1, 0, 1 이면 만족
                DFS(i);
            } else if (check[start] == check[i]) {
                isTrue = false;
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i : arr[current]) {
                if (!visited[i]) {
                    check[i] = (check[current] + 1) % 2;
                    visited[i] = true;
                    q.add(i);

                } else if (check[current] == check[i]) {
                    isTrue = false;
                    break;
                }
            }
        }
    }
}
