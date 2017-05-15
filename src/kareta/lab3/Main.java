package kareta.lab3;

import kareta.lab3.student.Student;
import kareta.lab3.tree.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by vitya on 05.02.17.
 */
//logically togather = physically togather hmi
//Хранить ссылку только на детей без парента
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        HashMap<String, ArrayList<Integer>> academicResults = new HashMap<>();
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(2);
        marks.add(3);
        marks.add(4);
        marks.add(5);
        academicResults.put("Math", marks);

        Student vasya1 = new Student("Vasya1", "Ukraine", (byte)1, 75, academicResults);
        tree.addNode(vasya1.getIdentityCard(), vasya1);
        Student vasya2 = new Student("Vasya2", "Ukraine", (byte)2, 123, academicResults);
        tree.addNode(vasya2.getIdentityCard(), vasya2);
        Student vasya3 = new Student("Vasya3", "Ukraine", (byte)1, 1, academicResults);
        tree.addNode(vasya3.getIdentityCard(), vasya3);
        Student vasya4 = new Student("Vasya4", "Ukraine", (byte)5, 2, academicResults);
        tree.addNode(vasya4.getIdentityCard(), vasya4);
        Student vasya5 = new Student("Vasya5", "Ukraine", (byte)1, 11, academicResults);
        tree.addNode(vasya5.getIdentityCard(), vasya5);
        Student vasya6 = new Student("Vasya6", "Ukraine", (byte)7, 45, academicResults);
        tree.addNode(vasya6.getIdentityCard(), vasya6);
        Student vasya7 = new Student("Vasya7", "Ukraine", (byte)1, 65, academicResults);
        tree.addNode(vasya7.getIdentityCard(), vasya7);

        tree.preorderTraverseTree();
        System.out.println("\nNode with the key 45");
        System.out.println(tree.find(45));
    }
}
