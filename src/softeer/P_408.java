package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_408 {

    static int[] arr;
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String[] str = st.split(" ");
        arr = new int[8];
        result = "";
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        if (arr[0] == 1) {
            if (ascending(arr)) {
                result += "ascending";
            } else {
                result += "mixed";
            }
        } else if (arr[0] == 8) {
            //내림차순 검증
            if (descending(arr)) {
                result += "descending";

            } else {
                result += "mixed";
            }

        } else result += "mixed";


        System.out.println(result);
    }
    static boolean ascending(int[] arr){
        boolean isTrue = true;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i+1] -arr[i] !=1){
                isTrue =false;
                break;
            }
        }
        return isTrue;
    }

    static boolean descending(int[] arr){
        boolean isTrue = true;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] -arr[i+1] !=1){
                isTrue =false;
                break;
            }
        }
        return isTrue;
    }
}
