import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B11724 {
    // 인근의 노드들의 연결요소를 파악해야 하므로 bfs 활용
    // 시간복잡도 : O(V^2)
    // 로직
    // 1. 정점, 간선, 간선 끝점 u,v 입력받음
    // 2. 1번 노드 부터 스택에 넣어준 후, 방문 처리를 한다
    // 3. 큐가 비어있지 않을 때 까지 계속 반복하면서 노드를 꺼내고,그 노드의 인접한 노드를 찾는다
    // 4. 큐가 비어있을 때 check 변수를 1 증가한다
    // 5. visited배열의 인덱스를 모두 방문해야 하므로, 방문하지 않은 인덱스에 접근하여 3~4 과정을 진행한다
    static boolean[] visited;
    static int[][] graph;

    public static void bfs(int v,int[][] adj, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()){
            v = queue.poll();
            for(int i=1;i<=adj.length-1;i++){
                if(adj[v][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0;i<M;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            int i1 = Integer.parseInt(stk.nextToken());
            int i2 = Integer.parseInt(stk.nextToken());
            graph[i1][i2] = graph[i2][i1] = 1;
        }

        int check = 0;
        for (int k = 1; k<=N;k++){
            if(visited[k]) continue;
            bfs(k,graph,visited);
            check++;
        }
        System.out.println(check);
    }
}
