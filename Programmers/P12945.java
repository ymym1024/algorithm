public class P12945 {
    int[] arr = new int[100_001];
    public int solution(int n) {
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<=n;i++) arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(new P12945().solution(5));
    }
}
