import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class B1448 {
    // 시간복잡도 : O(nlogn) -> array.sort : O(logn)
    // 세변길이의 합을 구해야 하므로 내림차순으로 정렬 후 삼각형이 되는 조건에 만족하는 경우 반복문 탈출
    // 1. 입력받은 데이터를 정렬
    // 2. 인덱스 i, 인덱스 i+1, i+2 의 합 비교
    // 3. 삼각형 조건에 만족하는 경우 합을 출력하고 반복문 나옴
    // 4. 조건에 만족하지 않는경우 -1 반환
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tri = new int[N];
        for(int i=0;i<N;i++){
            tri[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tri);
        int index = tri.length;
        int check = 0;
        while(index>=3){
            int c1 = tri[--index];
            int c2 = tri[index-1];
            int c3 = tri[index-2];

            if(c1 < c2+ c3){
                check = c1+c2+c3;
                break;
            }else{
                check = -1;
            }
        }
        System.out.println(check);
    }
}
