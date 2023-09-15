public class q1 {
    public static void main(String[] args) {
        EscapeRoom test = new EscapeRoom();
        test.enterRoom("A");
        test.enterRoom("B");
        System.out.println(test.exitRoom());
        System.out.println(test.exitRoom());
        String[] a = {"A", "B", "C"};
        String[] b = {"E", "C"};
        System.out.println(test.minOperations(a, b));

    }
    
}

class EscapeRoom {
    private static int MAX_SIZE = 10000;
    private int size;
    private String[] rooms;
    public EscapeRoom() {
        size = 0;
        rooms = new String[MAX_SIZE];
    }
    // time complexity = O(1)
    public void enterRoom(String room) {
        if (size >= MAX_SIZE) return;
        rooms[size] = room;
        size++;
    }
    // time complexity = O(1)
    public String exitRoom() {
        if (size == 0) return null;
        size--;
        return rooms[size];
    }
    // time complexity = O(MAX(A,B)) where A is the number of target elements, B is the number of enteredRooms element
    public int minOperations(String[] target, String[] enteredRooms) {
        int res = 0;
        int tSize = target.length;
        int eSize = enteredRooms.length;
        int first, second;
        first = second = 0;
        while (first < tSize && second < eSize) {
            if (target[first].equals(enteredRooms[second])) {
                first++;
                second++;
                continue;
            }
            else {
                res += eSize - second;
                res += tSize - first;
                return res;
            }

        }
        if (first == tSize && second != eSize) {
            res += eSize - second;
        }
        else if (first != tSize && second == eSize) {
            res += tSize - first;
        }
        return res;
    }

}