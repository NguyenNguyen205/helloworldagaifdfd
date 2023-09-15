public class DoraemonCake {
    class Topic {
        public int w;
        public int s;
    }
    private int A;
    Topic[] test;
    double largestWeight = 0;
    
    // Time complexity: O(2^N)
    public double largestWeight() {
        Topic[] input = test;
        boolean[] selected = new boolean[input.length];
        subset(input, selected, 0);
        return largestWeight;

    }
    private void subset(Topic[] input, boolean[] selected, int idx) {
        if (idx == input.length) {
          process(input, selected);
          return;
        }
    
        // Not selected
        selected[idx] = false;
        subset(input, selected, idx + 1);
    
        // Selected
        selected[idx] = true;
        subset(input, selected, idx + 1);
      }
    
      private void process(Topic[] set, boolean[] selected) {
        int weight = 0; 
        int surface = 0;
        for (int i = 0; i < set.length; i++) {
          if (selected[i]) {
            surface += set[i].s;
            weight += set[i].w;
          }      
        }
        if (weight > A) return;
        largestWeight = Math.max(largestWeight, weight);
      }
    public void mergeSort(Topic arr[]) {
        if (arr.length > 1) {
          int n = arr.length;
          int middle = n / 2;
    
          // create 2 sub-arrays from arr
          Topic[] sub1 = new Topic[middle];
          for (int i = 0; i < middle; i++) {
            sub1[i] = arr[i];
          }
          Topic[] sub2 = new Topic[n - middle];
          for (int i = middle; i < n; i++) {
            sub2[i - middle] = arr[i];
          }
    
          // sort first and second halves
          mergeSort(sub1);
          mergeSort(sub2);
    
          // merge sub1 and sub2 into the original array
          merge(sub1, sub2, arr);
        }
      }
    
      // merge two sub-arrays sub1 and sub2 into the array dest
      public void merge(Topic[] sub1, Topic[] sub2, Topic[] dest) {
        int p1 = 0, p2 = 0, pDest = 0;  // pointers to 3 arrays
        while (p1 < sub1.length && p2 < sub2.length) {
          if (sub1[p1].w <= sub2[p2].w) {
            dest[pDest] = sub1[p1];
            p1++;
          } else {
            dest[pDest] = sub2[p2];
            p2++;
          }
          pDest++;
        }
    
        // copy remaining elements, if any
        while (p1 < sub1.length) {
          dest[pDest++] = sub1[p1++];
        }
        while (p2 < sub2.length) {
          dest[pDest++] = sub2[p2++];
        }
      }
      public static void main(String[] args) {
        
      }
}
