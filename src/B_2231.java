import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String n = String.valueOf(N);  // 자리수를 구하기 위해 string으로 변환
        int result =0; //못찾을때 0으로 선언하면 못찾는 예외처리를 할 필요없음

        //완전 탐색알고리즘 생성자
        // 생성자가 될것이 뭔지 알수 없으므로 완전탐색 알고리즘을 사용해야하나
        // 최대한의 시간으로 계산해보자
        // 245의 분해합은 245 + 2 + 4 + 5 가 된다.
        // 즉 256의 생성자는 1부터 생성자를 계산하게 되면 너무 비효율적인 알고리즘이 발생하게 되므로
        // 256의 생성자를 구할떄는 xyz + x+ y + z 일때 x y z의 최대값은 9이므로
        // 256 = xyz +9 +9 +9 라는 식이 성립할때 256-(9*3) >= xyz가 반드시 성립하게 된다
        // 즉 256의 생성자는 229이상부터에서만 발생할수 있기 떄문에
        // i는 1부터 시작하는것보다 229이상부터 시작해야 최적의 알고리즘으로 계산할수 있다.
        for(int i= N -(n.length() *9); i<N; i++){
            int number =i;
            int sum =0; //생성자를 sum에 누적시킨다

            while(number !=0) {
                sum += number % 10; //각자리수를 sum에 더한다음에
                number /= 10; // sum에 i를 더하면 생성자가 완성된다.
            }
            if(sum +i ==N){
                result +=i;
                break; //찾았으면 그이상을 찾을필요없으니 break로 탈출
            }


        }
        System.out.println(result);
    }

}

