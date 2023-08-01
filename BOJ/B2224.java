import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2224 {
    // 시간복잡도
    // 로직
    // 1. 알파벳 대,소문자의 갯수만큼 배열 선언
    // 2. graph[a][k] ==1이고 graph[k][b] ==1일때 graph[a][b] = 1로 초기화 함과 동시에 문자열 저장
    // 3. 출력

    static char stringToChar(int i){
        if(i<26) return (char) (i+65);
        return (char) (i+71);
    }
    static int charToNum(char c){
        if (65 <= (int) c && (int) c <= 90) return c - 65;
        return c - 71;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[52][52];
        StringTokenizer st;
        int ans = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," => ");
            int a = charToNum(st.nextToken().toCharArray()[0]);
            int b = charToNum(st.nextToken().toCharArray()[0]);
            graph[a][b] = 1;
        }
        for(int i=0;i<52;i++){
            for(int a=0;a<52;a++){
                for(int b=0;b<52;b++){
                    if(graph[a][i] == 1 && graph[i][b] ==1){
                        graph[a][b] = 1;
                    }
                }
            }
        }

        for(int i=0;i<52;i++){
            for(int j=0;j<52;j++){
                if(i!=j && graph[i][j] == 1){
                    ans++;
                    sb.append(stringToChar(i)+ " => " + stringToChar(j)+"\n");
                }
            }
        }
        System.out.println(ans);
        System.out.println(sb);
    }
}
