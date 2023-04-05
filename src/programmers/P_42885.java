package programmers;

import java.util.Arrays;

public class P_42885 {


    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); //오름차순 정렬
        //그리디 알고리즘 : 현재 시점에서 가장 무거운 사람과 가장 가벼운 사람을 함께 태울지
        // 아니면 무거운 사람만 태울지를 골라 최적의 해를 도출가능
        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            if (people[start] + people[end] > limit) {
                //제일 큰거와 제일 작은것을 더했는데 제한보다 크다면
                end--;
                answer++;
                //제일 큰거 혼자 태워서 보내자~
            } else if (people[start] + people[end] <= limit) {
                //제일 큰거와 제일 작은것을 더했는데 제한보다 작다면
                //둘다 태워서 보내자
                start++;
                end--;
                answer++;

            }
        }

        return answer;
    }
}