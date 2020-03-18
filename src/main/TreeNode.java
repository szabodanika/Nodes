package main;

public class TreeNode<T extends Comparable> {
    private T value;
    private TreeNode<T> left, right;

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode<T> remove(TreeNode<T> root, T value){
        // ha root null akkor return null
        if(root == null) return null;
        // ha a keresett ertek kisebb mint a root erteke, akkor meghivjuk a fuggvenyt a root.leften
        if(root.value.compareTo(value) == 1) root.left = remove(root.left, value);
        // ha a keresett ertek nagyobb mint a root erteke, akkor meghivjuk a fuggvenyt a root.righton
        else if(root.value.compareTo(value) == -1) root.right = remove(root.right, value);
        // ha a root erteke egyenlo a keresett ertekkel
        else {
            //ha a root az nem level es mindket oldalon van gyerek
            if(root.left != null && root.right != null) {
                //megkeressuk jobb oldalt a legkisebb elemet
                TreeNode<T> rightSmallest = findSmallest(root.right);
                //a root erteket beallitjuk a jobb oldali legkisebb elem ertekere
                root.value = rightSmallest.value;
                //a root jobb oldalan kitoroljuk a legkisebb erteket
                root.right = remove(root.right, rightSmallest.value);
            }
            // ha a rootnak csak baloldalt van gyereke
            else if(root.left != null) root = root.left;
            // ha a rootnak csak jobboldalt van gyereke
            else if(root.right != null) root = root.right;
            // ha a root az egy level
            else root = null;
        }
        //visszaadjuk a rootot
        return root;
    }

    public boolean isLeaf(TreeNode<T> node){
        return node.left == null && node.right == null;
    }

    public TreeNode<T> removeSmallest(TreeNode<T> root){
        if(root == null) return null;
        if (root.left == null)
            return root;
        else {
            return findSmallest(root.left);
        }
    }

    public TreeNode<T> findSmallest(TreeNode<T> root){
        if(root == null) return null;
        if (root.left == null)
            return root;
        else {
            return findSmallest(root.left);
        }
    }

    public TreeNode<T> findLargest(TreeNode<T> root){
        if(root == null) return null;
        if (root.right == null)
            return root;
        else {
            return findSmallest(root.right);
        }
    }

    public void printPreOrder(TreeNode<T> root){
        if(root == null) return;
        System.out.print(root.value + " "); // root
        printPreOrder(root.left); // left
        printPreOrder(root.right); // right
    }

    public void printInOrder(TreeNode<T> root){
        if(root == null) return;
        printInOrder(root.left); // left
        System.out.print(root.value + " "); // root
        printInOrder(root.right); // right
    }

    public void printPostOrder(TreeNode<T> root){
        if(root == null) return;
        printPostOrder(root.left); // left
        printPostOrder(root.right); // right
        System.out.print(root.value + " "); // root
    }

    @Override
    public String toString() {
        return " [value=" + value + //root
                " left=" + left + //left
                " right=" + right + "] "; //right
    }

    public boolean contains(TreeNode<T> root, T value){
        if(root == null) return false;
        else if(root.value == value) return true;
        return contains(root.left, value) || contains(root.right, value);
    }

    public void add(TreeNode<T> root, T value){
        if(root.value.compareTo(value) == 0){
            return;
        } else if(root.value.compareTo(value) == 1){
            if(root.left == null){
                root.left = new TreeNode<>(value, null, null);
            } else {
                add(root.left, value);
            }
        } else if(root.value.compareTo(value) == -1){
            if(root.right == null){
                root.right = new TreeNode<>(value, null, null);
            } else {
                add(root.right, value);
            }
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
