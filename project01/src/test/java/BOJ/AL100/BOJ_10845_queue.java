package BOJ.AL100;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

public class BOJ_10845_queue {

	static int[] que = new int[10001];
	static int first=0;
	static int last= 0;
	
	@Test
	public void test() throws IOException{
		ClassPathResource resource = new ClassPathResource("BOJ/BOJ_10845_1.txt");

		System.setIn(new FileInputStream(resource.getURI().getPath()));
		///
		
//		BufferedReader br = new BufferedReader( new InputStreamReader(resource.getInputStream()));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			String S = st.nextToken();
			
			switch(S) {
			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				sb.append(pop()).append("\n");
				break;
			case "size":
				sb.append(size()).append("\n");
				break;
			case "empty":
				sb.append(empty()).append("\n");
				break;
			case "front":
				sb.append(front()).append("\n");
				break;
			case "back":
				sb.append(back()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
	public static void push(int X) {
		que[last]=X;
		last++;
	}
	public static int pop() {
		if(last-first == 0) {
			return -1;
		} else {
			return 0;
		}
	}
	public static int front() {
		if(last - first ==0) {
			return -1;
		} else {
			int F= que[first];
			return F;
		}
	}
	public static int size() {
		return last-first;
	}

	public static int empty() {
		if(last-first == 0) {
			return 1;
		} else return 0;
	}
	public static int back() {
		if(last-first == 0) {
			return -1;
		} else {
			int B= que[last -1];
			return B;
		}
	}
}
