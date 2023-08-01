import java.util.Hashtable;

public class P81301 {
    // 문제 요약
    // 시간복잡도 : O(N^2)
    // 해시테이블로 숫자와 문자열 매핑 후 해당 숫자가 나오면 replace
    // 문자열이 없으면 해시테이블 조회 없이 바로 리턴
    static String[] dataSet = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};

    public static void main(String[] args) {
        System.out.println(solution("123"));
    }
    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    static int solution(String s) {
        if(isInteger(s)) return Integer.parseInt(s);
        else{
           for(int i=0;i<dataSet.length;i++){
               if(s.indexOf(dataSet[i])>=0){
                  s = s.replaceAll(dataSet[i], String.valueOf(i));
               }
           }
        }
        return Integer.parseInt(s);
    }
}
