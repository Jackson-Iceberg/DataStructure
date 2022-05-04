package binarysorttree;

public class BinarySortTreeDemo {
	public static void main(String[] args) {
		int[] array = {7,3,10,12,5,1,9};
		BinarySortTree bst = new BinarySortTree();
		// 循环的添加结点到二叉排序树
		for(int i = 0;i<array.length;i++) {
			bst.add(new Node(array[i]));
		}
		// 中序遍历二叉排序树
		System.out.println("中序遍历二叉排序树");
		bst.infixOrder();
	}
}

// 创建二叉排序树
class BinarySortTree{
	private Node root;
	// 添加结点
	public void add(Node node) {
		if(root == null) {
			root = node;
		}else {
			root.add(node);
		}
	}
	//中序遍历
	public void infixOrder() {
		if(root != null) {
			root.infixOrder();
		}else {
			System.out.println("二叉排序树为空，不能遍历");
		}
	}
}


class Node{
	int value;
	Node left;
	Node right;
	public Node(int value) {
		this.value = value;
	}
	
	/// 添加结点的方法
	// 递归的形式添加结点，注意需要满足二叉排序树的要求
	public void add(Node node) {
		if(node == null) {
			return;
		}
		
		// 判断传入的结点的值，和当前子树的根结点的值关系
		if(node.value < this.value) {//传入结点比当前结点小
			// 检查左结点是否为空
			if(this.left == null) {
				this.left = node;
			}else {
				// 递归的向左子树添加
				this.left.add(node);
			}
		}
		else {//传入结点比当前结点的值大，或者相等
			if(this.right == null) {
				this.right = node;
			}else {
				this.right.add(node);
			}
		}		
	}
	//中序遍历
	public void infixOrder() {
		if(this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right != null) {
			this.right.infixOrder(); 
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
}