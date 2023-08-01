import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2579 {
    // 시간복잡도 : O(N)
    // 로직
    // 마지막 계단은 밟아야 되므로 배열의 마지막 원소부터 접근
    // index가 0일때 종료
    // 점화식 : dp[i] = max(dp[i-2],dp[i-3]+cost[i-1]) + cost[i]
    // 출력 : dp[i]
    static int[] arr;
    static int[] cost;
    public static int dp(int t){
        if(t < 0) return 0;
        if(arr[t] == 0){
            arr[t] = Math.max(dp(t-2),dp(t-3)+cost[t-1])+cost[t];
        }
        return arr[t];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new int[T];
        cost = new int[T];

        for(int i=0;i<T;i++){
            cost[i] = Integer.parseInt(br.readLine());
        }

        arr[0] = cost[0];
        if(T>=2) arr[1] = arr[0]+cost[1];
        System.out.println(dp(T-1));
    }
}
