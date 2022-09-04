import java.io.*;
import java.util.*;

public class B_1092 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> crane = new ArrayList<>(); //어레이리스트 생성

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            crane.add(Integer.valueOf(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            box.add(Integer.valueOf(st.nextToken()));
        }
        //배열 내림차순 정렬
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        int result =0;

        if (crane.get(0) <box.get(0)) System.out.println(-1);
        else {
            while(!box.isEmpty()) {
                int tmp =0;
                for(int i=0; i<crane.size();) {
                    if(tmp ==box.size())
                        break; //박스를 다돌았는데 들수있는 박스가 없으면 탈출하고 result++
                    else if(crane.get(i) >=box.get(tmp)) { //크레인이 들수있는 박스 하나씩 제거
                        box.remove(tmp);
                        i++;
                    }
                    else tmp++;
                }
                result ++;
            }
            System.out.println(result);
        }       
    }
}