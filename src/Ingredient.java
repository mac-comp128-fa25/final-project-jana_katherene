public class Ingredient {
    private String name;
    //private int value;

    public Ingredient(String name){
        if (name.contains("p")){
            this.name = "spice"; 
        }
        if (name.contains("m")){
            this.name = "meat"; 
        }
        if (name.contains("c")){
            this.name = "sauce"; 
        }
        if (name.contains("v")){
            this.name = "veg"; 
        }
        
    }

    public String getName() { 
        return name; 
    }

    // public int getAmount() { 
    //     return value; 
    // }

}
