package repository;

import model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private String JdbURL = "jdbc:mysql://localhost:3306/relationship";
    private String username = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public AccountRepository() {
        try {
            connection = DriverManager.getConnection(JdbURL, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("eroare connectare baza de date");
        }
    }

    private void executeStatement(String execute) {
        try {
            statement.execute(execute);
        } catch (SQLException exc) {
            System.out.println("Nu am reusit" + execute);
        }
    }

    public void insertAccount(Account account) {
        String insertTo = "";
        insertTo += "insert into account(username,password,accounttype)";
        insertTo += "values(";
        insertTo += String.format("'%s','%s','%s'", account.getUsername(), account.getPassword(), account.getAccounttype());
        insertTo += ")";
        executeStatement(insertTo);

    }

    public void stergeAccountById(int id) {
        String text = String.format("delete from account where id=%d", id);
        executeStatement(text);
    }

    public void updatePassword(String username, String password) {
        String update = String.format("update  account set password ='%s' where username='%s'" , password, username);
        executeStatement(update);
    }

    public  void deleteAccount(String username){
        String delete=String.format("delete from account where username='%s'",username);
        executeStatement(delete);
    }

    private ResultSet allAccount(){
        executeStatement("select * from account");
        try{
            return  statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a executat schita");
            return  null;
        }
    }

    public List<Account>allAccounts(){
        ResultSet set=allAccount();
        List<Account>accounts=new ArrayList<>();
        try{
            while(set.next()){
                accounts.add(new Account(set.getInt(1),set.getString(2),set.getString(3),set.getString(4)));
            }
        }catch (Exception e){
            System.out.println("Nu s-a creat lista");
        }
        return  accounts;
    }
}


