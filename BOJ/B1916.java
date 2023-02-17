import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {
    // 시간복잡도
    // 로직
    // 1. 인접리스트로 그래프 초기화
    // 2. 방문여부 확인할 배열, 최소 거리를 저장할 배열을 만든다
    // 3. 최소 거리를 담을 배열 초기화
    // 4. 현재 거리 비용 중 최소인 지점 선택
    // 5. 지점을 기준으로 인접 노드의 최소 거리 값 갱신
    // 6. 최종 비용 출력
    static class Node implements Comparable<Node>{
        int id;
        int cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost-o.cost;
        }
    }
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;
    static int[] dist;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<ArrayList<Node>>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,cost));
        }
        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        dist = new int[N+1];

        Arrays.fill(dist,Integer.MAX_VALUE);
        //다익스트라 알고리즘
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.id;
            if(!visited[cur]) {
                visited[cur] = true;
                for(Node node:graph.get(cur)){
                    if(!visited[node.id] && dist[node.id]>dist[cur]+node.cost){
                        dist[node.id] = dist[cur]+node.cost;
                        pq.add(new Node(node.id,dist[node.id]));
                    }
                }
            }
        }
        System.out.println(dist[target]);
    }
}
