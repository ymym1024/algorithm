import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class B11779 {
    // 시간복잡도 : O(ElogV)
    static ArrayList<Node>[] graph;
    static boolean[] visit;
    static int[] dist;
    static int[] route;
    static class Node{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v; this.cost = cost;
        }
    }
    static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        queue.add(new Node(start,0));
        dist[start] = 0;
        route[start] = 0;

        while (!queue.isEmpty()) {
            //현재 최단 거리가 가장 짧은 노드를 꺼내서 방문 처리 한다.
            Node now = queue.poll();

            if (!visit[now.v]) visit[now.v] = true;
            if(dist[now.v] < now.cost) continue;

            for (Node next : graph[now.v]) {
                if (!visit[next.v] && dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    queue.add(new Node(next.v, dist[next.v]));
                    route[next.v] = now.v; //방문한 노드 저장
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        route = new int[N + 1];
        visit = new boolean[N + 1];

        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
            dist[i] = 100_000_001;
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph[U].add(new Node(V, W));
        }
        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        sb.append(dist[end]+"\n");

        // 저장된 경로 출력
        ArrayList<Integer> routes = new ArrayList<>();
        int current = end;
        while(current != 0){
            routes.add(current);
            current = route[current];
        }
        sb.append(routes.size()+"\n");
        Collections.reverse(routes);
        for(int r: routes){
            sb.append(r+" ");
        }
        System.out.println(sb);
    }
}
