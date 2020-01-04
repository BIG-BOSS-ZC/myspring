package com.myspring.day4.sys;

import com.myspring.day4.sys.model.Account;
import com.myspring.day4.sys.service.AdminService;
import com.myspring.day4.sys.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component("client")
public class Client {
    @Autowired
    private SimpleService simpleService;
    @Autowired
    private AdminService adminService;

    private Account nowAccount;
    
    public void createAccount(){
        try {
            Scanner scanner=new Scanner((System.in));
            System.out.println("请输入账户名：");
            String name=scanner.next();
            System.out.println("请输入密码：");
            String password=scanner.next();
            System.out.println("请输入金额：");
            String d=scanner.next();
            BigDecimal money=new BigDecimal(d);
            Account account=new Account();
            account.setUsername(name);
            account.setPassword(password);
            account.setMoney(money);
            boolean acc = adminService.createAccount(account);
            if(acc){
                System.out.println("创建成功！");
            }else {
                System.out.println("创建失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("输入有误！");
        }

    }

    public void welcomePage() {
        System.out.println(
                "************欢迎使用账户管理系统************\n" +
                        "*               1.登录                  *\n" +
                        "*               2.退出                  *\n" +
                        "****************************************\n" +
                        ">>>请选择:"
        );
    }


    public void adminLoginPage() {
        System.out.println(
                "******欢迎使用账户管理系统(管理员模式)********\n" +
                        "*               1.创建账户               *\n" +
                        "*               2.删除账户               *\n" +
                        "*               3.账户列表               *\n" +
                        "*               4.退出                  *\n" +
                        "*****************************************\n"+
                        ">>>请选择:"
        );
        while (true){
            Scanner scanner=new Scanner(System.in);
            String choice=scanner.next();
            if(choice.equals("1")){
                createAccount();
            }else if(choice.equals("2")){
                deleteAccount();
            }else if(choice.equals("3")){
                listAll();
            }else if(choice.equals("4")){
                exit();
                break;
            }else {
                System.out.println("输入有误！");
            }
        }
    }


    public void simpleLoginPage() {
        System.out.println(
                "******欢迎使用账户管理系统(普通会员模式)*******\n" +
                        "*               1.查询余额                *\n" +
                        "*               2.取款                   *\n" +
                        "*               3.存款                   *\n" +
                        "*               4.转账                   *\n" +
                        "*               5.退出                   *\n" +
                        "*****************************************\n"+
                        ">>>请选择:"
        );
        while (true){
            Scanner scanner=new Scanner(System.in);
            String choice=scanner.next();
            if(choice.equals("1")){
                seeMoney();
            }else if(choice.equals("2")){
                take();
            }else if(choice.equals("3")){
                save();
            }else if(choice.equals("4")){
                transfer();
            }else if(choice.equals("5")){
                exit();
                break;
            }else {
                System.out.println("输入有误！");
            }
        }
    }

    public void seeMoney() {
        BigDecimal money = simpleService.seeMoney(nowAccount.getId());
        System.out.println(money);
    }
    public void take() {
        Scanner scanner=new Scanner(System.in);
        try {
            System.out.println("请输入取款金额：");
            String m=scanner.next();
            BigDecimal money=new BigDecimal(m);
            boolean take = simpleService.take(nowAccount.getId(), money);
            if(take){
                System.out.println("取款成功");
            }else {
                System.out.println("取款失败");
            }
        }catch(Exception e){
            System.out.println("输入有误");
        }

    }

    public void save(){
        Scanner scanner=new Scanner(System.in);
        try {
            System.out.println("请输入存款金额：");
            String m=scanner.next();
            BigDecimal money=new BigDecimal(m);
            boolean save = simpleService.save(nowAccount.getId(), money);
            if(save){
                System.out.println("存款成功");
            }else {
                System.out.println("存款失败");
            }
        }catch(Exception e){
            System.out.println("输入有误");
        }
    }

    public void transfer(){
        Scanner scanner=new Scanner(System.in);
        try {
            System.out.println("请输入转帐金额：");
            String m=scanner.next();
            BigDecimal money=new BigDecimal(m);
            System.out.println("请输入转出到账户：");
            int toid=scanner.nextInt();
            boolean transfer = simpleService.transfer(nowAccount.getId(), toid, money);
            if(transfer){
                System.out.println("转账成功");
            }else {
                System.out.println("转账失败");
            }
        }catch(Exception e){
            System.out.println("输入有误");
        }
    }


    public void listAll() {
        List<Account> accounts = adminService.listAll();
        accounts.forEach(System.out::println);
    }

    public void deleteAccount() {
        Scanner scanner=new Scanner(System.in);
        try {
            System.out.println("请输入删除账户id：");
            int id=scanner.nextInt();
            boolean tf = adminService.deleteAccount(id);
            if(tf){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }catch(Exception e){
            System.out.println("输入有误");
        }
    }


    public void exit() {
        nowAccount=null;
        System.out.println("欢迎使用，再见(｡◕ˇ∀ˇ◕)");
    }


    public void run() {
        Scanner scanner=new Scanner(System.in);
        while (true){
            welcomePage();
            String choice=scanner.next();
            if(choice.equals("1")){
                Account login = login();
                if(login==null){
                    System.out.println("用户名或密码错误！");
                    continue;
                }else if(login.getRole().equals("admin")){
                    nowAccount=login;
                    adminLoginPage();
                }else{
                    nowAccount=login;
                    simpleLoginPage();
                }
            }else if(choice.equals("2")){
                exit();
                break;
            }
        }
    }


    public Account login() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username=scanner.next();
        System.out.println("请输入密码:");
        String password=scanner.next();
        Account login = adminService.login(username, password);
        return login;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new
                AnnotationConfigApplicationContext(
             "com.myspring.day4.sys"
        );

        Client client =(Client) context.getBean("client");
        client.run();
    }
}
