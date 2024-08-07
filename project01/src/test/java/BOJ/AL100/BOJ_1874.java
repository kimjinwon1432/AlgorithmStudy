package BOJ.AL100;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

import org.junit.Test;

public class BOJ_1874 {

	@Test
	public void test() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack();
		int start =0; // 어디까지 입력 을 받았는지 알기위한 변수
		for (int i=0; i<n; i++) {
			// 수를 입력받고, start부터 입력받은 수까지 push 수행 후, 입력 받은 수ㅡㄹ pop할 수 있는지 확인해야함.
			int input = Integer.parseInt(br.readLine());
			if(start < input) { // 입력값이 이전에 입력했던 값보다 클시 push해야함.
				for(int j=start+1; j<=input; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				start = input;
			}
			else if(stack.peek() != input) { // 입력값이 stack 현재 pop과 동일하지 않을떄.
				System.out.println("No");
				return;
			}
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(sb);
	}
}