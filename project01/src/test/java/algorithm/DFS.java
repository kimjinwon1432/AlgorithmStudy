package algorithm;

import static org.junit.Assert.*;


import org.junit.Test;
import java.util.*;
/*
 *  그래프에서 숫자가 있는 원은 정점(Vertex)라고 하고,
 *  정점과 정점을 잇는 연결선을 간선(Edge)이라고 한다. 
 *  정점의 최대 개수는 30개이다. 
 *  간선의 길이를 1이라고 하고, N개의 정점과 M개의 간선이 주어졌을 때, 
 *  DFS를 이용하여 시작점으로부터 도착점까지의 최단 경로를 찾아 거리를 출력하시오. 
 *  시작점에서 도착점으로 갈 수 있는 방법이 없는 경우 -1을 출력하시오.
 *  
 *  
2
8 10 1 8
1 2
1 3
2 7
2 4
3 5
3 6
4 7
5 7
6 7
6 8
8 10 2 8
1 2
1 3
2 7
2 4
3 5
3 6
4 7
5 7
6 7
6 8
 */
public class DFS {

	final int MAX_VERTEX = 30;
	int[][] map = new int[MAX_VERTEX][MAX_VERTEX];
	boolean[] visit = new boolean[MAX_VERTEX];
	int vertex;
	int edge;
	int maxEdge;
	int start;
	int end;
	/*
	 *      v: 현재 방문하고 있는 정점. 
	 *  depth: 현재까지의 깊이
	 */
	public void depthFirstSearch(int v, int depth) {
		if(v== end) { //목적지인지 확인
			if(maxEdge < 0 || depth <maxEdge ) { //목적지 도달 시 maxEdge와 비교해 최단거리 갱신
				maxEdge = depth;
			}
			return;
		}
		// 그래프의 정점 방문 표시
		visit[v] = true;
		for(int i =1; i<= vertex; i++) {
			if(map[v][i] ==1 ) { // 정점 v에서 i로의 간선이 있는지 확인
				depthFirstSearch(i, depth+1);
				visit[i]=false;// 재귀호출 마친 뒤 다시 방문 가능하도록 변경
			}
		}
	}
	
	
	
	@Test
	public void test() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case=1;  test_case<=T; test_case++) { 
			vertex = sc.nextInt();
			edge = sc.nextInt();
			start = sc.nextInt();
			end = sc.nextInt();
			for(int i = 0; i< edge; i++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				map[v1][v2]= 1; 
			}
			maxEdge = -1;
			depthFirstSearch(start,0); // 시작 위치는 깊이가 0임.
			System.out.printf("#%d %d\n", test_case, maxEdge);
		}
		sc.close();
	}

}
