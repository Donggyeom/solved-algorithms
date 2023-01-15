import java.util.*;
import java.io.*;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            // 테스트케이스 시작
            // 입력데이터 초기화
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            int[] targetNumber = new int[2];
            targetNumber[0] = Integer.parseInt(input[2]);
            targetNumber[1] = Integer.parseInt(input[3]);
 
            Tree tree = new Tree(1);
            input = br.readLine().split(" ");
            for (int i = 0, length = E * 2; i < length; i = i + 2) {
                tree.addNode(Integer.parseInt(input[i]), Integer.parseInt(input[i + 1]));
            }
             
            int commonParent = 0;
            List<Integer> parents1 = tree.getParents(targetNumber[0]);
            List<Integer> parents2 = tree.getParents(targetNumber[1]);
            for (int i = 0, length = Math.min(parents1.size(), parents2.size()); i < length; i++) {
                int number = parents1.get(i).intValue();
                if (number != parents2.get(i).intValue()) break;
                 
                commonParent = number;
            }
             
            int subTreeSize = tree.getTreeSize(commonParent);
             
            StringBuilder sb = new StringBuilder();
            sb.append("#");
            sb.append(tc+1);
            sb.append(" ");
            sb.append(commonParent);
            sb.append(" ");
            sb.append(subTreeSize);
            sb.append("\n");
             
            bw.write(sb.toString());
            // 테스트케이스 끝
        }
        bw.flush();
    }
}
 
class Node {
    int number;
    Node parent;
    List<Node> children;
     
    public Node(int number) {
        this.number = number;
        this.children = new ArrayList<Node>();
    }
}
 
class Tree {
    Node root;
    Map<Integer, Node> nodes;
    int size;
 
    public Tree(int root) {
        this.root = new Node(root);
        this.nodes = new HashMap<Integer, Node>();
        this.size = 0;
         
        this.nodes.put(root, this.root);
    }
     
    public void addNode(int parent, int child) {
        Node cNode = this.nodes.get(child);
        if (cNode == null) {
            cNode = new Node(child);
            this.nodes.put(child, cNode);
        }
         
        Node pNode = this.nodes.get(parent);
        if (pNode == null) {
            pNode = new Node(parent);
            this.nodes.put(parent, pNode);
        }
         
        pNode.children.add(cNode);
        cNode.parent = pNode;
    }
     
    public List<Integer> getParents(int number) {
        List<Integer> parents = new ArrayList<>();
         
        Node nodeIndex = nodes.get(number);
        while (nodeIndex.parent != null) {
            parents.add(0, nodeIndex.parent.number);
            nodeIndex = nodeIndex.parent;
        }
         
        return parents;
    }
     
    public int getTreeSize(int root) {
        // bfs 순회를 이용한 트리 노드 카운트
        int count = 0;
        Queue<Node> bfsQue = new LinkedList<>();
        bfsQue.add(this.nodes.get(root));
        while ( !bfsQue.isEmpty() ) {
            int length = bfsQue.size();
            for (int i = 0; i < length; i++) {
                count++;
                 
                Node node = bfsQue.poll();
                 
                bfsQue.addAll(node.children);
            }
        }
         
        return count;
    }
}