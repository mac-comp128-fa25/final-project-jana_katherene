public class Customer {
    int satisfaction;
    int willingnessToTip;
    int pickiness; 

    public Customer(int willingnessToTip, int pickiness){
        this.willingnessToTip = willingnessToTip;
        this.pickiness = pickiness;
    }
    public int getSatisfaction(){
        return satisfaction;
    }
    public void setSatisfaction(int satisfaction){
        this.satisfaction = satisfaction;
    }
    



}
