package programmers;

public class P_12924 {
    public int solution(int n) {
        int answer = 0;
        int left = 1, right = 1, sum = 0;
        //일반적인 2중 for문 시간초과
        // 투포인터 알고리즘

        while (left <= n) {
            if (sum >= n) { // sum이 n보다 크거나 같으면 left 증가
                sum -= left;
                left ++;
            } else { // sum이 n보다 작으면 right를 증가
                // 오름차순 이기 때문
                sum += right;
                right ++;
            }
            if (sum == n) { // sum이 n과 같으면 answer를 1 증가시킵니다.
                answer++;
            }
        }
        return answer;
    }
}