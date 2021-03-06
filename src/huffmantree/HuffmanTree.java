package huffmantree;
import java.util.*;
public class HuffmanTree {
	public static void main(String[] args) {
		int[] array = {13,7,8,3,29,6,1};
		Node root = createHuffmanTree(array);
		preOrder(root);
	}
	
	// 编写一个前序遍历的方法
	public static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}
		else {
			System.out.println("是空树，不能遍历");
		}
	}
	
	
	// 创建HuffmanTree的方法
	public static Node createHuffmanTree(int[]array) {
		// 1 遍历array数组
		// 2 将array的每个元素构成一个node
		// 3 将Node放入到ArrayList中
		List<Node> nodes = new ArrayList<>();
		for(int value:array) {
			nodes.add(new Node(value));
		}
		while(nodes.size()>1) {			
			// 排序 从小到大
			Collections.sort(nodes);
			System.out.println("nodes="+nodes);
			// 取出根结点权值最小的两颗二叉树
			// 1 取出权值最小的结点（二叉树）
			Node leftNode = nodes.get(0);
			// 2 取出权值第二小的结点（二叉树）
			Node rightNode = nodes.get(1);
			
			// 3 构建一颗新的二叉树
			Node parent = new Node(leftNode.value+rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			
			// 4 从ArrayList删除处理过的二叉树
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			
			// 5 将parent加入到nodes
			nodes.add(parent);
		}
		
		return nodes.get(0);
	}
	
}



// 创建结点类
// 为了让Node对象支持排序Collections集合排序
// 让Node实现Comparable接口
class Node implements Comparable<Node>{
	int value; // 结点权值
	char c; // 字符
	Node left; // 指向左子结点
	Node right;// 指向右子结点
	
	// 写一个前序遍历
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		// 从小到大排序
		return this.value-o.value;
	}
}
