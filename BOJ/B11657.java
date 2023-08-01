import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11657 {
    //벨만포드 알고리즘 이용
    static ArrayList<Node> graph;
    static long[] dist;
    static long MAX = 500_000_000;
    static class Node{
        int start,end,cost;
        public Node(int start,int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static boolean bell(int N, int M){
        dist = new long[N];

        Arrays.fill(dist,MAX);
        dist[0] = 0;

        for(int i=0;i<N;i++){
           for(int j=0;j<M;j++){
               Node node = graph.get(j);
               if(dist[node.start] != MAX && dist[node.end] > dist[node.start]+ node.cost){
                   dist[node.end] = dist[node.start] + node.cost;
               }
           }
        }

        for(int i=0;i<M;i++){
            Node node = graph.get(i);
            if (dist[node.start] != MAX && dist[node.end] > dist[node.start] + node.cost) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<Node>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Node(start,end,cost));
        }
        StringBuilder sb = new StringBuilder();
        if(bell(N,M)){
            for (int i=1; i < dist.length; i++) {
                if(dist[i] == MAX) sb.append(-1+"\n");
                else sb.append(dist[i]+"\n");
            }
        }else{
            sb.append(-1+"\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
