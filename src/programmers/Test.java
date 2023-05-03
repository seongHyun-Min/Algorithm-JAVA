package programmers;

import java.util.*;

class Solution1 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<State> q = new LinkedList<>();
        q.offer(new State(begin, 0));
        while(!q.isEmpty()){
            State current = q.poll();
            System.out.println(current.word);
            if (current.word.equals(target)) {
                //목표치를 찾았으면 바로 리턴 해줘야지
                return current.step;
            }
            for(int i=0; i<words.length; i++){
                if(visited[i]) continue;
                if(isConvert(current.word, words[i])){
                    //참을 리턴한다면 큐에 넣어
                    visited[i] = true;
                    q.offer(new State(words[i], current.step +1));
                }
            }
        }
        //못찾으면 0리턴
        return answer;
    }

    //한 번에 한 개의 알파벳만 바꿀수 있다
    // 즉 begin이랑 word중 단 하나의 알파벳만 다른 경우에 변환 가능
    static boolean isConvert(String before, String after){
        char[] beforeArr = before.toCharArray();
        char[] afterArr = after.toCharArray();
        int count =0;
        for(int i=0; i<beforeArr.length; i++){
            if(beforeArr[i] != afterArr[i]) count++;
        }
        return count ==1;
        //count가 1인 경우에만 ture리턴
    }
    static class State{
        String word;
        int step;


        public State(String word, int step){
            this.word =word;
            this.step =step;
        }
    }
}