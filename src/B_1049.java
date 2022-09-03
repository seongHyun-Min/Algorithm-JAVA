import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] pack = new int[M];
        int[] piece = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pack[i] = Integer.parseInt(st.nextToken());
            piece[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pack);
        Arrays.sort(piece);


        int count = 0;
        while (N != 0) {
            if (N >= 6) {
                if (pack[0] / 6 < piece[0]) {
                    count += pack[0];
                    N -= 6;
                } else {
                    count += piece[0] * N;
                    N = 0;
                }
            }
            if (N > 0 && N < 6) {
                if (pack[0] < piece[0] * N) {
                    count += pack[0];
                    N = 0;
                } else {
                    count += piece[0] * N;
                    N = 0;
                }
            }
        }
        System.out.println(count);
    }
}

