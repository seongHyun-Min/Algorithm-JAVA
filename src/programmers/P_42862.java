    package programmers;

    import java.util.Arrays;

    public class P_42862 {
        //체육복 체격순으로 정렬
        // 바로 앞번호 학생이나 뒷번호 학생에게만 체육복을 빌려 줄수 있다.
        // 새로운 배열을 하나 만들어서 잃어버린 학생 -1 가지고 있는 학생 +1로 새로운 배열을 만든다


        public static int solution(int n, int[] lost, int[] reserve) {
            int answer =0;
            int[] student = new int[n+2]; //for문을 N+1로 돌것이기 때문에
            for(int i=0; i<lost.length; i++){
                student[lost[i]] --;
             }
            for(int i=0; i<reserve.length; i++){
                student[reserve[i]] ++;
            }
            //예시 0 ~ 6번 인덱스 기준
            //  0  1  2  3  4  5  6
            //  0  1 -1  1 -1  1  0
            for(int i=1; i<=n; i++){
                //기준 인덱스가 0이나 1이면 상관없어
                if(student[i] == 1){
                    //빌려 줄수 있다면 앞뒤를 확인하여 체육복을 빌려준다
                    if(student[i -1] ==-1) {
                        student[i]--;
                        student[i - 1]++;
                    }else if(student[i +1] == -1){//앞에가 빌려줄 필요가 없다면 뒤를 빌려줘
                        student[i] --;
                        student[i + 1] ++;
                    }
                }
            }
            for(int i=1; i<=n; i++){ //학생 번호까지만 카운팅
                if(student[i] >=0){
                    answer++;
                }
            }
            return  answer;

        }


    }
