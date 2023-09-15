import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class outsider {
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public static void main(String[] args) {
        
    }
    public List<Integer> preorder(Node root) {
        Stack<Node> temp = new Stack<>();
        List<Integer> res = new ArrayList<>();
        List<Node> store;
        Node mid;
        temp.add(root);
        while (!temp.isEmpty()) {
            mid = temp.pop();
            store = mid.children;
            if (mid.children.isEmpty()) continue;
            for (int i = store.size()-1; i >=0 ; i--) {
                temp.add(store.get(i));
            }
            res.add(mid.val);


        }
        return res;
    }

}
