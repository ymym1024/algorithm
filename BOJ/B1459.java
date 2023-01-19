import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1459 {
    // 경우에 따라 케이스를 나눔
    // x == y 일 경우엔 대각선으로 가는게 가장 최소 비용
    // 2w < s 인 경우엔 블럭으로 움직이는게 최소비용일 경우 이므로 x+y *w
    // w < s 인 경우엔 블록보다 대각선이 큰 경우-> 대각선으로 움직이고, 남은 블록은 블록으로 움직임
    // 그 외 나머지 케이스는 (대각선 길이 * x) + ((x-y) 절대값 * w)
    public static long solution(long x,long y,int w, int s){
        if( 2*w < s ){
            return (x+y)*w;
        }else if(x == y){
            return x*s;
        }else if(w>s){
            return (x+y)%2 == 0 ? Math.max(x,y) * s : ((Math.max(x,y)-1)*s) + w;
        }else{
            return (Math.min(x*s,y*s))+(Math.abs(x-y) *w);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        long x = Integer.parseInt(arr[0]);
        long y = Integer.parseInt(arr[1]);
        int w = Integer.parseInt(arr[2]);
        int s = Integer.parseInt(arr[3]);
        System.out.println(solution(x,y,w,s));
    }
}
