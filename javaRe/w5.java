public class w5 {
    public static void main(String[] args) {
        p1 test = new p1();
        test.sort();
    }
    
}

class p1 {
    int[] arr;
    public p1() {
        this.arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000) + 1;
        }

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ":");
        }
    }

    public void sort() {
        int[] freq = new int[1001];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;         
        }
        int curr = freq[0];
        for (int i = 1; i < freq.length; i++) {
            curr += freq[i];
            freq[i] = curr;
        }        
        int[] result = new int[arr.length];
        for (int i= arr.length - 1; i >=0; i--) {
            result[freq[arr[i]]] = arr[i];
            freq[arr[i]]--;
        }
        print(result);
    }
}