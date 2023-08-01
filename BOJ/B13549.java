import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13549 {
    //시간복잡도 : O(ElogV)
    // 로직 -> 다익스트라로 구현
    // 1. N과 K를 입력받고, K크기의 배열 distance 배열 선언
    // 2. 시작점을 입력받은 첫번째 값으로 두고 distance 배열 값 무한으로 선언
    // 3. 큐에 시작인덱스 추가, distance의 start도 0으로 초기화
    // 4. 큐가 비어있을 때까지 반복, 노드와 간선을 연결하는 graph 선언 후 (x-1,1) (x+1,1) (2x,0)중 최소 시간을 구한 후 갱신한다
    // 5. 큐에 있는 인덱스를 가져온다
    // 6. 각 노드의 가중치를 구한 후 현재 가중치보다 최소인 경우 distance[노드] = 가중치 로 초기화 한다
    // 7. 해당 노드가 K일 때 return 으로 반복문 종료 후 distance[K] 출력
    static int[] distance;
    static int MAX = 100_000;
    static PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
    static class Node{
        int index,cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
    public static int dijkstra(int start,int end){
        Arrays.fill(distance,MAX);

        q.offer(new Node(start,0));
        distance[start] = 0;

        while(!q.isEmpty()){
            Node cur = q.remove();
            if(distance[cur.index] < cur.cost) continue;
            int x1 = cur.index *2;
            if(isCheck(x1) && distance[x1] > cur.cost+1){
                distance[x1] = cur.cost;
                q.add(new Node(x1,distance[x1]));
            }

            int x2 = cur.index -1;
            if(isCheck(x2) && distance[x2] > cur.cost+1){
                distance[x2] = cur.cost+1;
                q.add(new Node(x2,distance[x2]));
            }

            int x3 = cur.index +1;
            if(isCheck(x3) && distance[x3] > cur.cost+1){
                distance[x3] = cur.cost+1;
                q.add(new Node(x3,distance[x3]));
            }
            if(cur.index == end){
                q.clear();
                break;
            }
        }
        return distance[end];
    }
    static boolean isCheck(int position){
        return 0 <= position && position <= MAX;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        distance = new int[MAX+1];
        // -1칸 이동하는 한가지 경우의 수
        int min;
        if(N>=K) min = N-K;
        else min = dijkstra(N,K);
        System.out.println(min);
    }
}
