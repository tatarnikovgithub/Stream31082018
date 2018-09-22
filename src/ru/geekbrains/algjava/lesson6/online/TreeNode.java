package ru.geekbrains.algjava.lesson6.online;

public class TreeNode {
    Person person;

    public TreeNode left;
    public TreeNode right;

    public TreeNode(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return String.format("ID: %d; Name: %s; Age: %d",
                person.uid, person.name, person.age);
    }
}
