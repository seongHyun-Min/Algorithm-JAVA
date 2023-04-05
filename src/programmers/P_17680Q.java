package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P_17680Q {
    //이전에 큐에서는 삭제할때 특정인덱스를 찾아서 지우는것은 불가능하다고 알고 있어
    //리스트를 사용하였으나 특정인덱스를 찾아서 지우는것이 불가능한것이지
    // 특정 값을 찾아서 지우는것은 가능하다는 것을 확인하였다
    // 이결과 삽입과 삭제가 빠른 큐를 사용하는것이 더 적합하다고 생각하여 큐를 사용하였다.
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cacheList = new LinkedList<>();
        int hit = 0;

        for (int i = 0; i < cities.length; i++) {
            //캐시크기가 가득차면 캐시 하나 비워야 돼
            if (cacheList.size() > cacheSize) {
                //cacheList.remove(0); //가장 사용안된거 삭제
                //이 과정에서 리스트에서는 O(N)을 반복했지만
                // 큐를 사용함으로써 O(1) 만에 가능
                cacheList.poll();
            }
            if (cacheList.contains(cities[i].toUpperCase())) {
                //캐시 안에 캐시가 있다면
                hit++;
                // 근데 캐시를 사용해줬으니 가장 최근걸로 바꿔줘야 해
                //큐에서는 특정 인덱스를 직접 지우는것이 불가능하다.
                //cacheList.remove(cities[i].toUpperCase());
                cacheList.remove(cities[i].toUpperCase());
                cacheList.add(cities[i].toUpperCase());
                //cacheList.add(cities[i].toUpperCase());
                //삽입 삭제 ㅋㅋ
            } else {
                cacheList.add(cities[i].toUpperCase());
                answer += 5;
                //캐시안에 캐시가 없다면 캐시를 담고 count +=5
            }
        }
        return answer + hit;
    }
}