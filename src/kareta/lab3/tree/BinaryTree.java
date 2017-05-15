package kareta.lab3.tree;

import kareta.lab3.student.Student;


//preorder
public class BinaryTree {

    private TreeNode root;

    public boolean addNode(int key, Student student) {
        TreeNode newNode = new TreeNode(key, student);

        if (root == null) {
            root = newNode;
            return true;
        }

        TreeNode focusNode = root;
        TreeNode parent;

        while (true) {
            parent = focusNode;

            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;

                if (focusNode == null) {
                    parent.leftChild = newNode;
                    return true;
                }

            } else if (key > focusNode.key) {
                focusNode = focusNode.rightChild;

                if (focusNode == null) {
                    parent.rightChild = newNode;
                    return true;
                }
            } else if (key == focusNode.key) {
                return false;
            }
        }
    }

    public void preorderTraverseTree() {
        preorderTraverseTree(root);
    }

    private void preorderTraverseTree(TreeNode focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);
        }
    }

    public Student find(int key) {
        TreeNode focusNode = root;

        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            if (focusNode == null) {
                return null;
            }
        }

        return focusNode.getStudent();
    }
}

