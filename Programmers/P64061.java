import java.util.Stack;

public class P64061 {
    // 접근 방식
    // 자료구조 : stack
    // 1. moves 배열을 반복하면서 index에 해당하는 열에 접근
    // 2. board[index][0~5] 까지 돌면서 0이 아닌 숫자가 나올때 stack에 insert
    // 3. stack에 넣을때 peek를 이용해 element를 꺼내고 element가 insert하려는 element와 같으면 삭제
    // 4. elements를 삭제할 때 answer 변수 증가시킴
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i : moves){
            for(int k=0;k< board.length;k++){
                if(board[k][i-1] == 0) continue;
                if(stack.empty()) stack.push(board[k][i-1]);
                else{
                    if(board[k][i-1] == stack.peek()){
                        answer+=2;
                        stack.pop();
                    }else{
                        stack.push(board[k][i-1]);
                    }
                }
                board[k][i-1] = 0;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] board = new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(new P64061().solution(board,moves));
    }
}
