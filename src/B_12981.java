import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class B_12981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        } //배열에 공 3개 담음

        int count =0;
        for(int i=0; i<3; i++){
            count += arr[i] /3 ;
            int tmp = arr[i] %3;
            arr[i] = tmp;
        } //공을 3으로 나눈후 나머지들을 다시 배열에 담는다
        int max = 0;
        for(int i=0; i<3; i++){
            max = Math.max(max, arr[i]);
        }
        int tmp =0;
        if(max==2){
            for(int i=0; i<3; i++){
                if(arr[i] ==0){
                    tmp++;
                }
            }
            if(tmp ==2){
                max =1;
            }
        }
            System.out.println(count + max);

    }
}
        //반례 존재 2 0 0 -> 1개로 담을수 있는데 max값은 2개로 담긴다...
//        int max =0;
//        for(int i=0; i<3; i++){
//            max = Math.max(max,arr[i]);
//        }//3으로 나누면 경우의수는 0 0 0 /  1 0 0 /  0 1 0 /  0 0 1 / 1 1 0 / 1 1 1 / 2 1 1 / 2 1 2/ 2 2 2/
//        // 즉 나머지들은 나머지 배열에 최대값이 상자의 최소 갯수이다.
//        System.out.println(count + max);
