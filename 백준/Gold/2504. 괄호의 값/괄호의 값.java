import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();
        Deque<Character> s = new LinkedList<>();

        int sum = 0;
        int mul = 1;

        for(int i=0; i<c.length; i++){
            if(c[i]=='('){
                s.addLast(c[i]);
                mul*=2;
            } else if (c[i]=='['){
                s.addLast(c[i]);
                mul*=3;
            } else if (c[i]==')'){
                if(!s.isEmpty() && s.peekLast()=='('){
                    if(c[i-1]=='(') sum += mul;
                    s.pollLast();
                    mul /= 2;
                } else { 
                    sum = 0;
                    break;
                }
            } else {
                if(!s.isEmpty() && s.peekLast()=='['){
                    if(c[i-1]=='[') sum += mul;
                    s.pollLast();
                    mul /= 3;
                } else {
                    sum = 0;
                    break;
                }
            }
        }

        if(!s.isEmpty()) sum = 0;
        
        System.out.print(sum);
    }
}