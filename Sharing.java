import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Sharing{
    public static void main(String[] args) {
        Map<String, Integer>balances = new HashMap<>();
        List<Bill> bills = new ArrayList<>();

        bills.add(new Bill("Lunch",2000,"joe",Arrays.asList("joe","candy","john", "amul")));
        bills.add(new Bill("Movie ticket", 1000, "john",Arrays.asList("joe","candy","john", "amul")));
        bills.add(new Bill("Snacks", 500, "candy", Arrays.asList("joe","candy","john", "amul")));

        for(Bill bill:bills){
            String paidBy = bill.getPaidBy();
            int tAmt = bill.getTAmt();
            List<String> sharedBy = bill.getSharedBy();
            int sharePerPersion = tAmt/sharedBy.size();

            if(!balances.containsKey(paidBy)){
                balances.put(paidBy,tAmt);
            }else{
                balances.put(paidBy, balances.get(paidBy)+tAmt);
            }
           
            for(String person : sharedBy){
                if(!person.equals(paidBy)){
                    if(!balances.containsKey(person)){
                        balances.put(person, -sharePerPersion);
                    }else{
                        balances.put(person, balances.get(person)-sharePerPersion);
                    }
                }
            }
        }

        for(Map.Entry<String,Integer> entry: balances.entrySet()){
            String person = entry.getKey();
            int balance = entry.getValue();

            System.out.println(person + " owns "+(-balance)+" to others");
        }

    }
}


class Bill{
    private List<String> sharedBy;
    private String desc;
    private int tAmt;
    private String paidBy;


    public Bill(String desc, int tAmt, String paidBy, List<String> sharedBy){
        this.desc = desc;
        this.tAmt = tAmt;
        this.paidBy = paidBy;
        this.sharedBy = sharedBy;
    }

    public String getDesc(){
        return this.desc;
    }
    public int getTAmt(){
        return this.tAmt;
    }
    public String getPaidBy(){
        return this.paidBy;
    }
    public List<String> getSharedBy(){
        return this.sharedBy;
    }


    
    
}
