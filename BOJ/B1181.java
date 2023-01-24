import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1181 {
    // 정렬기준 -> 1.길이 2.사전순
    public static String[] sort(String[] dic){
        dic = Arrays.stream(dic).distinct().toArray(String[]::new);
        for(int i=0;i<dic.length-1;i++){
            for(int j=i+1;j<dic.length;j++){
                if(dic[i].length() > dic[j].length()){
                    String temp = dic[i];
                    dic[i] = dic[j];
                    dic[j] = temp;
                }else if(dic[i].length() == dic[j].length() && dic[i].compareTo(dic[j]) > 0){
                    String temp = dic[i];
                    dic[i] = dic[j];
                    dic[j] = temp;
                }
            }
        }
        return dic;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] dic = new String[N];
        for(int i = 0;i<N;i++){
            dic[i] = br.readLine();
        }
        String[] newArr =sort(dic);
        for(int i = 0;i<newArr.length;i++){
            System.out.println(newArr[i]);
        }
    }
}
