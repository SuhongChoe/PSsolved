import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static void read() throws IOException{
		st = new StringTokenizer(br.readLine());
	}
	static int nextInt() {
		return Integer.parseInt(st.nextToken());
	}
	
	static int s;
	static String n;
	static char[][] lcd;
	
	static void lcdTest(int number, int cur) {
		if(number==0) {
			On1(cur);
			On2(cur);
			On3(cur);
			On5(cur);
			On6(cur);
			On7(cur);
		} else if (number==1){
			On3(cur);
			On6(cur);
		} else if (number==2){
			On1(cur);
			On3(cur);
			On4(cur);
			On5(cur);
			On7(cur);
		} else if (number==3){
			On1(cur);
			On3(cur);
			On4(cur);
			On6(cur);
			On7(cur);
		} else if (number==4){
			On2(cur);
			On3(cur);
			On4(cur);
			On6(cur);
		} else if (number==5){
			On1(cur);
			On2(cur);
			On4(cur);
			On6(cur);
			On7(cur);
		} else if (number==6){
			On1(cur);
			On2(cur);
			On4(cur);
			On5(cur);
			On6(cur);
			On7(cur);
		} else if (number==7){
			On1(cur);
			On3(cur);
			On6(cur);
		} else if (number==8){
			On1(cur);
			On2(cur);
			On3(cur);
			On4(cur);
			On5(cur);
			On6(cur);
			On7(cur);
		} else if (number==9){
			On1(cur);
			On2(cur);
			On3(cur);
			On4(cur);
			On6(cur);
			On7(cur);
		}
		return;
	}
	
	static void On1(int cur){
		for(int i=1; i<=s; i++) {
			lcd[0][cur+i] = '-';
		}
		return;
	}
	static void On2(int cur) {
		for(int i=1; i<=s; i++) {
			lcd[i][cur] = '|';
		}
		return;
	}
	static void On3(int cur) {
		for(int i=1; i<=s; i++) {
			lcd[i][cur+s+1] = '|';
		}
		return;
	}
	static void On4(int cur) {
		for(int i=1; i<=s; i++) {
			lcd[s+1][cur+i] = '-';
		}
		return;
	}
	static void On5(int cur) {
		for(int i=1; i<=s; i++) {
			lcd[s+1+i][cur] = '|';
		}
		return;
	}
	static void On6(int cur) {
		for(int i=1; i<=s; i++) {
			lcd[s+1+i][cur+s+1] = '|';
		}
		return;
	}
	static void On7(int cur) {
		for(int i=1; i<=s; i++) {
			lcd[2*s+2][cur+i] = '-';
		}
		return;
	}
	
	public static void main(String[] args) throws IOException{
		read();
		s = nextInt();
		n = st.nextToken();
		
		lcd = new char[2*s+3][(s+3)*n.length()-1];
		for(int i=0; i < 2*s+3; i++) Arrays.fill(lcd[i], ' ');
		
		for(int i=0; i<n.length(); i++) {
			lcdTest(n.charAt(i)-'0', i*(s+3));
		}
		
		for(int i=0; i<2*s+3; i++) {
			System.out.println(new String(lcd[i]));
		}
	}
}
