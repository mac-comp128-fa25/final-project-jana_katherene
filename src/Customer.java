public class Customer {
    int satisfaction;
    int willingnessToTip;
    int pickiness; 
    String name;

    public Customer(int willingnessToTip, int pickiness, String name){
        this.willingnessToTip = willingnessToTip;
        this.pickiness = pickiness;
        this.name = name;
    }
    public int getSatisfaction(){
        return satisfaction;
    }
    public void setSatisfaction(int satisfaction){
        this.satisfaction = satisfaction;
    }
    
    public String getName(){
        return name;
    }
    



}
