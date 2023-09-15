public class q3 {
    public static void main(String[] args) {
        
        DailyTask test = new DailyTask();
        test.addTask(new Task("Studying DSA", 10, 2));
        test.addTask(new Task("Programming", 8, 2));
        test.addTask(new Task("Ethical Hacking", 20, 2));
        test.addTask(new Task("Hello DSA", 9, 2));
        System.out.println(test.size);

        System.out.println(test.nextTask(21));

    }
}

class Task {
    String description;
    int startTime;
    int duration;
    public Task(String description, int startTime, int duration) {
        this.description = description;
        this.startTime = startTime;
        this.duration = duration;
    } 

}

class TaskNode {
    public Task data;
    public TaskNode next;
    public TaskNode(Task data) {
        this.data = data;
    }
}

class DailyTask {
    TaskNode root;
    TaskNode tail;
    int size = 0;
    public DailyTask() {
        root = null;
        
    }
    // method 1 complexity = O(1)
    public boolean validateTask(Task task) {
        
        return task.duration + task.startTime <= 24;
    }
    // method 2 complexity = O(n) (n is number of existing task)
    public boolean addTask(Task task) {
        if (!this.validateTask(task)) return false;
        if (root == null) {
            root = tail = new TaskNode(task);
            size++;
            return true;
        }
        TaskNode temp = root;
        int[] first = {temp.data.startTime, temp.data.startTime + temp.data.duration};
        int[] second = {task.startTime, task.startTime + task.duration};

        while (temp != null) {
            if (!isOverlap(first, second)) return false;
            temp = temp.next;
        }
        tail.next = new TaskNode(task);
        tail = tail.next;
        size++;
        return true;
        
    }

    private boolean isOverlap(int[] first, int[] second) {
        if (first[1] <= second[0] || first[0] >= second[1]) return true;
        return false;

    }
    // method 3 complexity: O(n)
    public String nextTask(int time) {
        Task min = null;
        TaskNode temp = root;

        int minVal = 25;
        int tempMin = 0;
        while (temp != null) {
            if (temp.data.startTime >= time) {
                tempMin = temp.data.startTime - time;
                if (tempMin < minVal) {
                    min = temp.data;
                    minVal = tempMin;
                }
            }
            temp = temp.next;
        }


        if (root == null || min == null) return "";
        return min.description;
    }

}
