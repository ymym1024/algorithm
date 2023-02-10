import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11053 {
    // 시간복잡도 : O(N^2)
    // 로직
    // arr[i]이 마지막 원소일 때 최대 길이로 부분 수열의 길이를 구한
    // 점화식 : dp[i] = max(dp[i], dp[j]+1)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr= new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int count = st.countTokens();
        for(int i=0;i<count;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int max =0;
        for(int i=0;i<arr.length;i++) max = Math.max(max,dp[i]);
        System.out.println(max);
    }
}
