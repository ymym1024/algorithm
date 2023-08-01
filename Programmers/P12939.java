public class P12939 {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            int num = Integer.parseInt(arr[i]);
            if(max < num) max = num;
            if(min > num) min = num;
        }
        return min+" "+max;
    }
    public static void main(String[] args) {
        System.out.println(new P12939().solution("-1 -2 -3 -4"));
    }
}
