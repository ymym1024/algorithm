import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1149 {
    // 시간복잡도 : O(N)
    // 로직
    // 초기값 : 입력 값의 2번쩨 값
    // 점화식 : dp[n] = min(dp[i][0],dp[i][1],dp[i][2])
    // dp[i][0] = min(dp[i-1][1],dp[i-1][2]) + arr[0]
    // 출력 : dp[n](누적 합의 최소값)
    // 현재 값은 이전값에 영향을 받기 때문에 입력받은 첫번째 줄이 아닌 두번째 줄 부터 확인함
    static int[][] arr;

    public static int solution(int N){
        for(int i=1;i<arr.length;i++){
            arr[i][0] = Math.min(arr[i-1][1],arr[i-1][2]) + arr[i][0];
            arr[i][1] = Math.min(arr[i-1][0],arr[i-1][2]) + arr[i][1];
            arr[i][2] = Math.min(arr[i-1][1],arr[i-1][0]) + arr[i][2];
        }
        int answer = Math.min(arr[N-1][0],Math.min(arr[N-1][1],arr[N-1][2]));
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        for(int i = 0;i<N;i++){
            String[] s = br.readLine().split(" ");
            for(int j=0;j<3;j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        System.out.println(solution(N));
    }
}
