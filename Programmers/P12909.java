import java.util.Stack;

public class P12909 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        if(s.charAt(0) == ')') answer = false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') stack.add('(');
            if(s.charAt(i) == ')' && !stack.isEmpty()) stack.pop();
        }
        if(!stack.isEmpty()) answer = false;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new P12909().solution("()()"));
    }
}
