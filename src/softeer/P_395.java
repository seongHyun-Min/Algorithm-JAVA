package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class P_395 {
    static int W, N;
    //배낭의 무게M , 귀금속 종류 N
    //N번만큼 금속의무게와 금속의 가격
    //루팡은 전동톱을 가지고 있으며 귀금속은 톱으로 자르면 잘려진 부분의 무게만큼 가치를 가진다.
    //그냥 무게당 가격이 제일 비싼것 순서대로 최대한 담아
    static ArrayList<Gemstone> gemstone;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int MaxPrice =0;
        gemstone = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            gemstone.add(new Gemstone(weight, price));
        }
        Collections.sort(gemstone);

        for(int i=0; i<gemstone.size(); i++){
            if(W ==0) break;
            if(gemstone.get(i).weight <= W){
                MaxPrice += (gemstone.get(i).weight * gemstone.get(i).price);
                W -= gemstone.get(i).weight;
            }else if(gemstone.get(i).weight > W){
                //남은 만큼만 더해줘야지
                MaxPrice += (gemstone.get(i).price * W);
                W =0;
            }
        }

        System.out.println(MaxPrice);





    }

    static class Gemstone implements Comparable<Gemstone> {
        int weight;
        int price;

        public Gemstone(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Gemstone o) {
            return o.price - this.price;
        }
    }
}
