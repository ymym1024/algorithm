import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1753 {
    //시간복잡도 : O(ElogV)
    //로직
    // 1. 노드에 대한 정보를 담는 리스트 선언, 최단거리 테이블을 무한으로 초기화
    // 2. 시작노드로 가기 위한 최단경로를 0으로 선언, 우선순위 큐에 시작노드의 인덱스와 0을 삽입
    // 3. 큐가 비어있지 않은 경우 노드의 정보 꺼내고, 이미 거쳐간 노드가 아닌 경우 현재 노드와 인접한 노드를 확인
    // 4. 가중치보다 노드를 거쳐서 다른 노드로 이동하는 거리가 짧은 경우에만 최단거리 테이블을 비용을 초기화, 큐에 원소 추가
    // 5. 도달 하지 못하는 경우 INF 출력, 도달할 수 있는 경우 거리 출력
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] distance;
    static class Node{
        int index,cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    //다익스트라 알고리즘
    public static void dijkstra(int start){
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(start,0));
        distance[start] = 0;
        while (!q.isEmpty()){
            Node cur = q.poll();
            if(distance[cur.index] >=cur.cost){
                for(Node n : graph.get(cur.index)){
                    if(distance[n.index] > cur.cost + n.cost){
                        distance[n.index] = cur.cost + n.cost;
                        q.offer(new Node(n.index,distance[n.index]));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        for(int i=0;i<V+1;i++) graph.add(new ArrayList<>());
        distance = new int[V+1];
        for(int i=0;i<V+1;i++) distance[i] = Integer.MAX_VALUE; //최단거리 가중치 테이블 초기화

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v,w));
        }

        dijkstra(K);

        for(int i=1;i<V+1;i++){
            if(distance[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(distance[i]);
            }
        }
    }
}
