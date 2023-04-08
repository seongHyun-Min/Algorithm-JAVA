package programmers;

public class P_77484 {


    public static int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zeroCount = 0;
        int[] score = {6, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zeroCount++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    count++;
                    break;
                }
            }
        }
        int max = score[count + zeroCount];
        int min = score[count];
        int[] answer = {max, min};
        return answer;
    }
}
