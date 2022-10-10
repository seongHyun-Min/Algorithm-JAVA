import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1717 {
    //유니온 파인드 (분리집합)  : 일반적으로 여러 노드가 있을 때 특정 2개의 노드를 연결해 1개의 집합으로 묶는
    // union 연산과 두 노드가 같은 집합에 속해 있는지를 확인하는 find 연산으로 구성되어있는 알고리즘이다
    // union 이문제에서 0 a b 합집합 형태는 각 노드가 속한 집합을 1개로 합치는 연산이다.
    // a와 b의 대표 노드를 찾아서 다르다면 b의 대표노드를 a 의 대표노드로 변경하는 메소드 이다.
    // find 는 find(a) a가 대표노드라면 a의 인덱스를 그냥 리턴 해주고
    // 대표노드가 아닌지 확인하기 위해서는 parent[a]의 값과 a의 인덱스가 같은지 확인한다
    // a가 대표노드가 아니라면 대표노드값을 find(parent[a]) 형태로 재귀 함수로 찾아야한다
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //노드의 갯수
        int M = Integer.parseInt(st.nextToken()); //질의의 갯수 1 a b , 0 a b 형태로 받는다
        parent =  new int[N+1]; // 인덱스 활용을 위해 N+1
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // f 가 0이면 union연산을  f가 1이라면 checkFind 연산을 실행해준다
            if(f ==0) {
                union(a, b);
            }else System.out.println(checkFind(a, b));
        }


        }
    public static void union(int a, int b){
        int A = find(a);
        int B = find(b);
        if(A != B){
            parent[B] = A;
        }
    }
    public static int find(int a){
        if(parent[a] == a){
            return a;
        }else {
            return parent[a] = find(parent[a]); // 그냥 return find(parent[a])를 하여도
            // 결국에 조상노드를 만나게 됨으로 맞는 알고리즘이 되는데
            // parent[a] = find(parent[a])를 해주는 이유는 경로 압축이다 @@@@@@
            // find 할떄 루트가 가장 최 상단에 잇다면 시간복잡도가 O(N)이 나올수가 있는데
            // 부모 루트를 계속 연결시키는것이 아니라 최상단의 노드를 부모로 정하는 것이다.

        }
    }
    public static String checkFind(int a, int b){
        int A = find(a);
        int B = find(b);
        if(A==B){
            return "YES";
        }else return  "NO";
    }
}

