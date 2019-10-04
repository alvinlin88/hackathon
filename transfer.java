import java.util.ArrayList;

public class Transfer extends Account {

    private ArrayList<Account> list = new ArrayList<>();

    public Transfer(double balance, String username, String name, int x, int y) {
        super(balance, username, name, x, y);
    }


    public void addToList(){
        list.add(new Account(1000, "username1", "test1", 50, 50));
        list.add(new Account(2000, "username2", "test2", 47, 49));

    }

    public double getBalance(int index){
        return list.get(index).balance;
    }

    public int calculateDistance(int x1, int y1, int x2, int y2){
        double deltaX = Math.pow((x1-x2), 2);
        double deltaY = Math.pow((y1-y2), 2);
        int distance = (int)Math.sqrt(deltaX + deltaY);
        //System.out.print("Distance is: " + distance);
        return distance;
    }

    public void printDistance(int i, int j){
        System.out.println(calculateDistance(list.get(i).getX(), list.get(i).getY(), list.get(j).getX(), list.get(j).getY()));
    }

    public void transferMoney(String user1, String user2, double amount){


        if(list.get(searchUser((user1))).getBalance() >= amount){
            list.get(searchUser(user1)).subtractBalance(amount);
            list.get(searchUser(user2)).addBalance(amount);

            System.out.println("Your transfer of $" + amount + " to " + list.get(searchUser(user2)).getName() + " has been successfully completed");
            print(searchUser(user1));
        }
        else{
            System.out.println("Transfer unsuccessful. Not enough funds");
        }

    }

    public void transferMoneyByDistance(String user1, String user2, double amount, int distance){

        if(list.get(searchUser((user1))).getBalance() >= amount && calculateDistance(list.get(searchUser(user1)).getX(),list.get(searchUser(user1)).getY(),
                list.get(searchUser(user2)).getX(), list.get(searchUser(user2)).getY()) <= distance){
            list.get(searchUser(user1)).subtractBalance(amount);
            list.get(searchUser(user2)).addBalance(amount);

            System.out.println("Your Close Distance Transfer of $" + amount + " to " + list.get(searchUser(user2)).getName() + " has been successfully completed");
            print(searchUser(user1));
        }
        else{
            if(list.get(searchUser((user1))).getBalance() >= amount){
                System.out.println("Transfer unsuccessful. Not enough funds");
            }

                System.out.println("Transfer unsuccessful. Distance too Far");
        }


    }


    public int searchUser(String user){
        int index = -1;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).username.equals(user)){
                index = i;
            }
        }

        return index;
    }

    public void print(int i){
        System.out.println("Your current balance is " + getBalance(i));
    }

    public static void main(String args[]){
        Transfer test = new Transfer(1, "username3", "test3", 0, 0);
        test.addToList();

        test.transferMoney("username1", "username2", 500);

        test.transferMoneyByDistance("username1", "username2", 500, 5);
     //   test.transferMoney("username1", "username2", 1000);

        test.printDistance(0, 1);
        //test.print(0);
    }

}
