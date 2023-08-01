public class P67256 {
    // 문제 분석
    // 입력값 : 키패드 숫자 배열, hand
    // 결과 : 키패드를 누른 손
    // 자료구조 : 배열 (숫자, x,y 값 가지고 있는 배열)
    // 로직
    // 1. 왼손, 오른손 위치 저장할 변수 선언/ *, #로 초기화
    // 2. 키보드 자판의 위치를 배열로 초기화
    // 3. 키패드 숫자 배열을 순회
    // 4. 눌러야 할 숫자가 1,4,7 => 왼손 / 3,6,9 => 오른손
    // 5. 눌러야 할 숫자가 2,5,8,0 => 왼손 위치와 자판의 위치 사이의 거리를 구하고, 오른손 위치와 자판 위치 사이의 거리를 정수 값으로 구한다.
    // 6. 두 위치가 같은 경우에는 hand값을 이용하여 누를 위치를 정한다
    // 7. 문자열을 반환한다
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] keyboard = {{0,3,1},{1,0,0},{2,0,1},{3,0,2},{4,1,0},{5,1,1},{6,1,2},{7,2,0},{8,2,1},{9,2,2},{10,3,0},{11,3,2}};

        int left_hand = 10; // *
        int right_hand = 11; // #
        for(int i=0;i<numbers.length;i++){
            int n = numbers[i];
            if(n == 1||n == 4||n == 7) {
                answer.append("L");
                left_hand = n;
            }
            else if(n == 3||n == 6||n == 9) {
                answer.append("R");
                right_hand = n;
            }
            else{
                int nX = keyboard[n][1];
                int nY = keyboard[n][2];
                int rX = keyboard[right_hand][1];
                int rY = keyboard[right_hand][2];
                int lX = keyboard[left_hand][1];
                int lY = keyboard[left_hand][2];

                double rDistance = Math.ceil(Math.sqrt((nX-rX)*(nX-rX) + (nY-rY)*(nY-rY)));
                double lDistance = Math.ceil(Math.sqrt((nX-lX)*(nX-lX) + (nY-lY)*(nY-lY)));

                if(rDistance > lDistance){
                    answer.append("L");
                    left_hand = n;
                }else if(rDistance < lDistance){
                    answer.append("R");
                    right_hand = n;
                }else{
                    String h = hand.equals("left") ? "L":"R";
                    if(h.equals("L")) left_hand = n;
                    else right_hand = n;
                    answer.append(h);
                }
            }
        }
        return answer.toString();
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{0,0};
        System.out.println(new P67256().solution(numbers,"right"));
    }
}
