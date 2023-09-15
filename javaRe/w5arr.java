import java.util.Hashtable;

public class w5arr {
    public static void main(String[] args) {
        // RMITStudentCollection test = new RMITStudentCollection();
        double init = Math.pow(0.75, 16);
        double total = 0;
        double[] nums = new double[17];
        for (int i = 0; i < 17; i++) {
            total += init * (factorial(16)/ (factorial(i) * factorial(16-i)));
            nums[i] = init * (factorial(16)/ (factorial(i) * factorial(16-i)));
            System.out.printf("%s %.20f \n", i, init * (factorial(16)/ (factorial(i) * factorial(16-i))));
            
            init = init / 0.75;
            init *= 0.25;
            
        }
        System.out.println("Hello world");
        double remain = 0;
        for (int i = 0; i < 17; i ++) {
            System.out.printf("%s %.10f \n", i, nums[i] * nums[i]);
            remain += nums[i] * nums[i];
        }
        System.out.println(remain);
        



    }

    static long factorial(int n) {
        if (n <= 1) return 1;
        long result = n;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        return result;
    }


}

class RMITStudent {

    String studentId;
    String fullName;
    String major;  
    double GPA;
  }

class Node {
    public RMITStudent val;
    public Node next;
    public Node(RMITStudent val) {
        this.val = val;
    }
}

class RMITStudentCollection {
    int hashSize = 13;
    Node[] hashTable;
    public RMITStudentCollection() {
        hashTable = new Node[hashSize];
    }
    public boolean put(RMITStudent s) {
        int pos = hashing(s.studentId);
        if (hashTable[pos] == null) {
            hashTable[pos] = new Node(s);
            return true;
        }
        Node temp = hashTable[pos];
        while (temp.next != null) {
            if (temp.val.studentId.equals(s.studentId)) return false;
            temp = temp.next;
        }
        if (temp.val.studentId.equals(s.studentId)) return false;
        temp.next = new Node(s);
        return true;


    }
    public RMITStudent get(String studentId) {
        int pos = hashing(studentId);
        if (hashTable[pos] == null) return null;
        Node temp = hashTable[pos];
        while (temp != null) {
            if (temp.val.studentId.equals(studentId)) return temp.val;
        }
        return null;
    }


    private int h(char mid) {
        if ('A' > mid) {
            return mid - '0' + 26;
        }
        return mid - 'A';
    }

    private int hashing(String word) {
        int total = 0;
        for (int i = 0; i < word.length(); i++) {
            total += h(word.charAt(i));
        }
        return total % hashSize;
    }
}

