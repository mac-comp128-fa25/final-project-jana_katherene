public class Taco{
    int meat;
    int vegetables;
    int sauce;
    int spice;

    public Taco(int meat, int vegetables, int sauce, int spice){
        this.meat = meat;
        this.vegetables = vegetables;
        this.sauce = sauce;
        this.spice = spice;
    }
    
    public int getMeat(){
        return meat;
    }

    public int getVegetables(){
        return vegetables;
    }

    public int getSauce(){
        return sauce;
    }

    public int getSpice(){
        return spice;
    }

    public void addMeat(int addedMeat){
        meat = addedMeat + meat;
    }

    public void addVegetables(int addedVegetables){
        vegetables = addedVegetables + vegetables;
    }
    
    public void addSauce(int addedSauce){
        sauce = addedSauce + sauce;
    }
    
    public void addSpice(int addedSpice){
        spice = addedSpice + spice;
    }
    
}