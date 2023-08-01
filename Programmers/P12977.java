public class P12977 {
    // 문제 로직
    // 필요한 자료구조 : 배열
    // 1. 조합을 이용해 입력값 중 3개를 뽑는다
    // 2. 뽑은 3개의 숫자를 더한 후 배열에 저장한다
    // 3. 에라토스테네스의 체를 통해 소수인지 판별하고 소수이면 num 변수를 1 증가 시켜줌

    static int count = 0;
    public int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        comb(nums,visited,0,3);
        return count;
    }

    static void comb(int[] arr, boolean[] visited, int start, int r) {
        if(r == 0) {
            int num = 0;
            for(int i=0;i<arr.length;i++){
                if(visited[i] == true){
                    num+=arr[i];
                }
            }
            isPrime(num);
            return;
        } else {
            for(int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
    static void isPrime(int num){
        if(num < 2) return;
        if(num == 2) return;

        for(int i = 2; i <= Math.sqrt(num); i++) if(num % i == 0) return;

        count++;
        return;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,7,6,4};
        System.out.println(new P12977().solution(arr));
    }
}
