public class SolvingPuzzle {
    int[][] puzzle;
    public SolvingPuzzle(int[][] data) {
        puzzle = data;
    }
    public int sequentialOrder() {
        int result = 0;
        for (int i = 0; i < puzzle.length-1; i++) {
            result += puzzle[i][i+1];
        }
        return result;
    }
    // O(N*N)
    public int greedyOrder() {
        int result = 0;
        boolean[] solved = new boolean[puzzle.length];
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        queue.enQueue(0);
        int mid;
        int min = -1;
        int minCost = 0;
        while(!queue.isEmpty()) {
            min = -1;
            mid = queue.peekFront();
            queue.deQueue();
            solved[mid] = true;
            for (int i = 0; i < puzzle.length; i++) {
                if (!solved[i] && i != mid) {
                    if (min == -1) {
                        min = i;
                        minCost = puzzle[mid][i];
                    }
                    else {
                        if (minCost > puzzle[mid][i]) {
                            min = i;
                            minCost = puzzle[mid][i];
                        }
                    }
                }
            }
            if (min != -1) {
                queue.enQueue(min);
                result += minCost;    
            }
        }
        return result;
    }
    public int optimalOrder() {
        int result = 0;
        boolean[] solved = new boolean[puzzle.length];
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        queue.enQueue(0);

        while (!queue.isEmpty()) {

        }
        return result;
    }
    public static void main(String[] args) {
        int[][] data = {
            {0,1,5},
            {11,0,9},
            {6,3,0}
        };
        SolvingPuzzle test = new SolvingPuzzle(data);
        System.out.println(test.sequentialOrder());
        System.out.println(test.greedyOrder());
    }
    
}
class ArrayQueue<T> {
    private int size;
    private int front, rear;
  
    // I set a small value to test
    // you should replace 10 with a larger value when you use this ADT
    private static int MAX_SIZE = 10;
    private T[] items;
  
    public ArrayQueue() {
      size = 0;
      front = rear = 0;
      items = (T[])new Object[MAX_SIZE];
    }
  
    public int size() {
      return size;
    }
  
    public boolean isEmpty() {
      return size == 0;
    }
  
    public boolean enQueue(T item) {
      // make sure the queue still have empty slot
      if (size < MAX_SIZE) {
        items[rear] = item;
        rear = (rear + 1) % MAX_SIZE;
        size++;
        return true;
      }
      return false;
    }
  
    public boolean deQueue() {
      // make sure the queue is not empty
      if (isEmpty()) {
        return false;
      }
      front = (front + 1) % MAX_SIZE;
      size--;
      return true;
    }
  
    public T peekFront() {
      // make sure the queue is not empty
      if (isEmpty()) {
        return null;
      }
      return items[front];
    }
  
    
  }
