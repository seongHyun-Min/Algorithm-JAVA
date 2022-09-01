package programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//크레인 인형 뽑기
public class P_64061 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> bucket = new ArrayList<Integer>();
        //버켓은 5칸이 아님

        // move 순서를 통해 board의 인형을 bucket에 담는다.
        for (int move : moves) {
            int tmp = move - 1; //배열의 인덱스를 활용하기 위해 -1
            for (int i = 0; i < board.length; i++) {
                if (board[i][tmp] != 0) {
                    bucket.add(board[i][tmp]);
                    board[i][tmp] =0; //뽑은 인형 초기화
                    break;
                }

            }

        }
//        move 순서를 통해 담은 인형
//        System.out.println(bucket);
        if(bucket.size()>=2) { //move가 1인 배열에 있을수 있으니
            int size = bucket.size() - 1;
            for (int i =0; i <size; i++) {
                if (bucket.get(i) == bucket.get(i + 1)) {
                    bucket.remove(i);
                    bucket.remove(i);
                    answer += 2;
                    size -= 2;
                    i = -1;

                }
            }
        }
//        터트린 후 바구니에 남은 인형
//        System.out.println(bucket);
        return answer;
    }
//    //테스트
//    public static void main(String[] args){
//        int[][] arr = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
//        int[] arr2 = {1,5,3,5,1,2,1,4};
//        System.out.println(solution(arr,arr2));
//
//
//
//    }
}
