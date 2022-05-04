package graph;
import java.util.*;
public class Graph {
	
	private ArrayList<String> vertexList; //存储顶点集合
	private int[][] edges; //存储图对应的邻结矩阵
	private int numOfEdges; //表示边的数目
	
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
	}
	
	// Constructor
	public Graph(int n) {
		edges = new int [n][n];
		vertexList = new ArrayList<String> (n);
		numOfEdges = 0;
	}
	//返回结点的个数
	public int getNUmOfVertex() {
		return vertexList.size();
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

