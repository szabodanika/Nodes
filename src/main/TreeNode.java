package main;

public class TreeNode<T extends Comparable> {
    private T value;
    private TreeNode<T> left, right;

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return " [value=" + value +
                " left=" + left +
                " right=" + right + "] ";
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
