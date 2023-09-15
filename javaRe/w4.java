public class w4 {
    
    public static void main(String[] args) {
        int[][] graph = {
            {0,1,0,0,0,1},
            {1,0,1,0,1,0},
            {0,1,0,1,0,0},
            {0,0,1,0,1,0},
            {0,1,0,1,0,1},
            {1,0,0,0,1,0}
        };
        Graph test = new Graph(graph);
        test.display();
    }
}

class Graph {
    int[] visited;
    int[][] graph;
    public Graph(int[][] graph) {
        visited = new int[graph.length];
        this.graph = graph;
    }
    public void display() {
        int[] visited = new int[graph.length];

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) dfs(i);
        }
        
    }

    public void dfs(int i) {
        visit(i);
        for (int j = 0; j < visited.length; j++) {
            if (visited[j] == 0 && graph[i][j] != 0) {
                dfs(j);
            }
        }
    }

    private void visit(int i) {
        if (visited[i] == 0) {
            System.out.println((char) (i+ 'A'));
            visited[i] = 1;
        }
    }

}

class BTN {
    public BTN parent = null;
    public BTN left = null;
    public BTN right = null;
    public int data;
    public BTN(int data) {
        this.data = data;
    }
}

class BST {
    public BTN root = null;
    private int count = 0;
    public BST() {}

    public int height(BTN node) {
        if (node == null) return 0;
        int a = height(node.left);
        int b = height(node.right);
        return Math.max(a+1, b+1);
    }

    public void inOrder(BTN node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public boolean addNode(int value) {
        if (this.root == null) {
            root = new BTN(value);
            return true;
        }
        BTN temp = this.root;
        BTN curr = null;
        while (temp != null) {
            if (temp.data < value) {
                curr = temp;
                temp = temp.right;
            }
            else if (temp.data > value) {
                curr = temp;
                temp = temp.left;
            }
            else {
                return false;
            }
        }
        BTN a = new BTN(value);
        if (curr.data > value) {
            curr.left = a;
            a.parent = curr;
        }
        else {
            curr.right = a;
            a.parent = curr;
        }
        return true;
    };

    public BTN searchNode(int x) {
        BTN temp = root;
        while (temp != null) {
            if (temp.data < x) temp = temp.right;
            else if (temp.data >x) temp = temp.left;
            else return temp;
        }
        return null;
    };



}