package lw01.unguided;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sd = new Scanner(Main.class.getResourceAsStream("rental.txt"));

        int Rental[] = new Rental[int]();
        while (sd.hasNext()){
            String type = sd.next();
            String id = sd.next();
            int days = sd.nextInt();
            int units = sd.nextInt();

            Rental rentaltype;

            if (type.equals("LAPTOP")){
                rentaltype = new LaptopRental(id, days);
            } else {
                rentaltype = new ProjectorRental(id, days);
            }
            rentals.add(rentaltype);
        }
        for (Rental rentaltype : rentals) {
            System.out.println(rentaltype.summary());
        }
        sd.close();
    }
}
