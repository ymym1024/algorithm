import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1504 {
    //시간복잡도 : O(ElogV)
    //로직
    // 1. 최단거리 가중치를 저장하는 배열을 선언하고, 최대값으로 초기화
    // 2. 그래프에 노드 연결 정보와 가중치를 전달 받음
    // 3.
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;
    static int MAX = 200000000;
    static class Node{
        int index,cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    //다익스트라 알고리즘
    public static int dijkstra(int start,int end){
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(new Node(start,0));
        Arrays.fill(distance,MAX);
        Arrays.fill(visited,false);

        distance[start] = 0;
        while (!q.isEmpty()){
            Node cur = q.poll();
            if(visited[cur.index]) continue;
            visited[cur.index] = true;

            for(Node n : graph.get(cur.index)){
                if(distance[n.index] > cur.cost + n.cost){
                    distance[n.index] = cur.cost + n.cost;
                    q.add(new Node(n.index,distance[n.index]));
                }
            }
        }
        return distance[end];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for(int i=0;i<V+1;i++) graph.add(new ArrayList<>());
        distance = new int[V+1];
        visited = new boolean[V+1];

        for(int i=0;i<V+1;i++) distance[i] = Integer.MAX_VALUE;

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
            graph.get(v).add(new Node(u,w));
        }
        st = new StringTokenizer(br.readLine()," ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int r1 = dijkstra(1,v1)+dijkstra(v1,v2)+dijkstra(v2,V);
        int r2 = dijkstra(1,v2)+dijkstra(v2,v1)+dijkstra(v1,V);


        if(r1 >= MAX && r2 >=MAX){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(r1,r2));
        }
    }
}
