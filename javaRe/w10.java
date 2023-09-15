import java.util.LinkedList;
import java.util.Queue;

public class w10 {
    public static void main(String[] args) {
        Pair[] dup = new Pair[200];
        int index = 0;
        Pair init = new Pair(0,0);
        ArrayQueue<Pair> process = new ArrayQueue<>();
        process.enQueue(init);
        dup[index++] = init; 
        Pair mid = null;
        while (!process.isEmpty()) {
            mid = process.peekFront();
            process.deQueue();
            if (mid.getBuck1Curr() == 2 || mid.getBuck2Curr() == 2) break;
            if (!isDup(dup, mid.empty1())) {
                process.enQueue(mid.empty1());
                dup[index++] = mid.empty1();
                continue;
            }
            if (!isDup(dup, mid.empty2())) {
                process.enQueue(mid.empty2());
                dup[index++] = mid.empty2();
                continue;
            }
            if (!isDup(dup, mid.fill1())) {
                process.enQueue(mid.fill1());
                dup[index++] = mid.fill1();
                continue;
            }
            if (!isDup(dup, mid.fill2())) {
                process.enQueue(mid.fill2());
                dup[index++] = mid.fill2();
                continue;
            }
            if (!isDup(dup, mid.pour12())) {
                process.enQueue(mid.pour12());
                dup[index++] = mid.pour12();
                continue;
            }
            if (!isDup(dup, mid.pour21())) {
                process.enQueue(mid.pour21());
                dup[index++] = mid.pour21();
                continue;
            }
        }
        System.out.println(mid);

    }

    static boolean isDup(Pair[] dup, Pair val) {
        for (int i = 0; i < dup.length; i++) {
            if (!dup[i].equals(val)) return true;

        }
        return false;
    }
}

class Pair {
    private int buck1Lim;
    private int buck2Lim;
    private int buck1Curr, buck2Curr;
    public Pair(int val1, int val2) {
        buck1Curr = val1;
        buck2Curr = val2;
        buck1Lim = 3;
        buck2Lim = 4;
    }
    public int getBuck1Curr() {
        return buck1Curr;
    }
    public int getBuck2Curr() {
        return buck2Curr;
    }
    public Pair empty1() {
        return new Pair(0, buck2Curr);
    }

    public Pair empty2() {
        return new Pair(buck1Curr, 0);
    }

    public Pair fill1() {
        return new Pair(buck1Lim, buck2Curr);
    }

    public Pair fill2() {
        return new Pair(buck1Curr, buck2Lim);
    }

    public Pair pour12() {
        int mid = buck1Curr + buck2Curr - buck2Lim;
        if (mid < 0) {
            return new Pair(0, buck1Curr + buck2Curr);
        }
        return new Pair(mid, buck2Lim);
    }

    public Pair pour21() {
        int mid = buck1Curr + buck2Curr -buck1Lim;
        if (mid < 0) {
            return new Pair(buck1Curr + buck2Curr, 0);
        }
        return new Pair(buck1Lim, mid);
    }

    @Override
    public String toString() {
        return buck1Curr + ":" + buck2Curr;
    }
    public boolean equals(Pair obj) {
        return this.getBuck1Curr() == obj.getBuck1Curr() && this.getBuck2Curr() == obj.getBuck2Curr();
    }

}
