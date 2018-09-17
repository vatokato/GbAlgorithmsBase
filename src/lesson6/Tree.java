package lesson6;

import lesson4.Cat;

public class Tree {
    private class TreeNode {
        private Cat c;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(Cat c) {
            this.c = c;
        }
        @Override
        public String toString() {
            return String.format("(ID:%d, N:%s, A:%d (%d<-*->%d)", c.getId(), c.getName(), c.getAge(), this.left != null ? this.left.c.getId() : 0, this.right!=null?this.right.c.getId():0);
        }
    }

    TreeNode root;
    int tmp_levels;
    boolean is_balanced;

    public Cat find(int age) {
        TreeNode current = root;
        while (current.c.getAge() != age) {
            if (age < current.c.getAge())
                current = current.left;
            else
                current = current.right;

            if (current == null)
                return null;
        }
        return current.c;
    }

    public void insert(Cat c) {
        TreeNode node = new TreeNode(c);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode previous;
            while (true) {
                previous = current;
                if (c.getAge() < current.c.getAge()) {
                    current = current.left;
                    if (current == null) {
                        previous.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        previous.right = node;
                        return;
                    }
                }
            }
        }
    }

    public void displayTree() {
        inOrderTravers(root, 0);
    }

    private void inOrderTravers(TreeNode current, int level) {
        if (current != null) {
            inOrderTravers(current.left, level+1);
            System.out.println(level+" level: "+current);
            inOrderTravers(current.right, level+1);
        }
    }

    public void isBalanced() {
        if (root == null) return;
        this.tmp_levels=0;
        countOfLevels(root.left, 1);
        int left_levels=this.tmp_levels ;
        this.tmp_levels=0;
        countOfLevels(root.right, 1);
        int right_levels=this.tmp_levels ;
        System.out.println("<-"+left_levels + "*"+ right_levels+"->");

        if(Math.abs(left_levels-right_levels)>1) {
            is_balanced = false;
            System.out.println("Дерево не сбалансированно");
        }
        else {
            is_balanced = true;
            System.out.println("Дерево сбалансированно");
        }
    }

    private void countOfLevels(TreeNode current, int level) {
        if(current==null) return;
        countOfLevels(current.left, level+1);
        this.tmp_levels =  level > this.tmp_levels ? level : this.tmp_levels;
        countOfLevels(current.right, level+1);
    }

    public boolean delete(int age) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.c.getAge() != age) {
            parent = current;
            if (age < current.c.getAge()) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null)
                return false;
        }

        //if node is a leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // if one successor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        }
        else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // if both successors exist
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;

            successor.left = current.left;
            successor.right = current.right;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode current = node.right;
        TreeNode s = node;
        TreeNode parent = node;
        while (current != null) {
            parent = s;
            s = current;
            current = current.left;
        }
        if (s != node.right) {
            parent.left = s.right;
        }
        return s;
    }
}
