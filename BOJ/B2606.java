import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2606 {
    // 문제요약
    // 연결되어 있는 컴퓨터 노드의 개수를 구하기 => dfs
    // 시간복잡도 : O(V^2) - (V는 정점)
    // 로직
    // 1. 컴퓨터와 네트워크 쌍을 입력 받음
    // 2. 방문처리에 사용할 배열을 선언하고, DFS를 위해 스택을 선언
    // 3. 1번 노드 부터 스택에 넣어준 후, 방문 처리를 한다
    // 4. 스택이 비어있지 않을 때 까지 계속 반복하면서 스택을 꺼내고, 인접한 노드를 찾는다
    // 5. 인접한 노드를 방문하지 않았을 때 스택에 넣고 방문처리를 한다
    // 6. 방문한 노드를 체크할 변수를 두고, 인접한 노드 방문 시 증가 시킨다
    static boolean[] visited;
    static int[][] graph;
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[C+1];
        graph = new int[C+1][C+1];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            graph[i1][i2] = graph[i2][i1] =1;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        visited[1] = true;
        int check = 0;

        while(!stack.isEmpty()){
            int index = stack.pop();
            for(int i =0;i<visited.length;i++){
                if(!visited[i] && graph[index][i] == 1){
                    stack.push(i);
                    visited[i] = true;
                    check++;
                }
            }
        }
        System.out.println(check);
    }
}
