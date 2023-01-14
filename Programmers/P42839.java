import java.util.HashSet;

public class P42839 {
    static HashSet<Integer> set = new HashSet<>();
    static char[] number;
    static boolean[] isSelected;

    public static void main(String[] args) {
        System.out.println(new P42839().solution("17"));
    }
    public int solution(String numbers) {
        number = new char[numbers.length()];
        isSelected = new boolean[numbers.length()];

        for(int i=0;i<numbers.length();i++){
            number[i]=numbers.charAt(i);
        }
        recursion("",0);
        return set.size();
    }

    public boolean isPrime(int num){
        if(num==1||num==0){
            return false;
        }
        for (int i=2;i<=(int)Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public void recursion(String str, int cnt){
        int num;
        if(str != ""){
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }
        if(number.length ==cnt){
            return;
        }

        for(int i=0;i<number.length;i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            recursion(str+number[i],cnt+1);
            isSelected[i] = false;
        }
    }
}
