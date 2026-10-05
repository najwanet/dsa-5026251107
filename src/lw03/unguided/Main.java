package lw03.unguided;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sw = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        Map<String, Integer> courses = new LinkedHashMap<>();
        System.out.println("===== Enrollment Checks =====");
        int failedTake1 = 0;
        int failedTake2 = 0;
        int failedTake3 = 0;

        while (sw.hasNext()) {
            String type = sw.next(); 
            String course = sw.next();

            if (type.equals("REGISTER")) {
                if (courses.containsKey(course)) {
                    int quantity = sw.nextInt();
                    if (quantity == 0) {
                        failedTake1++;
                    } else {
                        int oldCourses = courses.get(course);
                        courses.put(course, oldCourses + quantity);                     
                    }
                } else {
                    int quantity = sw.nextInt();
                    if (quantity == 0) {
                        failedTake1++;
                    } else {
                        courses.put(course, quantity);                     
                    }
                }
            }

            if (type.equals("WITHDRAW")) {
                if (courses.containsKey(course)) {
                    int quantity = sw.nextInt();                  
                    int oldCourse = courses.get(course);
                    if (oldCourse >= quantity) {
                        courses.put(course, oldCourse - quantity);
                    } else {
                        failedTake2++;
                    }
                } else {
                    failedTake2++;
                }
            } 
            
            if (type.equals("CHECK")) {
                if (courses.containsKey(course)) {
                    System.out.println(course + ": " + courses.get(course));
                } else {
                    failedTake3++;
                    System.out.println(course + ": Not found");
                }
            }
        }

        sw.close();

        System.out.println("");
        System.out.println("===== Final Enrollment =====");
        for (String course : courses.keySet()) {
        System.out.println(course + ": " + courses.get(course));
        }

        System.out.println("");
        int failedTake = failedTake1 + failedTake2 + failedTake3;
        System.out.println("Rejected operations: " + failedTake);
    }
}

