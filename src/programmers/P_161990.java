package programmers;

public class P_161990 {
    //그리디 알고리즘
    //드래그 한 좌표의 최소 값을 구해야 한다.
    //배열을 전부 확인하여 minRow와 minCol , maxRow, maxCol을 각각 업데이트 해준다.
    public static int[] solution(String[] wallpaper) {
        int maxRow =0;
        int maxCol =0;
        int minRow = wallpaper.length;
        int minCol = wallpaper[0].length();
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) =='#'){
                    maxRow = Math.max(maxRow, i+1);
                    maxCol = Math.max(maxCol, j+1);
                    //문제에서 끝점은 index +1 을 사용함
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                }
            }
        }

        int[] answer = {minRow,minCol, maxRow, maxCol};
        return answer;
    }
}
