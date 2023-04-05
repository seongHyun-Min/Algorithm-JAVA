package programmers;

import java.util.Stack;

public class P_12909 {
    public boolean solution(String s) {
        boolean answer = true;
        //올바른 괄호 문제 전형적인 스택 문제
        // ( ) ( ) 가 올바른 괄호인지 확인하는 방법은
        // ( 가 들어오면 무조건 큐에 넣는다.
        // ) 가 들어오면 큐에서 뺀다.
        // ) 가 들어와 큐에서 뺴는데 큐가 비었다면 return false
        // ) 가 들어오면 반드시 (가 있어야 하기 떄문
        // 이렇게 모든 반복문이 해결되면 true
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        //for문을 다 돌았는데 스택이 안비어있으면 false
        if (!stack.isEmpty()) return false;
        return answer;
    }
}
