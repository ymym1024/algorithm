import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1182 {
    // 백트래킹을 사용해 문제 풀이
    // 시간복잡도
    // 1. 부분 수열의 합을 모두 구해야 하므로 dfs를 통해 구현
    // 2. 함수의 base condition으로 cnt 가 배열의 길이만큼 도달했을때 return
    // 3. 부분수열의 개수를 체크하는 변수 선언, 부분수열 합 == S 일때 하나씩 증가하도록 선언
    // 4. 다음 원소로 넘어갈 때 현재 값을 더하는 경우와 더하지 않는 경우로 나눠서 재귀함수 호출
    static int answer = 0;
    static int N,S;
    static int[] arr;
    public static void subset(int cnt, int sum){
        if(cnt == N){
            return;
        }else{
            if(arr[cnt]+sum == S) answer++;
            subset(cnt+1,sum);
            subset(cnt+1,sum+arr[cnt]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        S = Integer.parseInt(line[1]);
        arr = new int[N];
        line = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        subset(0,0);

        System.out.println(answer);

    }
}
