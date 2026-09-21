package lw01.unguided;

public class ProjectorRental extends Rental{
    public ProjectorRental(String id, int days){
        super(id, days);
    }
    @Override 
    public int calculateCharge(){
        if (getDays() <= 3){
            return getDays() * 60000 * 2;
        } else {
            return getDays() * 45000 * 2;
        }
    }
    @Override 
    public String label(){
        return "Projector";
    }
}
