package programmers;

public class P_43165 {

    static int result;

    public  int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return result;
    }

    public  void dfs(int[] numbers, int target, int count, int sum) {
        if (count == numbers.length) { // 모든 숫자를 사용한 경우
            if (sum == target) {
                result++;
            }
        } else {
            // 현재 숫자를 더하는 경우와 빼는 경우를 모두 계산
            dfs(numbers, target, count + 1, sum + numbers[count]);
            dfs(numbers, target, count + 1, sum - numbers[count]);
        }

    }
}



