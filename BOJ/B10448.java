import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10448 {
    public static int solution(int K){
        int answer = 0;
        int t = K/2;
        loofout:
        for(int i = 1;i<=t;i++){
            int t1 = i*(i+1)/2;
            for(int j = 1;j<=t;j++){
                int t2 = j*(j+1)/2;
                for(int m = 1;m<=t;m++){
                    int t3 = m*(m+1)/2;
                    if(t1+t2+t3 == K){
                        answer = 1;
                        break loofout;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int K = Integer.parseInt(br.readLine());
            System.out.println(solution(K));
        }
    }
}
