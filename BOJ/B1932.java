import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1932 {
    // 정수 삼각형 -> 선택된 수의 대각선만 선택 가능, 대각선 값 중 최대값 선택하기 / bottom-up 방식
    // 시간복잡도
    //
    // 초기값 : dp[0] = arr[0][0]
    // 점화식 : dp[i][j] = max(arr[i-1][j-1],arr[i-1][j]) + arr[i][j]
    // 출력 : dp[N] 배열 데이터 중 최대 값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] tri = new int[N][N];
        StringTokenizer st;

        // 입력
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int count = st.countTokens();
            for(int j=0;j<count;j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<N;i++){
            for(int j=0;j<=i;j++){
                if(j==0) tri[i][j] += tri[i-1][0];
                else if(j==i) tri[i][j] += tri[i-1][j-1];
                else tri[i][j] += Math.max(tri[i-1][j-1],tri[i-1][j]);
            }
        }
        System.out.println(Arrays.stream(tri[N-1]).max().getAsInt());
    }
}
