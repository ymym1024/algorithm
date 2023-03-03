import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1956 {
    // 시간복잡도 : O(V^3)
    // 로직
    // 1. 사이클을 찾아야 하므로 자기자신은 inf로 초기화 후
    // 2. 플로이드 워셜 알고리즘 이용
    // 3. arr[i][j] + arr[j][i] 의 최소값을 찾아 출력
    static int[][] arr;
    static int INF = (400 * 10000)+1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        arr = new int[V][V];
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                arr[i][j] = INF;
            }
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }

        for(int k=0;k<V;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    arr[i][j] = Math.min(arr[i][j],arr[i][k] + arr[k][j]);
                }
            }
        }

        int min=INF;
        for(int i=0;i<V;i++){
            if(arr[i][i] != INF){
                for(int j=0;j<V;j++){
                    min = Math.min(min,arr[i][j]+arr[j][i]);
                }
            }
        }
        if(min == INF) System.out.println(-1);
        else System.out.println(min);
    }
}
