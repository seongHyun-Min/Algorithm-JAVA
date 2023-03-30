package 백준8708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_11501 {
    static int T;
    static int N;
    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            price =new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                price[i] = Integer.parseInt(st.nextToken());
            }
            int maxPrice =0;
            long maxProfit = 0;
            for(int i=N-1; i>=0; i--){
                if(price[i] > maxPrice){
                    maxPrice = price[i];
                    //뒤에서부터 최대값 갱신
                }else{
                    //최대값 보다 작으면 무조건 구매후 판매
                    maxProfit += maxPrice - price[i];
                }
            }
            System.out.println(maxProfit);
        }
    }
}
