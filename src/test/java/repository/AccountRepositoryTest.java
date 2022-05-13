package repository;

import model.Account;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {

    @Test
    public  void  insert(){
        AccountRepository accountRepository=new AccountRepository();
        Account account=new Account(100,"Madalin","123","user");
        accountRepository.insertAccount(account);
    }

    @Test
    public  void sterfeById(){
        AccountRepository accountRepository=new AccountRepository();
       accountRepository.stergeAccountById(5);

    }

    @Test
    public  void updatePassword(){
        AccountRepository accountRepository=new AccountRepository();
        accountRepository.updatePassword("Madalin","999");

    }

    @Test
    public  void deleteNume(){
        AccountRepository accountRepository=new AccountRepository();
        accountRepository.deleteAccount("Madalin");

    }


    @Test
    public  void allAccounts(){
        AccountRepository accountRepository=new AccountRepository();
        List<Account>accounts=accountRepository.allAccounts();
        for(Account a:accounts){
            System.out.println(a.toString());
        }

    }
}