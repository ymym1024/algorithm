import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Stack;

public class P12906 {
    // 스택 최상위 값과 스택에 추가하려는 값 동일하면 pass, 아니면 push
    // 시간복잡도 : O(n) -> o(1) * n
    public static void main(String[] args) {
        new P12906().solution(new int[]{1,1,3,3,0,1,1});
    }
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int a: arr){
            if(stack.size() >= 1 && stack.peek() == a) continue;
            stack.push(a);
        }
        int[] answer = stack.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
