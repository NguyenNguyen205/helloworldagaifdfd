public class q2 {
    public static void main(String[] args) {
        Student s1 = new Student(1, "A", 70.0);  // the first parameter is student id
        Student s2 = new Student(2, "B", 65.0);
        Student s3 = new Student(3, "C", 80.0);
        Student s4 = new Student(4, "D", 78.0);
        Student s5 = new Student(5, "E", 68.0);
        StudentBST test = new StudentBST();
        test.addStudent(s1);
        test.addStudent(s2);
        test.addStudent(s3);
        test.addStudent(s4);
        test.addStudent(s5);
        System.out.println(test.nextStudentEasy(s4));
    }
    
}

class Student {
    public int id;
    public String name;
    public double GPA;
    public Student left, right, parent;
    public Student(int id, String name, double GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }
    @Override
    public String toString() {
        return id + ":" + name + ":" + GPA;
    }
}

class StudentBST {
    public Student root;
    public int count;
    public StudentBST() {
        root = null;
        count = 0;
    }
    
    // addStudent complexity: O(log(N))
    public void addStudent(Student student) {
        if (root == null) {
            root = student;
            return;
        }
        Student pre = null;
        Student cur = root;
        while (cur != null) {
            if (cur.GPA < student.GPA) {
                pre = cur;
                cur = cur.right;
            }
            else if (cur.GPA > student.GPA) {
                pre = cur;
                cur = cur.left;
            }
            else return;
        }
        if (pre.GPA < student.GPA) {
            pre.right = student;
            student.parent = pre;
        }
        else {
            pre.left = student;
            student.parent = pre;
        }
        count++;
        return;
    }
    // method 2 complexity: O(log(N))
    public Student nextStudentEasy(Student student) {
        if (root == null) return null;
        Student temp = root;
        Student res = null;
        while (temp != null) {
            if (student.GPA > temp.GPA) {
                temp = temp.right;
            }
            else if (student.GPA < temp.GPA) {
                if (res != null) {
                    res = temp.GPA > res.GPA ? res : temp; 
                }
                else res = temp;
                temp = temp.left;
            }
            else {
                temp = temp.right;
            }
        }
        return res;
    }
    // method 3 complexity: O(log(N))
    public Student nextStudentGeneral(Student student) {
        if (root == null) return null;
        Student temp = root;
        Student res = null;
        while (temp != null) {
            if (student.GPA > temp.GPA) {
                temp = temp.right;
            }
            else if (student.GPA < temp.GPA) {
                if (res != null) {
                    res = temp.GPA > res.GPA ? res : temp; 
                }
                else res = temp;
                temp = temp.left;
            }
            else {
                temp = temp.right;
            }
        }
        return res;
        
    }
}
