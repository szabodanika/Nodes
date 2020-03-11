package main;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        TreeNode<Integer> root = new TreeNode<>(50, null, null);
        root.add(root,25);
        root.add(root,15);
        root.add(root,40);
        root.add(root,60);
        root.add(root,75);

        System.out.println(root.toString());
        System.out.println(root.contains(root, 75));
        System.out.println(root.contains(root,45));

//        Node<String> head = new Node("Hetfo", null);
//        head.addTail(head, "Kedd");
//        head.addTail(head, "Szerda");
//        head.addTail(head, "Csutortok");
//        head.addTail(head, "Pentek");
//        head.addTail(head, "Szombat");
//        head.addTail(head, "Vasarnap");
//
//        head.remove(head,"Hetfo");
//        head.remove(head, "Szerda");
//        head.remove(head,"Vasarnap");
//
//        head.printRecursively(head);

//        String[] myArray = new String[]{"Monday", "Monday", "Tuesday", "Tuesday", "Wednesday", "Thursday", "Friday", "Friday", "Saturday", "Sunday"};
//        String result = Arrays.asList(myArray).stream().map(s -> s+="\n").collect(Collectors.joining());
    }

}

