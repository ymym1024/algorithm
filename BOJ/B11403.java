import java.io.*;
import java.util.StringTokenizer;

public class B11403 {
    // 시간복잡도 : O(N^3)
    // 로직
    // 1. N을 입력받고, N*N 크기의 배열 선언
    // 2. 간선에 대한 정보를 입력받아 초기화
    // 3. i에서 j로 가는 경우와 i에서 k로 가고 k에서 j로 가는 경우는 같기 때문에 graph[a][b] 는 graph[a][k] + graph[k][b] 와 같은 경우
    // 4. 문제에서 가중치가 없는 방향그래프 라고 주어졌기 때문에 graph[a][k] 가 1, graph[k][b] 가 1인 경우 graph[a][b]가 1로 존재
    // 5. graph를 출력한다
    static int[][] graph;
    public static void solution(){
        int N = graph.length;
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] =1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        //출력
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                bw.write(graph[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
