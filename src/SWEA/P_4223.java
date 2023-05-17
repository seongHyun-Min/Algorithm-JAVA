package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_4223 {

    static int T;
    static int N;
    static int L;
    static int min;
    static boolean[] visited;
    static Person[] person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            person = new Person[N]; //N명의 면접관 생성
            visited = new boolean[N]; //백트래킹
            for (int i = 0; i < N; i++) {
                L = Integer.parseInt(br.readLine());
                String name = br.readLine().replaceAll(" ", "");
                int score = Integer.parseInt(br.readLine());
                person[i] = new Person(name, score);
            }
            min = Integer.MAX_VALUE;
            DFS("", 0);
            if(min == Integer.MAX_VALUE){
                min = -1;
            }
            System.out.println("#" + t + " " + min);
        }
    }

    static void DFS(String name, int sum) {
        if ( sum >= min) return;
        char[] chars = name.toCharArray();
        Arrays.sort(chars);
        String sortName = new String(chars);
        if(sortName.contains("SS") && sortName.contains("A") && sortName.contains("M")
        && sortName.contains("U") && sortName.contains("G") && sortName.contains("N")){
            min = Math.min(min , sum);
        }
        
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue; //방문했으면 멈춰
            visited[i] = true;
            DFS(name + person[i].name, sum + person[i].score);
            visited[i] = false;

        }
    }

    static class Person {
        String name;
        int score;

        public Person(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
