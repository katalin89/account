package view;

import model.Account;
import repository.AccountRepository;

import javax.security.sasl.SaslClient;
import java.util.List;
import java.util.Scanner;

public class ViewAccount {
    private AccountRepository accountRepository;

    public  ViewAccount(){
        accountRepository=new AccountRepository();
    }

    public  void meniu(){
        System.out.println("Apasa tasta 1 pentru a afisa toate accouts din baza de date");
        System.out.println("Apasa tasta 2 pentru a insera un account nou in baza de date");
        System.out.println("Apasa tasta 3 pentru a sterge un account din baza de date");
        System.out.println("Apasa tasta 4 pentru updatePassword");
        System.out.println("Apasa tasta 5 pentru a sterge un account dupa username");
    }

    public  void  play(){
        Scanner scanner=new Scanner(System.in);
        boolean run=true;
        int alege=0;
        while(run=true){
            meniu();
            alege=Integer.parseInt(scanner.nextLine());
            switch (alege){
                case 1:showAccounts();
                break;
                case 2:insertAccount();
                break;
                case 3:stergeUnAccount();
                break;
                case 4:updatePassword();
                break;
                case 5:stergeUser();
                break;
            }
        }
    }
    public  void  showAccounts(){
        List<Account>accounts=accountRepository.allAccounts();
        for(Account a:accounts){
            System.out.println(a.toString());
        }
    }



    public  void insertAccount(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti id");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti usernameul;");
        String username=scanner.nextLine();
        System.out.println("Introduceti passwordul");
        String password=scanner.nextLine();
        System.out.println("Introducei accounttype");
        String accounttype=scanner.nextLine();

     Account account=new Account(id,username,password,accounttype);
        accountRepository.insertAccount(account);

    }


    public  void stergeUnAccount(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti id ul accountului pe care doriti s-l sterget");
        int id=Integer.parseInt(scanner.nextLine());
        accountRepository.stergeAccountById(id);
        System.out.println("Masina s-a sters");

    }

    public  void updatePassword(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti userul accountului carui dorit sa modificati passwordul");
        String username=scanner.nextLine();
        System.out.println("Introduceti passwordul nou");
        String password=scanner.nextLine();
       accountRepository.updatePassword(username,password);
    }


    public  void  stergeUser(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Itroduceti userul  care doriti sa-l stergeti");
        String username=scanner.nextLine();
        accountRepository.deleteAccount(username);
    }
}


