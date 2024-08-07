package BOJ.AL100;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406_2 {
	
	@Test
	public void test() throws Exception{
		//resource 디렉터리 내의 파일 읽는 방법 -> ClassPathResource 를 이용한다.
		Resource resource = new ClassPathResource
										("BOJ/BOJ_1406_1.txt");
//										("BOJ/BOJ_1406_2.txt");
//										("BOJ/BOJ_1406_3.txt");
		
		
		BufferedReader br = new BufferedReader( new InputStreamReader(resource.getInputStream()));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		//입력받은 최초의 문자
		String str = br.readLine();
		//스택에 넣기
		Stack<String> stackL = new Stack<>(); //입력 시 
		Stack<String> stackR = new Stack<>(); //커서 이동시 
		
		int i=0;
		for(i=0; i< str.length(); i++) {
			stackL.push(String.valueOf(str.charAt(i)));
		}
		//iterator 메소드 호출 
		ListIterator<Character> iter = list.listIterator();
		//처음 커서는 문장의 맨 뒤에 있어야하기 때문에 커서를 맨뒤로 이동시켜줌 (ex. abc|)
		while(iter.hasNext()) {
			iter.next();
		}
		
		String command ;
		//입력받을 명령어의 개수
		int T = Integer.parseInt(br.readLine());
		//명령어를 입력받음.
		
		for(i=0; i<T; i++) {
			command = br.readLine();
			char ch = command.charAt(0);
			switch(ch) {
			case 'L':
				if(!stackL.empty()) stackR.push(stackL.pop());
				break;
			case 'D':
				if(!stackR.empty()) stackL.push(stackR.pop());
				break;
			case 'P':
				StringTokenizer st = new StringTokenizer(command, " ");
				st.nextToken(); // 첫번쨰 토큰(P)버리기
				String insertChar="";
				if(st.hasMoreTokens()) { // P $인지 확인
					insertChar = st.nextToken();
					stackL.push(String.valueOf(insertChar));
				}
				break;
			}
//			if(command.equals("L")) { // 커서 좌측 이동
//				if(!stackL.empty()) stackR.push(stackL.pop());
//			}
//			else if(command.equals("D")) {// 커서 우측 이동
//				if(!stackR.empty()) stackL.push(stackR.pop());
//			}
//			else if(command.charAt(0)=='P') { //삽입
//				StringTokenizer st = new StringTokenizer(command, " ");
//				st.nextToken(); // 첫번쨰 토큰(P)버리기
//				String insertChar="";
//				if(st.hasMoreTokens()) { // P $인지 확인
//					insertChar = st.nextToken();
//					stackL.push(insertChar);
//				}
//			}
		}
		
		
		while (!stackL.empty()) {
			stackR.push(stackL.pop());
		}
		while (!stackR.empty()) {
			bw.write(stackR.pop());
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
