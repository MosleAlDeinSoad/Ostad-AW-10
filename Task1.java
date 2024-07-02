class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private static final double WITHDRAWAL_LIMIT = 1000;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("Withdrawal amount exceeds the limit of " + WITHDRAWAL_LIMIT);
        } else {
            super.withdraw(amount);
        }
    }
}

class CheckingAccount extends BankAccount {
    private static final double TRANSACTION_FEE = 2.5;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        double totalAmount = amount + TRANSACTION_FEE;
        if (totalAmount > balance) {
            System.out.println("Insufficient funds for withdrawal and transaction fee.");
        } else {
            super.withdraw(totalAmount);
            System.out.println("Transaction fee of " + TRANSACTION_FEE + " applied.");
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount(1500);
        BankAccount checking = new CheckingAccount(2000);

        savings.deposit(500);
        savings.withdraw(1200);
        savings.withdraw(500);

        checking.deposit(500);
        checking.withdraw(2000);
        checking.withdraw(500);

        System.out.println("Savings Account Balance: " + savings.getBalance());
        System.out.println("Checking Account Balance: " + checking.getBalance());
    }

}


