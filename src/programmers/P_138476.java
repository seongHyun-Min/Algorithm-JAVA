package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P_138476 {


    //귤 고르기
    //해쉬 맵 값압축
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            if (!map.containsKey(tangerine[i])) {
                map.put(tangerine[i], 1);
            } else {
                //있으면 맵에 추가
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        int start = 0;
        while (k > 0) {
            k -= list.get(start);
            start++;
            answer++;
        }

        return answer;
    }

}

