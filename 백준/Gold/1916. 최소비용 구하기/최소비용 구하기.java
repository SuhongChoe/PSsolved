import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void read() throws IOException{
        st = new StringTokenizer(br.readLine());
    }
    static int nextInt(){
        return Integer.parseInt(st.nextToken());
    }

    public static class Point {
        int num;
        int distance;
        public Point(int a, int b){
            num = a;
            distance = b;
        }
    }

    static int n, m;
    static int[] dist;
    static List<Point>[] graph;
    static int a, b;

    static void mst(){
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> (p1.distance-p2.distance));
        dist[a] = 0;
        pq.add(new Point(a, 0));

        while(!pq.isEmpty()){
            Point node = pq.poll();

            if(dist[node.num] < node.distance) continue;

            for(int i=0; i<graph[node.num].size(); i++){
                Point next_node = graph[node.num].get(i);

                int new_distance = node.distance + next_node.distance;

                if(dist[next_node.num]>new_distance){
                    dist[next_node.num] = new_distance;
                    pq.add(new Point(next_node.num, new_distance));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        read();
        n = nextInt();
        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) graph[i] = new ArrayList<Point>();
        dist = new int[n+1];
        for(int i=1; i<=n; i++) dist[i] = Integer.MAX_VALUE;

        read();
        m = nextInt();
        for(int i=0; i<m; i++){
            read();
            // a, b, cost
            graph[nextInt()].add(new Point(nextInt(), nextInt()));
        }

        read();
        a = nextInt();
        b = nextInt();

        mst();

        System.out.print(dist[b]);

    }
}
