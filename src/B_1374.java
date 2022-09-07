import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class room{
    int num =0;
    long start =0;
    long end = 0;

    room(int num, long start, long end){
        this.num = num;
        this.start =start;
        this.end = end;
    } //num은 왜받는건지 도저히 모르겠네

    @Override
    public String toString() {
        return "room{" +
                "num=" + num +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
public class B_1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        room[] arr = new room[N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new room(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        Arrays.sort(arr, new Comparator<room>() {
            @Override
            public int compare(room o1, room o2) {
                if(o1.start == o2.start){
                    return (int) (o1.end - o2.end);
                }else return (int) (o1.start - o2.start);
            }
        });

    //    System.out.println(Arrays.toString(arr)); 테스트 코드
        //우선순위 큐 생성
        PriorityQueue<Long>  pq = new PriorityQueue<>();
        pq.offer(arr[0].end);

        for(int i=1; i<arr.length; i++){
            if(pq.peek() <=arr[i].start){
                pq.poll();
            }
            pq.offer(arr[i].end);
        }

        System.out.println(pq.size());

    }
}
