package 백준8708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_19637 {
    static int N, M;
    static String[] names;
    static int[] powers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        names = new String[N];
        powers = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }
        //이분탐색은 정렬된 배열에서만 사용 가능하다
        //그러나 이 문제에서는 오름차순 정렬로 값을 입력받는다.
        //만약 오름차순이 아닌 입력이라면 해쉬 맵에 names와 powers의 키 벨류를 저장하고
        //powers 배열을 정렬시킨다

        for (int i = 0; i < M; i++) {
            //O(MLogN)
            int target = Integer.parseInt(br.readLine());
            int index = binarySearch(target);
            sb.append(names[index] + "\n");
        }
        System.out.println(sb.toString());
    }

    static int binarySearch(int target) {
        //이 타겟에 속한 인덱스를 뽑아낸다
        int left = 0;
        int right = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (powers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}