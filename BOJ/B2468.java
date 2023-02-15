import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2468 {
    // 시간복잡도 : O(V^3)
    // 로직
    // 1. N*N 크기의 2차원 배열을 선언하고, 입력받음
    // 2. bfs를 진행하기 위한 반복문을 돌면서 (0,0) 부터 방문 시작
    // 3. 좌표를 저장하기 위해 별도의 클래스 선언
    // 4. 안전영역의 최대 값을 구해야 하므로
    // 5. 하나의 좌표를 방문할 때 큐에 해당 좌표값을 저장하고, 좌표의 상하좌우 값을 살핀다
    // 6. 좌표를 방문했을 땐 방문을 체크하는 변수를 선언해 1로 초기화 하고 큐에 넣어준다
    static class Metix{
        int x;
        int y;
        public Metix(int x, int y) { this.x = x; this.y = y; }
    }
    static int[][] area;
    static boolean[][] visited;
    static int N;
    public static int bfs(int b){
        int[] xArr = {1,0,-1,0};
        int[] yArr = {0,1,0,-1};

        int count = 0;

        for(int k=0;k<N;k++){
            for(int j=0;j<N;j++){
                if(area[k][j] <= b||visited[k][j]) continue;
                Queue<Metix> queue = new LinkedList<>();
                queue.offer(new Metix(k,j)); //시작점 추가
                visited[k][j] = true;

                while(!queue.isEmpty()){
                    Metix m = queue.poll();
                    int x = m.x;
                    int y = m.y;

                    for(int i=0;i<4;i++){
                        int row = x+xArr[i];
                        int col = y+yArr[i];
                        if(row < 0 || row >=N || col <0 || col >=N) continue;
                        if(visited[row][col] || area[row][col] <= b) continue;
                        visited[row][col] = true;
                        queue.offer(new Metix(row,col));
                    }
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        StringTokenizer st;
        int max = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max,area[i][j]);
            }
        }
        int answer = 0;
        for(int h=0;h<max;h++){ // 높이의 시작부터 전부 돌면서 체크해야함
            visited = new boolean[N][N];
            answer = Math.max(answer,bfs(h));
        }
        System.out.println(answer);
    }
}
