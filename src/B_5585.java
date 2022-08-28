import java.io.*;
import java.util.*;


//거스름돈 백준 5585번
public class B_5585{


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        N = 1000 -N;
        int count =0;
        int[] arr = new int[]{500, 100, 50, 10, 5, 1};
        for(int i=0; i<arr.length; i++) {
            if(N/arr[i]>0 )//최대값으로 나눠진다면
            {
                count += N/arr[i];
                N = N % arr[i]; //M값을 나머지로 변경해준다

            }else if(N==0) break;
        }
        System.out.println(count);
    }
}