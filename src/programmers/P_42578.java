package programmers;

import java.util.HashMap;

public class P_42578 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

    //위장 의상의 이름은 중요하지 않아
    //의상의 종류의 개수를 찾으면 돼
    //의상의 종류의 개수를 모두 합치고
    //마지막으로 의상의 종류의 곱을 더해주면 모든 조합이 계산된다.
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (!map.containsKey(clothes[i][1])) {
                //맵에 없으면 추가
                map.put(clothes[i][1], 1);
            } else {
                //있으면 count +1
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
        }
        //input 완료 모든 경우의 수 추가
        int answer = 1;

        for (String key : map.keySet()) {
            //모든 경우의수를 계산하면 공집합을 포함한 경우의수는
            // (a+1)(b+1)(c+1)로 계산할수 있다.
            answer *= map.get(key) +1;
        }
        return answer -1; //공집합인 경우의수 제거

    }
}
