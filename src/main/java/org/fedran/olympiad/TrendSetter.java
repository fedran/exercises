package org.fedran.olympiad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Имеется некая социальная сеть, в которой существуют трендсеттеры и пользователи.
 * Гарантируется, что любая пара пользователей либо дружит непосредственно,
 * либо существует цепочка пользователей, их соединяющая, в которой
 * два последовательных человека дружат непосредственно
 * (то есть граф дружбы социальной сети — связный).
 * <p>
 * В первой строке входного файла задано целое число n (1 ≤ n ≤ 50000) —
 * количество трендсеттеров. В следующих n строках заданы имена трендсеттеров.
 * В i-й строке содержится имя i-го трендсеттера, все имена различны.
 * Имя состоит только из строчных латинских букв и имеет длину не более 6 символов.
 * Далее в отдельной строке задано целое число m (1 ≤ m ≤ 50000) —
 * количество пар людей в социальной сети, которые дружат непосредственно.
 * В следующих m строках заданы пары людей, которые дружат непосредственно.
 * В j-й строке содержатся два имени, разделенные единичным пробелом —
 * name1j и name2j. Имена также состоят из строчных латинских букв и
 * имеют длины не более 6 символов.
 * Каждая пара имен встречается не более одного раза.
 * <p>
 * Выведите единственное целое число — через сколько минут опубликованную
 * новость узнают все пользователи социальной сети.
 */

public class TrendSetter {
    public static void main(String[] args) {
        HashMap<String, Node> roots = new HashMap<>();
        HashMap<String, Node> leafs = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < a; i++) {
            ArrayList<Node> nodeArrayList = new ArrayList<>();
            String s = scanner.nextLine();
            Node node = new Node(s, 0, nodeArrayList);
            roots.put(s, node);
        }

        int b = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < b; i++) {
            String[] s = scanner.nextLine().trim().split(" ");
            String s1 = s[0];
            String s2 = s[1];
            Node link1;
            Node link2;
            if (roots.containsKey(s1)) {
                link1 = roots.get(s1);
            } else if (leafs.containsKey(s1)) {
                link1 = leafs.get(s1);
            } else {
                ArrayList<Node> nodeArrayList = new ArrayList<>();
                link1 = new Node(s1, Integer.MAX_VALUE, nodeArrayList);
                leafs.put(s1, link1);
            }
            if (roots.containsKey(s2)) {
                link2 = roots.get(s2);
            } else if (leafs.containsKey(s2)) {
                link2 = leafs.get(s2);
            } else {
                ArrayList<Node> nodeArrayList = new ArrayList<>();
                link2 = new Node(s2, Integer.MAX_VALUE, nodeArrayList);
                leafs.put(s2, link2);
            }
            link1.nodeArrayList.add(link2);
            link2.nodeArrayList.add(link1);
        }
        roots.values().forEach(x -> detour(x, 0));

        System.out.println(leafs.values().stream()
                .mapToInt(x -> x.weight)
                .max().getAsInt());
    }

    private static void detour(Node node, int i) {
        if (node.weight > i || i == 0) {
            node.weight = i;
            for (Node n : node.nodeArrayList) {
                detour(n, i + 1);
            }
        }
    }

    static class Node {
        String name;
        int weight;
        ArrayList<Node> nodeArrayList;

        public Node(String name, int weight, ArrayList<Node> nodeArrayList) {
            this.name = name;
            this.weight = weight;
            this.nodeArrayList = nodeArrayList;
        }
    }

}
