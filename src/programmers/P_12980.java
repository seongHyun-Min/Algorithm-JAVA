package programmers;

public class P_12980 {

    public int solution(int n) {
        int ans = 0;
        while (n > 0) {
            if (n % 2 == 0) { //2배씩 이동하려면 2로 나누어 떨어져야해
                n /= 2;
                //가능하다면 2로 나누어
            } else {
                //2배씩 이동하는게 불가능하다면 n값을 1줄이고 1만큼 이동했으니 ans ++를 해줘
                n--;
                ans++;
            }
        }
        return ans;
    }
}

