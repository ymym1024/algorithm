import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2805 {
    /*
    * 시간복잡도 : O(logn)
    * 최적 해 : 나무길이 최대 값(mid)
    * 최소 : 1(나무의 최소길이)
    * 최대 : 주어진 나무길이 중 최대 값
    * 결정 조건 : (나무길이 반복 / 나무길이)의 합 <= M 인 경우 true를 반환, 그외의 경우는 false를 반환
    * 결정조건 만족 여부 -> 최대값을 구해야 하므로 만족하는 경우, 최소값+1 / 만족하지 않는 경우 최대 값을 줄여줌
    * */
    static long[] arr;
    public static long solution(long[] arr,long M){
        long min = 0, mid = 0, max = 0;
        for(int i=0;i<arr.length;i++){
            if(max < arr[i]) max = arr[i];
        }

        while(min <= max){
            mid = (min+max) / 2;
            if(isCheck(mid,M)) {
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        return max;
    }
    public static boolean isCheck(long tree,long M){
        long cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] >= tree) cnt+=(arr[i]-tree);
        }
        if(cnt >= M) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        String[] st1 = br.readLine().split(" ");
        arr = new long[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st1[i]);
        System.out.println(solution(arr,M));
    }
}
