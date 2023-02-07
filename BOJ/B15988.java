import java.io.*;

public class B15988 {
    // 시간복잡도 : O(N) -> 메모제이션으로 dp[i] 조회는 O(1) , O(1) *N  = O(N) 시간복잡도 소요
    // 로직
    // 1일때 = 1(1), 2일때 = 2(1+1,2), 3일때 = 4(1+1+1,1+2,2+1,3) 이므로
    // 초기값을 arr[1] = 1, arr[2] = 2, arr[3] = 4
    // 배열
    // 점화식 : arr[i] = (arr[i-1]+arr[i-2]+arr[i-3]) % 1,000,000,009 (i>=4)
    // 출력 : arr[i]
    static long[] dp = new long[1000001];
    public static long solution(int N){
        for(int i = 4;i<=N;i++){
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]) % 1000000009;
        }
        return dp[N];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        //초기값
        dp[1]=1; dp[2]=2; dp[3]=4;

        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            bw.write(solution(N)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
