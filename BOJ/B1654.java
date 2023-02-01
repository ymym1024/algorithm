import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1654 {
    static int[] lenline;
    static int K;
    static int N;
    public static long solution(int[] arr,int N) {
        long left = 0;
        long right=0, mid = 0;

        for (int i = 0; i < arr.length; i++) {
           if(right < arr[i]) right = arr[i];
        }
        right++;

        while (left < right) {
            mid = (left + right) / 2;
            if(isCheck(mid)){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left-1;
    }
    public static boolean isCheck(long len){
        long cnt = 0;
        for(int i=0;i<lenline.length;i++){
            cnt+=(lenline[i]/len);
        }
        if(cnt>=N) return true;
        else return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        K = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        lenline = new int[K];
        for(int i=0;i<K;i++) lenline[i] = Integer.parseInt(br.readLine());
        System.out.println(solution(lenline,N));
    }
}
