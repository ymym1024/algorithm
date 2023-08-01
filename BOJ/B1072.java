import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1072 {

    public static int solution(float start,float end){
        float target = (start/end)+1;
        float answer=0;
        float temp = 0;
        while(start <= end){
            answer = temp;
            temp = (float) ((start+end)/2.0);
            if(temp > target) start = (float) (temp+0.1);
            else if(temp < target) end = (float) (temp-0.1);
            else break;
        }
        return (int) answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int X = Integer.parseInt(st[0]);
        int Y = Integer.parseInt(st[1]);
        System.out.println(solution(Y,X));
    }
}
