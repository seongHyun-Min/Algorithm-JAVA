package programmers;

import java.util.HashMap;
import java.util.Map;

public class P_42577 {

    class Solution {
        public boolean solution(String[] phone_book) {
            //해쉬맵을 사용해서 O(NM) 으로 해결 1,000,000 * 20
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < phone_book.length; i++) {
                //중복은 없다고 가정하였으니
                map.put(phone_book[i], 1); //그냥 삽입
            }
            //해쉬 맵을 탐색해서
            for (int i = 0; i < phone_book.length; i++) {
                for (int j = 0; j < phone_book[i].length(); j++) {
                    //글자수 만큼 확인
                    if (map.containsKey(phone_book[i].substring(0, j))) {
                        return false;
                    }
                }
            }
            //탐색했는데 없다면
            return true;
        }
    }
}
