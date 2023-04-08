package programmers;

public class P_62576 {

    static Point[] points = new Point[10];
    static Point left;
    static Point right;



    public static String solution(int[] numbers, String hand) {
        points[0] = new Point(3, 1); //0은 3행 1열에 있음
        left = new Point(3, 0);
        right = new Point(3, 2);
        String answer = "";
        //초기 위치 세팅

        for (int i = 1; i < points.length; i++) {
            points[i] = new Point((i - 1) / 3, (i - 1) % 3);
        } //0에서 9번까지 배열 위치 삽입
        for (int i = 0; i < numbers.length; i++) {
            int t = numbers[i]; //타겟
            if (t == 1 || t == 4 || t == 7) {
                //왼손이 가까우니까
                answer += 'L';
                left = points[t];

            } else if (t == 3 || t == 6 || t == 9) {
                //오른손일 경우
                answer += 'R';
                right = points[t];

            } else {
                //거리 계산 해야지
                int leftDist = Math.abs(left.x - points[t].x) + Math.abs(left.y - points[t].y);
                int rightDist = Math.abs(right.x - points[t].x) + Math.abs(right.y - points[t].y);
                if (leftDist == rightDist) {
                    //같으면 hand에 담긴걸 써야돼
                    if (hand.equals("right")) {
                        answer += "R";
                        right = points[t];
                    } else {
                        answer += "L";
                        left = points[t];
                    }
                } else if (leftDist > rightDist) {
                    answer += "R";
                    right = points[t];
                } else {
                    answer += "L";
                    left = points[t];
                }

            }
        }
        return answer;
    }

    //초기 위치
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}