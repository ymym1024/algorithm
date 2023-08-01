import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12865 {
    // 시간복잡도 : O(NW) (w= 배낭의 최대무게)
    // 로직
    // 초기값 : 무게를 아무 것도 선택 하지 않은 값의 배열 0으로 초기화함
    // 점화식 : K[i,w] = K[i-1,w] (wi>w)
    // K[i,w] = max(K[i-1,w],K[i-1,w-wi]+vi) (wi<=w)
    // 출력 : K[N,K]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int K = Integer.parseInt(st[1]);
        int[][] arr = new int[N+1][K+1];
        int[][] bag = new int[N+1][2]; // 0:무게, 1:가치
        for(int i=1;i<N;i++){
            st = br.readLine().split(" ");
            bag[i][0] = Integer.parseInt(st[0]);
            bag[i][1] = Integer.parseInt(st[1]);
        }

        for(int i=1;i<=N;i++){
            for(int w=1;w<=K;w++){
                if(bag[i][0] <= w){
                    arr[i][w] = Math.max(arr[i-1][w],arr[i-1][w-bag[i][0]]+bag[i][1]);
                }else{
                    arr[i][w] = arr[i-1][w];
                }
                System.out.println(arr[i][w]);
            }
        }
        System.out.println(arr[N][K]);
    }
}
