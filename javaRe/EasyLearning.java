public class EasyLearning {
    private int[][] courses;
    public EasyLearning(int[][] course) {
        this.courses = course;
    }
    public int directSequence() {
        return courses[0][courses.length-1];
    }
    public int compare(int[] seq1, int[] seq2) {
        int res1 = 0;
        int res2 = 0;
        for (int i = 1; i < seq1.length; i++) {
            res1 += courses[seq1[i-1]][seq1[i]];
        }
        for (int i = 1; i < seq2.length; i++) {
            res2 += courses[seq2[i-1]][seq2[i]];
        }
        if (res1 == res2) return 0;
        return res1 > res2 ? 1: -1;
    }
    // private int countCost(int[] seq) {
    //     int res = 0;
    //     for (int i = 1; i < seq.length; i++) {
    //         res += courses[seq[i-1]][seq[1]];
    //     }
    //     return res;
    // }
    public int bestSequence() {
        int result = 0;
        result = shortestPath(courses, 0, courses.length - 1);
        return result;
     
    }
    private int shortestPath(int[][] nodes, int src, int dest) {
        int n = nodes.length;
        
        int[] distances = new int[n];  // distance[i] stores the minimum distance from src to i
        boolean[] visited = new boolean[n];  // visited state
        int[] previous = new int[n];  // used to construct the shortest path; previous[i] stores the node that is visited before i
    
        // initialization
        for (int i = 0; i < n; i++) {
          distances[i] = Integer.MAX_VALUE;
          previous[i] = -1;
        }
        distances[src] = 0;  // zero distance from the src to itself
    
        while (true) {
          // Greedy choice: retrieve the shortest-distance node from
          // unvisited nodes
          int shortest = Integer.MAX_VALUE;
          int shortestNode = -1;
          for (int i = 0; i < n; i++) {
            if (visited[i]) {
              continue;
            }
            if (shortest > distances[i]) {
              shortest = distances[i];
              shortestNode = i;
            }
          }
    
          // update the shortest distance through shortest node
          // to all unvisited nodes
          for (int i = 0; i < n; i++) {
            if (visited[i]) {
              continue;
            }
            // shortestNode and i are connected?
            if (nodes[shortestNode][i] > 0) {
              // current distance to i > distance reached through shortestNode
              if (distances[i] > distances[shortestNode] + nodes[shortestNode][i]) {
                distances[i] = distances[shortestNode] + nodes[shortestNode][i];
                previous[i] = shortestNode;
              }
            }
          }
          
          if (shortestNode == dest) {
            // we reach the destination
            // display the shortest path
            String path = shortestNode + "";
            while (previous[shortestNode] != -1) {
              shortestNode = previous[shortestNode];
              path = shortestNode + " " + path;
            }
    
            System.out.println("Shortest path: " + path);
            return distances[dest];
          }
    
          // even shortest is INFINITY => stop
          if (shortest == Integer.MAX_VALUE) {
            // we cannot go further
            return Integer.MAX_VALUE;
          }
          // continue the next round
          visited[shortestNode] = true;
        }
      }

    public static void main(String[] args) {
        int[][] course = {
            {0,1,5},
            {4,0,3},
            {2,1,0}
        };
        EasyLearning test = new EasyLearning(course);
        System.out.println(test.directSequence());
        int[] first = {0,2};
        int[] second = {0,1,2};
        System.out.println(test.compare(first, second));
        System.out.println(test.bestSequence());
    }
}
