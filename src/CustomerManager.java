import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CustomerManager{
    private Map<String, Customer> allCharacters;
    Random random = new Random(); 

    public void constructCustomerMap(){
        allCharacters.put("sample1", new Customer(99, 50));
        allCharacters.put("sample2", new Customer(0, 99));
    }
    
    public Map<String, Customer> getAllCustomers(){
        return allCharacters;
    }

    public Customer getrandomCustomer(){
        Collection<Customer> values = allCharacters.values();
        List<Customer> valueList = new ArrayList<>(values);
        Integer randomNum = random.nextInt(valueList.size());
        Customer randomcustomer = valueList.get(randomNum);
        return randomcustomer;
    }
}