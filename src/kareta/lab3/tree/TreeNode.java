package kareta.lab3.tree;


import kareta.lab3.student.Student;

class TreeNode {

    int key;
    private Student student;

    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int key, Student student) {
        this.key = key;
        this.student = student;

    }

    public Student getStudent() {
        return student;
    }

    public String toString() {
        return "Key is " + student.getIdentityCard() + ", " + student.toString();
    }
}
