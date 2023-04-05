package programmers;


public class P_42842 {

    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = new int[2];


        //가로 길이는 세로 길이와 같거나 세로 길이보다 길다.
        for (int i = total; i >= 1; i--) {
            //완전 탐색

            if (total % i == 0) { // i가 total의 약수인 경우
                //i가 total의 약수인 경우만  i * j = total을 만족함
                int j = total / i;  // i와 j를 구함
                if (i > j) continue; //세로 길이가 가로길이보다 크면 continue;
                // i =3  j =4
                int border = (i * 2) + (j * 2) - 4;
                // 가로 테두리 길이 (i =세로 * 2)
                // 세로 테두리 길이 (j =가로 * 2)
                // -4해주는 이유가 4칸 중복되기 떄문
                if (border == brown) { //테두리가 brwon과 같으면 리턴
                    answer[0] = j; //가로 길이
                    answer[1] = i; //세로 길이
                    break;
                }
            }
        }
        return answer;
    }
}
