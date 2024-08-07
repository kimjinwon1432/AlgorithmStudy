package BOJ.AL100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.junit.Test;

public class BOJ_9012 {
	@Test
	public void test() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		int T = Integer.parseInt(br.readLine());
		
		for(int i =0; i<T; i++) {
			String isVPS = br.readLine();
			int cntPS =0; //  ( : + ,,, ): -
			for(int j=0; j<isVPS.length(); j++) {
				if(isVPS.charAt(j)=='(') cntPS++;
				else if(isVPS.charAt(j) ==')') {
					if(cntPS==0) {cntPS--; break;}
					else cntPS--;
				}
			}
			if(cntPS==0) System.out.println("YES");
			else  System.out.println("NO");
			
		}
	}
}
