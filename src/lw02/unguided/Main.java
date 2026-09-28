package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
         Scanner sg = new Scanner (Main.class.getResourceAsStream("borrowing.txt"));
         
         LinkedList<String[]> requests = new LinkedList<>();
         LinkedList<String[]> bRecords = new LinkedList<>();
         LinkedList<String[]> mRecords = new LinkedList<>();
         while (sg.hasNextLine()) {

            String name = sg.next();
            String title = sg.next();

            requests.add(new String[]{
                name,
                title
            });
        }
        sg.close();

        for (String[] request : requests) {
            String name = request[0];
            boolean exist = false;

        for (String[] member : mRecords) {
            if (member[0].equals(name)) {
                exist = true;
                break;
            }
        }
           if (!exist) {
                mRecords.add(new String[]{
                    name,"0"
                });
            }
        }
        for (String[] request : requests) {
            String title = request[1];
            boolean exist = false;
            
            for (String[] book : bRecords) {
                if (book[1].equals(title)) {
                exist = true;
                break;
            }
        }
           if (!exist) {
            if (title.equals("Kalkulus")) {
                bRecords.add(new String[]{
                    title,"2"
                });
            } else if (title.equals("Fisika")) {
                bRecords.add(new String[]{
                    title,"1"
                }); 
            } else if (title.equals("Statistika")) {
                bRecords.add(new String[]{
                    title,"2"
                }); 
            }
        }
     }
        Queue<String[]> queue = new LinkedList<>();
        queue.addAll(requests);

        Stack<String[]> failed = new Stack<>();
        while (!queue.isEmpty()) {
            String[] request = queue.poll();
            String [] book = queue.poll();
            String name = request[0];
            String title = request[1];
            int stock = Integer.parseInt(book[1]);

           for (String[] member : mRecords) {

                if (member[0].equals(name)) {

                    int limit = 2;

                    int borrow = Integer.parseInt(member[1]);
                    borrow++;

                    if (borrow <= limit){
                        member[1] = String.valueOf(borrow);
                    }

                    if (title.equals("Kalkulus")) {
                        if (borrow <= limit){
                            if (stock > 0) {
                                member[1] = String.valueOf(borrow);
                                stock --;
                            }
                        } else {
                            failed.push(request);
                        }
                    }

                    break;
                }
            }
        }
        System.out.println("=== Successfully Processed Requests ===");

        for (String[] request : requests) {
            System.out.println(request[0] + request[1]);
        }

        System.out.println();
        System.out.println("=== Remaining Book Stock ===");
            for (String[] book : bRecords) {
            System.out.println(book[0] + " : " + book[1]);
        }

        System.out.println();
        System.out.println("=== Failed Requests ===");
        while (!failed.isEmpty()) {

            String[] request = failed.pop();

            System.out.println(
                request[0] + " "
                + request[1]
            );
        }
    }
}
