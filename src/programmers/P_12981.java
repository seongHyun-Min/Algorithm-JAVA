package programmers;

import java.util.ArrayList;
import java.util.List;

public class P_12981 {


    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        List<String> arr = new ArrayList<>();
        arr.add(words[0]);
        //arr에 있는지 확인
        for (int i = 1; i < words.length; i++) {
            if (!arr.contains(words[i])) {
                arr.add(words[i]); //일단 말한 단어에 추가
                if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                    //그 이전 단어의 끝과 내가 말하는단어의 앞이 다르면 실패
                    int num = (i % n) + 1;
                    int cycle = (i / n) + 1;
                    return new int[]{num, cycle};
                }
            } else {
                //말한 단어가 있으면 실패
                int num = (i % n) + 1;
                int cycle = (i / n) + 1;
                return new int[]{num, cycle};
            }
        }
        return answer;
    }
}