/*
# Composition
 */

interface withDrawable{
    void withDraw(Integer amount);
}
public class SavingsAccount implements withDrawable {
    private Integer bankBalance = 0;
    public boolean hasSufficientBalance(Integer amount) {
        return amount > 0 && amount <= bankBalance;
    }

    public void deductAmount(Integer amount) {
        this.bankBalance -= amount;
    }

    public Integer getBalance() {
        return this.bankBalance;
    }

    @Override
    public void withDraw(Integer amount) {
        if(amount > 0 && amount < this.bankBalance && isMatured())
            this.bankBalance -= amount;
    }
    private boolean isMatured() {
        // Demo implementation
        return true;
    }
}

public class CurrentAccount implements withDrawable {
    private Integer bankBalance;

    public void deposit(Integer amount){
        if(amount > 0)
            this.bankBalance += amount;
    }

    public Integer getBalance(){
        return this.bankBalance;
    }

    @Override
    public void withDraw(Integer amount) {
        if(amount > 0 && amount < this.bankBalance)
            this.bankBalance -= amount;
    }
}


// Now we can reuse of code

public class BankAccount {
    private Integer bankBalance = 0;
    public boolean hasSufficientBalance(Integer amount) {
        return amount > 0 && amount <= bankBalance;
    }

    public void deductAmount(Integer amount) {
        this.bankBalance -= amount;
    }

    public Integer getBalance() {
        return this.bankBalance;
    }
}

public class SavingsAccount implements withDrawable {
    private final BankAccount bankAccount;

    public SavingsAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void withDraw(Integer amount) {
        if (bankAccount.hasSufficientBalance(amount) && isMatured()) {
            bankAccount.deductAmount(amount);
        }
    }
    private boolean isMatured() {
        // Demo implementation
        return true;
    }
    public BankAccount getBankAccount(){
        return bankAccount;
    }
}

public class CurrentAccount implements withDrawable {
    private final BankAccount bankAccount;

    public CurrentAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void withDraw(Integer amount) {
        if (bankAccount.hasSufficientBalance(amount)) {
            bankAccount.deductAmount(amount);
        }
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}

/*
1️⃣ Why do we use final for bankAccount?
✔ Short answer:

To prevent the reference from being reassigned later.

Example without final:
private BankAccount bankAccount;

public SavingsAccount(BankAccount bankAccount) {
    this.bankAccount = bankAccount;
}

public void changeAccount(BankAccount newAcc) {
    this.bankAccount = newAcc; // allowed if not final
}

This means someone could later change the internal account object → breaking encapsulation and possibly causing bugs.
 */