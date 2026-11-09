
package lw04.unguided;

import java.util.Scanner;

public class Main {

    public static void sortCards(int[] cards, int passes) {
        for (int i = 0; i < passes; i++) {
            int min = i;

            for (int j = i + 1; j < cards.length; j++) {
                if (cards[j] < cards[min]) {
                    min = j;
                }
            }

            int temp = cards[i];
            cards[i] = cards[min];
            cards[min] = temp;
        }
    }

    public static int findCard(int[] cards, int target) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(
            Main.class.getResourceAsStream("cards.txt")
        );

        int n = sc.nextInt();
        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] requests = new int[m];

        for (int i = 0; i < m; i++) {
            requests[i] = sc.nextInt();
        }

        sc.close();

        sortCards(cards, 2);

        for (int i = 0; i < cards.length; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(cards[i]);
        }
        System.out.println();

        for (int i = 0; i < requests.length; i++) {
            int index = findCard(cards, requests[i]);

            if (index != -1) {
                System.out.println(requests[i] + ": FOUND at index " + index);
            } else {
                System.out.println(requests[i] + ": NOT FOUND");
            }
        }
    }
}
