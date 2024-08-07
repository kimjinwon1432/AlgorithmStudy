package project01;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1406 {
	
	@Test
	public void test() throws Exception{
		//resource 디렉터리 내의 파일 읽는 방법 -> ClassPathResource 를 이용한다.
		Resource resource = new ClassPathResource
//										("BOJ_1406_1.txt");
										("BOJ_1406_2.txt");
//										("BOJ_1406_3.txt");
		
		
		BufferedReader br = new BufferedReader( new InputStreamReader(resource.getInputStream()));
		//입력받은 최초의 문자
		String str = br.readLine();
		StringBuilder strBuilder = new StringBuilder(str);
		//현재 커서 위치
		int cursor= str.length();
		
		String command ;
		int T = Integer.parseInt(br.readLine());
		//명령어를 입력받음.
		while((command = br.readLine()) != null) {
			if(command.equals("L")) { // 커서 좌측 이동
				if(cursor!=0) cursor--;
			}
			else if(command.equals("D")) {// 커서 우측 이동
				if(cursor<str.length()) cursor++;
			}
			else if(command.charAt(0)=='P') { //삽입
				StringTokenizer st = new StringTokenizer(command, " ");
//				while(st.hasMoreTokens()) {
					
					st.nextToken(); // 첫번쨰 토큰(P)버리기
					String insertChar="";
					if(st.hasMoreTokens()) { // P $인지 확인
						insertChar = st.nextToken();
						strBuilder.insert(cursor,insertChar);
						cursor++;
					}
//				}
				str = strBuilder.toString();
			}
		}
		System.out.print(str);
		br.close();
		
	}
}
