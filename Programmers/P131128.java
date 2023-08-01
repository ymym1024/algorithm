import java.util.*;

public class P131128 {
    // x, y 내림차순
    //
    public String solution(String X, String Y) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[10];

        for(int i=0;i<Y.length();i++){
            int n= Y.charAt(i)-48;
            answer[n]++;
        }
        int zero = answer[0];
        for(int i =0; i<X.length(); i++) {
            int n = X.charAt(i)-48;
            if(answer[n]>0) {
                answer[n]--;
                list.add(n);
            }
        }

        list.sort(Comparator.reverseOrder());

        for(int i=0;i<list.size();i++) sb.append(list.get(i));
        if(sb.length() == 0) return "-1";
        if(sb.length() == zero) return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        String X = "100";
        String Y = "203045";

        System.out.println(new P131128().solution(X,Y));
    }
}
