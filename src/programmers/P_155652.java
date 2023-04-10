package programmers;

public class P_155652 {
    public static void main(String[] args) {
        solution("aukks", "wbqd", 5);
    }

    public static String solution(String s, String skip, int index) {
        String answer = "";
        boolean[] visited = new boolean[26]; //알파벳 스킵시켜야징
        for (int i = 0; i < skip.length(); i++) {
            visited[skip.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            int count = index;
            int tmp = s.charAt(i) - 'a';
            while (count > 0) {
                tmp++; //하나씩 올려가면서 탐색
                if (tmp > 'z' - 'a') {
                    tmp = 0;  //z를 넘어간다면 a로 돌아가
                }
                if (!visited[tmp]) {
                    //skip이 아닌 경우에만 count를 줄여줘
                    count--;
                }
            }
            //while 문 탈출 이후에
            char reuslt = (char) (tmp + 'a');
            answer += reuslt;
        }

        System.out.println(answer);

        return answer;
    }
}
