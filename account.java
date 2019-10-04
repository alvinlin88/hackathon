public class Account {
    double balance;
    String username;
    String name;
    int x;
    int y;

    public Account(double balance, String username, String name, int x, int y){
        this.balance = balance;
        this.username = username;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void addBalance(double amount){
        this.balance += amount;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void subtractBalance(double amount){
        this.balance -= amount;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public String getName(){
        return this.name;
    }

    public double getBalance(){
        return this.balance;
    }




}