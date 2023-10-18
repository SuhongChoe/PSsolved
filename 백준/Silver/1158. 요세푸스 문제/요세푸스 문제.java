import java.util.*;
import java.io.*;

//public class Main_1158 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//
//        Deque<Integer> dq = new LinkedList<>();
//
//        for(int i=1; i<=n; i++) dq.addLast(i);
//
//        StringBuffer sb = new StringBuffer();
//        sb.append("<");
//        while(dq.size()>1){
//            for(int i=0; i<k-1;i++){
//                dq.addLast(dq.pollFirst());
//            }
//            sb.append(dq.pollFirst()).append(", ");
//        }
//
//        sb.append(dq.pollFirst()).append(">");
//
//        System.out.print(sb);
//
//    }
//}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();
        sb.append("<");

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=1; i<=n; i++) arr.add(i);

        int idx = 0;

        while(!arr.isEmpty()){
            idx = (idx + k - 1) % arr.size();
            sb.append(arr.get(idx)).append(", ");
            arr.remove(idx);
        }

        sb.setLength(sb.length()-2);
        sb.append(">");

        System.out.print(sb);

    }
}
