import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1912 {
    // 시간복잡도 : O(N)
    // 로직
    // bottom-up 방식으로 최대 연속합을 구해야 하므로 이전의 합 + 현재 합이 양수일때만 누적해서 더해주기
    // 초기값 : dp[0] = arr[0]
    // 점화식 : dp[i] = dp[i] + dp[i-1] (i>1)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        int max = arr[0];
        for(int i=1;i<N;i++){
            if(arr[i-1] > 0 && arr[i]+arr[i-1] > 0){
                arr[i] += arr[i-1];
            }
            if(max < arr[i]) max = arr[i];
        }
        System.out.println(max);
    }
}
