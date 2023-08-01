import java.util.Stack;

public class P133502 {
    public int solution(int[] ingredient) {
        int answer = 0;

        int[] hb = new int[]{1,2,3,1};
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<ingredient.length;i++){
            stack.push(ingredient[i]);
            if(stack.size()>=4){
                int size = stack.size();
                if(stack.get(size-1)== hb[3]&& stack.get(size-2)==hb[2] &&
                        stack.get(size-3) == hb[1] && stack.get(size-4)==hb[0]){
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] ingredient = new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(new P133502().solution(ingredient));
    }
}
