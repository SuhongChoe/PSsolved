import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> q = new LinkedList<>();

    public static void push(int x){
        q.addLast(x);
    }
    public static int pop(){
        return !q.isEmpty() ? q.poll() : -1;
    }
    public static int size(){
        return q.size();
    }
    public static int empty(){
        return q.isEmpty() ? 1 : 0;
    }
    public static int back(){
        return !q.isEmpty() ? q.peekLast() : -1;
    }
    public static int front(){
        return !q.isEmpty() ? q.peekFirst() : -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                push(x);
            } else if (cmd.equals("pop")){
                sb.append(pop()).append("\n");
            } else if (cmd.equals("size")){
                sb.append(size()).append("\n");
            } else if (cmd.equals("empty")){
                sb.append(empty()).append("\n");
            } else if (cmd.equals("front")){
                sb.append(front()).append("\n");
            } else {
                sb.append(back()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
