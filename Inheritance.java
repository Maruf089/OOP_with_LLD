
public class CurrentAccount {
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

    public void withDraw(Integer amount) {
        if (amount < this.bankBalance) {
            this.bankBalance -= amount;
        }
    }
    public void deposit(Integer amount) {
        if (amount > 0) {
            this.bankBalance += amount;
        }
    }
}


public class SavingsAccount extends CurrentAccount{
    @Override
    public void withDraw(Integer amount) {
        if (amount < super.getBalance() && isMatured()) {
            super.deductAmount(amount);
        }
    }
    private boolean isMatured() {
        // Demo implementation
        return true;
    }
}

public class MainTest {
    public static void main(String[] args) {

        // Create SavingsAccount object (child class)
        SavingsAccount savings = new SavingsAccount();

        // Check balance
        System.out.println("Current balance: " + savings.getBalance());

        // Try withdrawing (SavingsAccount override)
        System.out.println("Withdrawing 2000...");
        savings.withDraw(2000);

        // Check balance again
        System.out.println("Balance after withdrawal: " + savings.getBalance());


        // --- TESTING INHERITANCE ---

        // 1. Can SavingsAccount access parent methods?
        System.out.println("Has sufficient balance? " + savings.hasSufficientBalance(1000));

        // 2. Does SavingsAccount override withdraw()?
        System.out.println("Trying to withdraw 999 (should call overridden method)...");
        savings.withDraw(999);

        System.out.println("Final balance: " + savings.getBalance());
    }
}
