// Encapsulation provides security by hiding data
//
public class BankAccout {
    private Integer bankBalance;

    public void deposit(Integer amount){
        if(amount > 0)
            this.bankBalance += amount;
    }

    public Integer getBalance(){
        return this.bankBalance;
    }
}



public void main() {
    BankAccout bankAccout = new BankAccout();
    bankAccout.deposit(500);
    System.out.println(bankAccout.getBalance());
}

/*
here no one can manipulate bankBalance directly.
if bankBalance was public then one can add negative amount to it directly.
security vulnerable.
 */
