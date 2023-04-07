package programmers;

import java.util.HashMap;
import java.util.Iterator;

public class P_42576 {

    public  String solution(String[] participant, String[] completion) {
        //일반 for문으로 해결하려고 하면 O(N^2) 10^2 시간초과
        //해쉬 셋을 사용하려고 했는데 동명이인이 있을수 있다니 해쉬맵을 써야돼
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        //input
        for (int i = 0; i < participant.length; i++) {
            if (!map.containsKey(participant[i])) {
                //키가 없으면 그냥 value는 1로 삽입
                map.put(participant[i], 1);
            } else {
                //키가 있으면 동명이인이니까 value를 하나씩 올려야대
                map.put(participant[i], map.get(participant[i]) + 1);
            }
        }
        //output
        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
                //키가 있으면 완주했으니 맵에서 지워줘야 하는데 value가 1보다 작은 값만 지워야돼
                if (map.get(completion[i]) == 1) {
                    map.remove(completion[i]);
                } else {
                    //value가 1이 아니라면 value를 1씩 줄여
                    map.put(completion[i], map.get(completion[i]) - 1);
                }
            }
        }
        //단 한명빼고는 모두 완주했대
        Iterator<String> iterator = map.keySet().iterator();

        while(iterator.hasNext()){
            String key = iterator.next();
            int value = map.get(key);
            if(value ==1){
                answer = key;
            }
        }

        return answer;
    }
}
