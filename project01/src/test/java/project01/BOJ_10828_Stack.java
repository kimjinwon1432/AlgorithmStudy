package project01;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

public class BOJ_10828_Stack {

	@Test
	public void test() throws IOException {
//		fail("Not yet implemented");
		Stack stack = new Stack();

		///
		ClassPathResource resource = new ClassPathResource("text01.txt");
//		byte[] bdata = FileCopyUtils.copyToByteArray(resource.getInputStream());
//		String jsonTxt = new String(bdata, StandardCharsets.UTF_8);
//		System.out.println(jsonTxt);
		System.out.println(resource.getURI().getPath());

		System.setIn(new FileInputStream(resource.getURI().getPath()));
		///
		
		
        
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int cnt = Integer.parseInt(br.readLine());
        
		for(int i=0 ;i<cnt; i++) {
            
			str = new StringTokenizer(br.readLine()," ");
			String cdt = str.nextToken().toString();
			if(cdt.equals("push")) {
				stack.push(Integer.parseInt(str.nextToken()));
			} else if(cdt.equals("pop")) {
				System.out.println(stack.pop());
			} else if(cdt.equals("top")) {
				System.out.println(stack.top());
			} else if(cdt.equals("empty")) {
				System.out.println(stack.empty());
			} else if(cdt.equals("size")) {
				System.out.println(stack.size());
			}
		}
	
	}
	

}

class Stack {
	int size = 0; // stack 의 크기
	int top = -1; // 현재 위치
	int[] arr; // 배열
	
	public Stack() {
		arr= new int[0];
		size = arr.length;
	}
	
	/** push
	 * 호출 시 top++수행 후 stack의 사이즈 키우고, 값 넣어야함.
	 * @param num
	 */
	
	public void push(int num) {
		int[] tmp= new int[arr.length+1];
		if(top>=0) {
			for(int i =0; i<=top; i++) {
				tmp[i]=arr[i];
			}
		}
		top++;
		tmp[top]=num;
		size=tmp.length;
		arr = tmp;
	}
	
	/** pop
	 * 호출 시 맨 마지막에들어온 값 출력 및 top--, stack의 크기 감소(arr.length--) 
	 */
	public int pop() {
		if(top ==-1){
            return -1;
        }else {
            int num = arr[top];
            int[] tmp = new int[arr.length-1];
		    for(int i=0; i<top; i++) {
		    	tmp[i] = arr[i];
		    }
            top--;
		    arr= tmp;
	    	size=arr.length;
		    return num;    
        }
		
	}
	
	/** top
	 * 맨 위의 값 출력
	 * 정수가 없을 떈 -1
	 */
	public int top() {
		int num = top ==-1 
				? -1
				: arr[top];
		
		return num;
	}
	/** empty
	 * 스택이 비었으면 1, 아니면 0
	 * @return
	 */
	public int empty() {
		int num = (size==0)?
					1:
					0;
		return num;
	}
	/** size
	 * 스택의 크기 출력
	 */
	public int size() {
		return size;
	}
}