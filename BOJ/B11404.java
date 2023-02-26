import java.io.*;
import java.util.StringTokenizer;

public class B11404 {
    // 시간복잡도 : O(N^3)
    // 플로이드-워셜 알고리즘 사용
    static int N;
    static int[][] graph;
    public static void floyd(){
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                for(int k=1;k<N+1;k++){
                    if(j==k) graph[j][k] = 0;
                    else graph[j][k] = Math.min(graph[j][k],graph[j][i]+graph[i][k]);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        StringTokenizer st;
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = 1000000000;
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(c,graph[a][b]);
        }
        floyd();
        for(int i=1;i<N+1;i++){
            for(int j=1;j<N+1;j++){
                if(graph[i][j] == 1000000000) bw.write(0+" ");
                else bw.write(graph[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
