import java.io.*;
import java.util.*;

//public class Main_1759{
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringTokenizer st;
//    
//    static int l, c;
//    static List<String> str = new ArrayList<>();
//
//    static HashSet<Character> moSet = new HashSet<>();
//
//    static StringBuffer sb = new StringBuffer();
//
//    public static void dfs(int idx, String tmp){
//        if (tmp.length()==l){
//            int ja = 0;
//            int mo = 0;
//
//            for(char s : tmp.toCharArray()){
//                if(moSet.contains(s)) mo++;
//                else ja++;
//            }
//            
//            if(ja>=2 && mo>=1) sb.append(tmp).append("\n");
//            
//            return;
//        }
//
//        if (idx==c) return;
//
//        dfs(idx+1, tmp+str.get(idx));
//        dfs(idx+1, tmp);
//    }
//    
//    public static void main(String[] args) throws IOException{
//        st = new StringTokenizer(br.readLine());
//        l = Integer.parseInt(st.nextToken());
//        c = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//        for(int i=0; i<c; i++) str.add(st.nextToken());
//
//        Collections.sort(str);
//
//        moSet.add('a'); 
//        moSet.add('e');
//        moSet.add('i');
//        moSet.add('o');
//        moSet.add('u');
//
//        dfs(0, "");
//
//        System.out.print(sb);
//    }
//}

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static void read() throws IOException{
		st = new StringTokenizer(br.readLine());
	}
	static int nextInt() {
		return Integer.parseInt(st.nextToken());
	}
	
	static int L, C;
	static char[] passwords;
	static boolean[] visited;
	
	static void dfs(int idx, int cnt, String tmp) {
		if(cnt==L && checkPwd(tmp.toCharArray())) {
			System.out.println(tmp);
			return;
		}
		for(int i=idx; i<C; i++) {
			if(!visited[idx]) {
				visited[idx] = true;
				dfs(i+1, cnt+1, tmp + passwords[i]);
				visited[idx] = false;
			}
		}
	}
	
	static boolean checkPwd(char[] str) {
		int consonant=0;
		int vowel=0;
		for(char c : str) {
			if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
				vowel++;
			}
			else {
				consonant++;
			}
		}
		
		return (vowel>=1 && consonant>=2);
	}

	public static void main(String[] args) throws IOException{
		read();
		L = nextInt();
		C = nextInt();
		passwords = new char[C];
		read();
		for(int i=0; i<C; i++) passwords[i] = st.nextToken().charAt(0);
		Arrays.sort(passwords);
		visited = new boolean[C];
		Arrays.fill(visited, false);
		
		dfs(0, 0, "");
	}
}