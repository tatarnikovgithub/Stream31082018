package ru.geekbrains.algjava.lesson4.online.links;

public class Show {
    public static void main(String[] args) {
        RelatedList rl = new RelatedList();
        rl.push("Ivan1",30);
        rl.push("Ivan2",40);
        rl.push("Ivan3",50);
        rl.push("Ivan4",60);
        System.out.println(rl.toString());
        System.out.println(rl.find("Ivan2", 40));
        System.out.println(rl.delete("Ivan3", 50));
        System.out.println(rl.toString());
    }
}
