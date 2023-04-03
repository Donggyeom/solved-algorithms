import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Node> nodeMap = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			Node node = nodeMap.get(input[0]);
			if ( node == null ) {
				node = new Node();
				node.value = input[0].charAt(0);
				
				nodeMap.put(input[0], node);
			}
			
			if ( !input[1].equals(".") ) {
				Node left = new Node();
				left.value = input[1].charAt(0);
				
				node.left = left;
				
				nodeMap.put(input[1], left);
			}
			if ( !input[2].equals(".") ) {
				Node right = new Node();
				right.value = input[2].charAt(0);
				
				node.right = right;
				
				nodeMap.put(input[2], right);
			}
		}
		
		Node.preorder(nodeMap.get("A"));
		System.out.println();
		Node.inorder(nodeMap.get("A"));
		System.out.println();
		Node.postorder(nodeMap.get("A"));
	}
}

class Node {
	char value;
	Node left;
	Node right;

	// 전위 순회
	static void preorder(Node root) {
		System.out.print(root.value);
		if (root.left != null)
			preorder(root.left);
		if (root.right != null)
			preorder(root.right);
	}

	// 중위 순회
	static void inorder(Node root) {
		if (root.left != null)
			inorder(root.left);
		System.out.print(root.value);
		if (root.right != null)
			inorder(root.right);
	}

	// 후위 순회
	static void postorder(Node root) {
		if (root.left != null)
			postorder(root.left);
		if (root.right != null)
			postorder(root.right);

		System.out.print(root.value);
	}
}


/**
  * 1991. 트리 순회
  * 
**/