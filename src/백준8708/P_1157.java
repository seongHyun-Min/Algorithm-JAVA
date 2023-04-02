package 백준8708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1157 {

    static int[] alpha;
    static char result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine().toUpperCase();

        alpha = new int[26];

        for (int i = 0; i < tmp.length(); i++) {
            alpha[tmp.charAt(i) - 'A']++;
        }
        int max = 0;
        result = '?';
        for(int i=0; i< 26; i++){
            if(max < alpha[i]){
                max = alpha[i];
                result = (char)(i + 'A');
            }else if(max ==alpha[i]){
                result ='?';
            }
        }
        System.out.println(result);

    }

}
