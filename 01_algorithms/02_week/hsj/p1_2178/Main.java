import java.io.*;
import java.util.*;

public class Main {
    static class Route{
        int x;
        int y;
        int cnt;
        Route(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        // bfs 사용 N,M 도달하면 칸 수 갱신
        Queue<Route> q = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];
        q.offer(new Route(0,0,1));
        visited[0][0] = true;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int answer = 10001;

        while(!q.isEmpty()){
            Route cur = q.poll();

            for (int i=0;i<4;i++){
                int x = cur.x+dir[i][0];
                int y = cur.y+dir[i][1];
                if (x>=0 && x<n && y>=0 && y<m && !visited[x][y] && arr[x][y] ==1){
                    if (x == n-1 && y == m-1){
                        answer = Math.min(cur.cnt+1, answer);
                    }
                    else {
                        q.offer(new Route(x,y,cur.cnt+1));
                    }
                    visited[x][y] = true;
                }
            }
        }

        System.out.print(answer);

    }
}