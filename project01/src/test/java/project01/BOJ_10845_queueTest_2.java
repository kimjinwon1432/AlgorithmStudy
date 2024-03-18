package project01;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

public class BOJ_10845_queueTest_2 {

	static int[] queue =new int[10001];
	static int front =0;
	static int rear =0;
	@Test
	public void test() throws FileNotFoundException, IOException {
//		fail("Not yet implemented");
		ClassPathResource resource = new ClassPathResource("BOJ_10845_2.txt");

		System.setIn(new FileInputStream(resource.getURI().getPath()));
		///
		
		BufferedReader br = new BufferedReader( new InputStreamReader(resource.getInputStream()));
//		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0 ;i<N; i++) {
			str=new StringTokenizer(br.readLine(), " ");
			String cmd = str.nextToken();
			switch(cmd) {
			case "push":
				push(Integer.parseInt(str.nextToken()));
				break;
			case "pop" :
				sb.append(pop()+"\n");
				break;
			case "size" :
				sb.append(size() + "\n");
				break;
			case "empty" :
				sb.append(empty() + "\n");
				break;
			case "front" :
				sb.append(front() + "\n");
				break;
			case "back" :
				sb.append(back() + "\n");
				break;
			}
		}
		System.out.println(sb);
	}
	static void push(int X) {
		queue[rear++]=X;
	}
	static int pop() {
		if(front != rear) {
			int res = queue[front];
			queue[front++] =0;
			return res;
		}
		else {
			return -1;
		}
	}
	static int size() {
		return rear-front;
	}
	static int empty() {
		return front==rear ? 1 : 0;
	}
	static int front() {
		if(front != rear) {
			return queue[front];
		}
		else {
			return -1;
		}
		
	}
	static int back() {
		if(front!=rear) {
			return queue[rear-1];
		} else {
			return -1;
		}
	}
}
