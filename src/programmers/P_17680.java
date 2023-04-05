package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cacheList = new ArrayList<>();
        int hit = 0;

        for (int i = 0; i < cities.length; i++) {
            //캐시크기가 가득차면 캐시 하나 비워야 돼
            if (cacheList.size() > cacheSize) {
                cacheList.remove(0); //가장 사용안된거 삭제
            }
            if (cacheList.contains(cities[i].toUpperCase())) {
                //캐시 안에 캐시가 있다면
                hit++;
                // 근데 캐시를 사용해줬으니 가장 최근걸로 바꿔줘야 해
                //큐에서는 특정 인덱스를 직접 지우는것이 불가능하다.
                cacheList.remove(cities[i].toUpperCase());
                cacheList.add(cities[i].toUpperCase());
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