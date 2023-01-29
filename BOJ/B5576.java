import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B5576 {
    //시간복잡도 : O(nlogn)
    //로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] w = new int[10];
        int[] k = new int[10];
        for(int i=0;i<10;i++){
            w[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(w);
        for(int i=0;i<10;i++){
            k[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(k);

        int score1 = w[9]+w[8]+w[7];
        int score2 = k[9]+k[8]+k[7];

        System.out.println(score1+" "+score2);
    }
}
