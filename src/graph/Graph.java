package graph;
import java.util.*;
public class Graph {
	
	private ArrayList<String> vertexList; //存储顶点集合
	private int[][] edges; //存储图对应的邻结矩阵
	private int numOfEdges; //表示边的数目
	private boolean[] isVisited;// 表示是否被访问
	
	public static void main(String[] args) {
		int n = 5; // 结点的个数
		String Vertexs[] = {"A","B","C","D","E"};
		// 创建图对象
		Graph graph = new Graph(n);
		// 循环添加顶点
		for(String vertex:Vertexs) {
			graph.insertVertex(vertex);
		}
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		
		graph.showGraph();
		
		System.out.println("深度遍历");
		graph.dfs();
	}
	
	// Constructor
	public Graph(int n) {
		edges = new int [n][n];
		vertexList = new ArrayList<String> (n);
		numOfEdges = 0;
		isVisited = new boolean[n];
	}
	//返回结点的个数
	public int getNUmOfVertex() {
		return vertexList.size();
	}
	
	public int getFirstNeighbor(int index) {
		for(int j = 0;j<vertexList.size();j++) {
			if(edges[index][j]>0) {
				return j;
			}
		}
		return -1;
	}
	
	public int getNextNeighbor(int v1,int v2) {
		for(int j=v2+1;j<vertexList.size();j++) {
			if(edges[v1][j]>0) {
				return j;
			}
		}
		return -1;
		}
	public void dfs(boolean[] isVisited,int i) {
		System.out.print(getValueByIndex(i)+"->");
		isVisited[i] = true;
		int w = getFirstNeighbor(i);
		while(w!=-1) {
			if(!isVisited[w]) {
				dfs(isVisited,w);
			}
			w = getNextNeighbor(i,w);
		}
	}
	public void dfs() {
		// 遍历所有的结点，进行dfs回溯
		for(int i = 0;i<getNUmOfVertex();i++) {
			if(!isVisited[i]) {
				dfs(isVisited,i);
			}
		}
	}
	
	// 得到边的个数
	public int getNumOfEdges() {
		return numOfEdges;
	}
	// 返回结点i对应的数据
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	// 返回v1和v2的权值
	public int getWeight(int v1,int v2) {
		return edges[v1][v2];
	}
	// 显示矩阵
	public void showGraph() {
		for(int[] link:edges) {
			System.err.println(Arrays.toString(link));
		}
	}
	//插入结点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	// 添加边
	public void insertEdge(int v1,int v2,int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
}

