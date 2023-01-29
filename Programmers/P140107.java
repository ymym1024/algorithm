public class P140107 {
    // 1. 반복문을 돌면서 a*k 만큼
    // 2. x,y 의 원점사이의 거리가 d보다 큰 경우 반복문 종료
    // 3. 점을 찍으면 answer로 1씩 증가
    public long solution(int k, int d) {
        long answer = 0;
       
        for(long x=0;x<=d;x=x+k){
            double dis = Math.sqrt(Math.pow(d,2)-Math.pow(x,2));
            if(dis > (double) d) break;
            answer+=2;
            /*for(long y=0;y<=d;y=y+k){
                double dis = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
                if(dis > (double) d) break;

                answer++;
            }*/
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new P140107().solution(1,5));
    }
}
