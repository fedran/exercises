package org.fedran.olympiad;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Deque;

/**
 * Имеется некий чат-сервер, куда каждую секунду заходит пользователь.
 * У каждого пользователя может быть открыто только 4 подключения.
 * Как только открывается 5-ое подключение, 1ое подключение закрывается.
 * В первой строке содержится целое положительное число n (1 ≤ n ≤ 1000) —
 * количество секунд работы чат-сервера.  В следующих n строках содержится
 * информация о подключающихся пользователей. Каждая строка начинается с
 * символа '+'.
 * Далее следует имя пользователя, который подключается к серверу.
 * Длина имени ненулевая и не превышает 10 и состоит из строчных латинских символов.
 * Нумерация секунд начинается с единицы.
 * Вывести время подключения пользователей, соединение с которыми было разорвано.
 */
public class DisconnectServer {

    public static void main(String[] args) {
        HashMap<String, Deque<Integer>> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= a; i++) {
            String name = scanner.nextLine().trim();
            if (!hashMap.containsKey(name)) {
                Deque<Integer> deque = new ArrayDeque<>();
                deque.addLast(i);
                hashMap.put(name, deque);
            } else {
                Deque<Integer> deque = hashMap.get(name);
                deque.addLast(i);
                if (deque.size() > 4) {
                    System.out.println("Disconnected " + deque.pollFirst());
                }
            }
        }
    }
}
