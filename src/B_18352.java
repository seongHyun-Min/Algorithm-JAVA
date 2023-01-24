    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class B_18352 {

        static int N, M, K, X;

        static List<Integer> dist;


        static ArrayList<Integer>[] arr;


        static int[] answer;

        static boolean[] visited;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //노드(도시의 개수)
            M = Integer.parseInt(st.nextToken()); //엣지(도로의 개수)
            K = Integer.parseInt(st.nextToken()); //거리 정보
            X = Integer.parseInt(st.nextToken()); //출발 도시 정보

            arr = new ArrayList[N + 1];
            dist = new ArrayList<>();
            for(int i=1; i<=N; i++){
                arr[i] = new ArrayList<>(); //인접 리스트 생성
            }
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()); //출발 도시
                int B = Integer.parseInt(st.nextToken()); //도착 도시
                arr[A].add(B);
            }
            visited = new boolean[N+1];
            answer = new int[N+1];

            BFS(X);

            for(int i=1; i<=N; i++) {
                if (answer[i] == K) {
                    dist.add(i);
                }
            }
            //출력
            if(dist.isEmpty()){
                System.out.println(-1);
            }
            else{
                Collections.sort(dist);
                dist.forEach(System.out::println);
            }
        }
        public static void BFS(int x){
             Queue<Integer> q = new LinkedList<>();
             q.add(x);
             visited[x] =true; //기존 visited[x] ++와 같은 코드
             while(!q.isEmpty()){
                 int current = q.poll();
                 for(int i : arr[current]){
                     if(answer[i] == 0 && !visited[i]){
                         answer[i] = answer[current] +1;
                         visited[i] = true; //방문한 노드 방문처리
                         q.offer(i);
                     }
                 }
             }
        }
    }
