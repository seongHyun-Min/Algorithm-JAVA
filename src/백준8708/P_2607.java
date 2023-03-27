package 백준8708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2607 {
    static int[] origin;
    static int count;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        origin = new int[26]; //알파벳 개수
        String first = br.readLine();
        for (int i = 0; i < first.length(); i++) {
            int tmp = first.charAt(i) - 'A';
            origin[tmp]++;
        }
        count = 0;
        for (int i = 0; i < N - 1; i++) {
            String second = br.readLine();
            int lenght = first.length() - second.length();
            int[] com = new int[26];
            for (int j = 0; j < second.length(); j++) {
                int tmp = second.charAt(j) - 'A';
                com[tmp]++;
            }
            int sum = 0;
            for (int j = 0; j < 26; j++) {
                sum += Math.abs(origin[j] - com[j]);
            }
            if (sum == 0 && lenght ==0) {
                //길이가 같은데 절대치의 합이 0이다
                //두 개의 단어가 같은 종류의 문자로 이루어져 있고
                // 같은 문자는 같은 개수 만큼있다.
                count++;
            }else if (sum ==2 && lenght ==0){
                //길이가 같은데 절대치의 합이 2이다
                //즉 하나의 문자를 바꿔서 같은 구성을 가질수 있다.
                count ++;
            }else if(sum == 1 && lenght !=0){
                //길이가 다른데 절대치의 합이 1이다
                //즉 한단어에서 한 문자를 더하거나 빼거나 하여
                //같은 구성을 가질수 있다.
                count ++;
            }
        }
        System.out.println(count);
    }
}

