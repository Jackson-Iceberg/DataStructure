package huffmancode;
import java.util.* ;
public class HuffmanCode {
	public static void main(String[] args) {
		String content = "i like like like java do you like a java";
		byte[] contentBytes = content.getBytes();
		System.out.println(contentBytes.length); // 40
		
		List<Node> nodes = getNodes(contentBytes);
		System.out.println("nodes="+nodes);
		
		// 测试创建的二叉树
		System.out.println("赫夫曼树");
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		System.out.println("前序遍历");
		huffmanTreeRoot.preOrder();
		
	}
	
	private static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}else {
			System.out.println("Huffman树为空，不能遍历");
		}
	}
	
	
	private static List<Node> getNodes(byte[] bytes){
		// 1 创建一个ArrayList
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		// 遍历bytes，统计每个bytes出现的次数-> map[key,value]
		Map<Byte,Integer> counts = new HashMap<>();
		for(byte b:bytes) {
			Integer count = counts.get(b);
			if(count == null) {
				counts.put(b,1);
			}else {
				counts.put(b, count+1);
			}
		}
		// 把每一个键值对转成一个node对象，并加入到Nodes集合
		for(Map.Entry<Byte,Integer> entry:counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}
	
	// 可以通过List 创建对应的赫父曼树
	private static Node createHuffmanTree(List<Node> nodes) {
		while(nodes.size()>1) {
			// 排序 从小到大
			Collections.sort(nodes);
			// 取出第一颗最小的二叉树
			Node leftNode = nodes.get(0);
			// 取出第二颗最小的二叉树
			Node rightNode = nodes.get(1);
			// 创建一颗新的二叉树，他的根结点没有data，只有权值
			Node parent = new Node(null,leftNode.weight+rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			// 将已经处理好的两颗二叉树从nodes删除
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			// 将新的二叉树加入到nodes
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
}

//创建Node，带数据和权值
class Node implements Comparable<Node>{
	Byte data; // 存放数据（字符）本身，比如‘a' =》 97， “ ” 空格 = 32
	int weight; // 权值，表示字符出现的次数
	Node left;
	Node right;
	
	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}
	
	// 前序遍历
	public void preOrder() {
		System.out.println(this);
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
}
