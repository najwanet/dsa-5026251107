public class ColourPrint extends PrintJob{
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override 
    public int calculateCharge(){
        if (getPages() <= 10) {
            return getPages() * 1500 + 2000;
        } else {
            return (getPages() - 10) * 1000 + 15000 + 2000;
        }
    }
    @Override 
    public String label(){
        return "Colour";
    }
}
