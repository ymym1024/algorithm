import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class B20291 {
    // 시간복잡도 : O(n)
    // map을 정렬하기 위해서 treemap을 사용해서 구현해야 한다는 걸 배움
    // 1. 입력받은 파일 이름을 . 기준으로 나눔
    // 2. 나눈 확장자를 hashmap의 키 값에 저장
    // 3. 반복문을 돌면서 hashmap에 키가 있으면 cnt
    // 4. keyset 순서대로 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Map<String,Integer> fileDes = new HashMap<>();
        for(int i=0;i<N;i++){
            String file = br.readLine().split("[.]")[1];
            if(!fileDes.containsKey(file)) fileDes.put(file,1);
            else{
                Integer val = fileDes.get(file) + 1;
                fileDes.put(file,val);
            }
        }
        TreeSet<String> keySet = new TreeSet<String>(fileDes.keySet());

        for(String key : keySet){
            bw.write(key+" "+fileDes.get(key)+"\n");
        }

        bw.flush();
        bw.close();
    }
}
