package programmers;

public class P_12985// 1024 * 1024 O(NlongN) 까지가능
{


    public int solution(int n, int a, int b) {
        // 1, 2는 1번 경기  // 2 =1  4 = 1
        // 3, 4는 2번 경기  // 4 =2
        // 5, 6은 3번 경기  // 6 = 3 8 == 1
        // 7, 8은 4번 경기  // 8 = 4  //4번과 8번은 3번째 경기에서 만남
        int answer = 0;
        while (true) {
            //짝수면 그냥 나눠 //홀수면 +1해서 나눠
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a++;
                a /= 2;
            }
            if (b % 2 == 0) {
                b /= 2;
            } else {
                b++;
                b /= 2;
            }
            answer++;
            if (a == b) break;

        }


        return answer;
    }
}