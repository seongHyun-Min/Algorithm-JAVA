package programmers;


import java.util.HashSet;

public class P_42839 {

    public static void main(String[] args) {
    }

    //소수 찾기 순열 찾기
    //0은 처음에 올수 없음
    static boolean[] visited;
    static char[] nums;
    static HashSet<Integer> set = new HashSet<>();


    public static void BFS(String s) {
        //현재 조합을 set에 추가한다.
        //남은 숫자중 한개를 더해 새로운 조합을 만든다.
        //단 처음 BFS에 들어오는 것이 빈 문자열이기 때문에 빈 문자열은 넣지 않는다.
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                String tmp = s;
                s += String.valueOf(nums[i]);
                //방문 안했으면 우선 넣고
                visited[i] = true;
                BFS(s);
                //s에는 기존에 넣었던 숫 자 빼줘
                s = tmp;
                visited[i] = false;
            } else {
                //방문 한것들만 set에 넣어주자
                set.add(Integer.parseInt(s));
            }
        }

    }

    public static int solution(String numbers) {

        //visited 배열 생성
        visited = new boolean[numbers.length()];
        nums = new char[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            nums[i] = numbers.charAt(i);
        }
        BFS("");
        //이제 소수 계산해야지
        int answer = 0;
        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            //0과 1은 소수가 아니다.
            return false;
        }
        int limit = (int) Math.sqrt(num);
        //에라토스테네스의 체에 의해 루트 쒸운 값 까지만 비교해도 확인 할수 있다.
        //즉 입력값이 커질수록 10만 = 약 333 으로 해결가능
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
