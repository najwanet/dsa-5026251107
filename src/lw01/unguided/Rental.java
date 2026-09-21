package lw01.unguided;

public abstract class Rental implements Chargeable {
    private String id;
    private int days;

    protected Rental(String id, int days){
        this.id = id;
        this.days = days;
    }

    public String getId(){
        return id;
    }
    public int getDays(){
        return days;
    }
    
    @Override 
    public abstract int calculateCharge();
    public int calculateCharge(int units){
        if (units <= 0){
            throw new IllegalArgumentException();
        }
        return (units * 10000) + calculateCharge();
    }

    public String label(){
        return "Rental";
    }
    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}
