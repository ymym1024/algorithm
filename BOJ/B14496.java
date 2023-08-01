import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B14496 {
    // 시간복잡도
    // 로직
    // 최소치환횟수 를 구해야 하므로 bfs로 구현
    // 1. start,end,N크기 입력받고, 배열 생성
    // 2. start 노드부터 큐에 넣고 방문처리
    // 3. 큐가 비어있지 않을 때 까지 계속 반복하면서 노드를 꺼내고,그 노드의 인접한 노드를 찾고,graph의 요소가 1이고, 방문하지 않았으면 check 변수를 1로 증가한다
    // 4. end까지 방문하고, 방문을 마치면 check
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] distance = new int[1001];
    static int N;
    static class Node{
        int target,dist;

        public Node(int target, int dist) {
            this.target = target;
            this.dist = dist;
        }
    }
    public static int bfs(int start, int end){
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist );
        distance[start] =0;
        queue.add(new Node(start,0));

        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(distance[n.target] < n.dist) continue;
            for(int t:graph.get(n.target)){
                if(distance[t] > n.dist +1){
                    distance[t] = n.dist +1;
                    queue.add(new Node(t,n.dist+1));
                }
            }
        }
        return distance[end] ==1000000000 ? -1 : distance[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1;i<N+1;i++) {
            graph.add(new ArrayList<>());
            distance[i] = 1000000000;
        }
        for(int i=0;i<=M+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        System.out.println(bfs(start,end));
    }
}
