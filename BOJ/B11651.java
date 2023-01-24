import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class B11651 {
    public static int[][] sort(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            arr[i][0] = Integer.parseInt(str.split(" ")[0]);
            arr[i][1] = Integer.parseInt(str.split(" ")[1]);
        }
        int[][] newArr = sort(arr);
        for(int i=0;i<N;i++){
            System.out.println(newArr[i][0]+" "+newArr[i][1]);
        }
    }
}
