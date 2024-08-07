package BOJ.AL100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.junit.Test;

public class BOJ_9093 {
	@Test
	public void test() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++) {
			
			// 문장을 입력받는다.
			StringTokenizer str = new StringTokenizer(br.readLine(), " ");
			String syntax = "";
			// 입력받은 문장의 단어를 선택해서 반대로 출력시켜야함.
			while (str.hasMoreTokens()) {
				// 단어 선택ㄱ
				String word = str.nextToken();
				// 선택한 단어를 반대로 입력
				for(int j=word.length()-1; j>=0; j--) {
					syntax+= word.charAt(j);
				}
				syntax += " ";
			}
			System.out.println(syntax);
		}
	}

}
