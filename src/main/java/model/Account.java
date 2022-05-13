package model;

public class Account {
    private int id;
    private  String username;
    private  String password;
    private String accounttype;

    public  Account(int id,String username,String password,String accounttype){
        this.id=id;
        this.username=username;
        this.password=password;
        this.accounttype=accounttype;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    @Override
    public  String toString(){
        String text="";
        text+=id+","+username+","+password+","+accounttype;
        return  text;
    }

    @Override
    public  boolean equals(Object obj){
        Account account=(Account) obj;
        return  account.username==this.username;
    }
}

