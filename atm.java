import java.util.Scanner;
class bankacc{
    private double balance;
    public bankacc(double corebalance){
        this.balance=corebalance;
    }
    public boolean deposit(double amt){
        if(amt >0){
            balance+=amt;
            return true;
        }
        return false;
    }
    public boolean withdraw(double amt){
        if(amt>0 && amt<=balance){
            balance-=amt;
            return true;
        }
        return false;
    }
    public double chkbalance(){
        return balance;
    }
}
class ATMmachine{
    private bankacc BA;
    public ATMmachine(bankacc BA){
        this.BA=BA;
    }
    public void display_details(){
        System.out.println("Welcome user to the ATM Machine!!");
        System.out.println("1.Withdraw your amount ");
        System.out.println("2.Deposit your amount ");
        System.out.println("3.Check your account balance ");
        System.out.println("4.Exit");
    }
    public void process_details(int options){
        Scanner sc=new Scanner(System.in);
        double amount;
        switch(options){
            case 1:
                    System.out.println("Enter the amount to withdraw from your bank account :");
                    amount=sc.nextDouble();
                    if(BA.withdraw(amount)){
                        System.out.println("Withdrawal successful: "+BA.chkbalance());
                    }
                    else{
                        System.out.println("Sorry !! Insufficient balance");
                    }
                    break;
            case 2:
                    System.out.println("Enter the amount to deposit in your bank account :");
                    amount=sc.nextDouble();
                    //System.out.println(amount);
                    if(BA.deposit(amount)){
                        System.out.println("Deposit of your money successful.Current balance is :"+BA.chkbalance());
                    }
                    else{
                        System.out.println("Sorry!!But invalid deposit amount");
                    }
                    break;
            case 3:
                    System.out.println("Current balance of your bank account is :"+BA.chkbalance());
                    break;
            case 4:
                    System.out.println("Goodbye!!Do visit again!!");
                    System.exit(0);
            default:
                    System.out.println("Wrong input!!");
                    break;
        }
    }
}
class Test{
    public static void main(String args[]){
        bankacc acc =new bankacc(10000);
        ATMmachine atm=new ATMmachine(acc);
        Scanner sc=new Scanner(System.in);
        while(true){
            atm.display_details();
            System.out.println("Hello!! Please enter your choice :");
            int op=sc.nextInt();
            atm.process_details(op);
        }
    }
}