import java.util.Scanner;
abstract class Account {
    Scanner input = new Scanner(System.in);
    private double interestRate;
    private double amount;
}
class FDAccount extends Account {
    double amount, interestRate, total;
    int noOfDays;
    int ageOfHolder;
    double calculateintrest() {
        System.out.println("Enter FD Amount: ");
        this.amount = input.nextDouble();
        System.out.println("Enter FD number of days: ");
        this.noOfDays = input.nextInt();
        System.out.println("Enter Your Age: ");
        this.ageOfHolder = input.nextInt();
        if (noOfDays < 0) {
            System.out.println("Invalid Days");
            System.exit(0);
        }
        if (ageOfHolder < 0) {
            System.out.println("Invalid age");
            System.exit(0);
        }
        if (amount < 10000000) {
            if ((noOfDays >= 7) && (noOfDays <= 14)) {
                interestRate = (ageOfHolder < 60) ? 4.50 : 5.00;
            } else if ((noOfDays >= 15) && (noOfDays <= 29)) {
                interestRate = (ageOfHolder < 60) ? 4.75 : 5.25;
            } else if ((noOfDays >= 30) && (noOfDays <= 45)) {
                interestRate = (ageOfHolder < 60) ? 5.50 : 6.00;
            } else if ((noOfDays >= 46) && (noOfDays <= 60)) {
                interestRate = (ageOfHolder < 60) ? 7 : 7.50;
            } else if ((noOfDays >= 61) && (noOfDays <= 184)) {
                interestRate = (ageOfHolder < 60) ? 7.50 : 8.00;
            } else if ((noOfDays >= 185) && (noOfDays <= 365)) {
                interestRate = (ageOfHolder < 60) ? 8.00 : 8.50;
            }
        }
        if (amount > 10000000) {
            if ((noOfDays >= 7) && (noOfDays <= 14)) {
                interestRate = 6.50;
            } else if ((noOfDays >= 15) && (noOfDays <= 29)) {
                interestRate = 6.75;
            } else if ((noOfDays >= 30) && (noOfDays <= 45)) {
                interestRate = 6.75;
            } else if ((noOfDays >= 46) && (noOfDays <= 60)) {
                interestRate = 8;
            } else if ((noOfDays >= 61) && (noOfDays <= 184)) {
                interestRate = 8.50;
            } else if ((noOfDays >= 185) && (noOfDays <= 365)) {
                interestRate = 10.00;
            }
        }
        total = amount * (interestRate / 100);
        return total;
    }
}
class SBAccount extends Account {
    double interestRate;
    double amount;
    int choice;
    double calculateintrest() {
        System.out.println("Enter Amount: ");
        this.amount = input.nextDouble();
        System.out.println("1. Nri account: ");
        System.out.println("2. Normal account: ");
        choice = input.nextInt();
        if (choice == 1) {
            interestRate = 0.06;
        } else if (choice == 2) {
            interestRate = 0.04;
        } else if (choice < 0 || choice > 2) {
            System.out.println("Wrong Input! ");
            System.exit(0);
        }
        return amount * interestRate;
    }
}
class RDAccount extends Account {
    double interestRate, amount, General, Senior, total;
    int noofMonths;
    int ageOfHolder;
    double calculateintrest() {
        System.out.println("Enter RD Amount: ");
        this.amount = input.nextDouble();
        System.out.println("Enter RD Months: ");
        this.noofMonths = input.nextInt();
        System.out.println("Enter Your Age: ");
        this.ageOfHolder = input.nextInt();
        if (noofMonths < 0) {
            System.out.println("Invalid Months");
            return 0;
        }
        if (ageOfHolder < 0) {
            System.out.println("Invalid age");
            return 0;
        }
        if (noofMonths <= 6) {
            General = 7.50;
            Senior = 8.00;
        } else if (noofMonths <= 9) {
            General = 7.55;
            Senior = 8.25;
        } else if (noofMonths <= 12) {
            General = 8.00;
            Senior = 8.50;
        } else if (noofMonths <= 15) {
            General = 8.25;
            Senior = 8.75;
        } else if (noofMonths < 18) {
            General = 8.50;
            Senior = 9.00;
        } else if (noofMonths < 21) {
            General = 8.75;
            Senior = 9.25;
        }
        interestRate = (ageOfHolder < 50) ? General : Senior;
        total = amount * (interestRate / 100);
        return total;
    }
}
class InterestCalculator {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                System.out.println("Select the option: ");
                System.out.println("1. Interest Calculator SB: ");
                System.out.println("2. Interest Calculator FD: ");
                System.out.println("3. Interest Calculator RD: ");
                System.out.println("4. Exit");

                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> {
                        SBAccount sb = new SBAccount();
                        System.out.println(sb.calculateintrest());
                    }
                    case 2 -> {
                        FDAccount fb = new FDAccount();
                        System.out.println(fb.calculateintrest());
                    }
                    case 3 -> {
                        RDAccount rd = new RDAccount();
                        System.out.println(rd.calculateintrest());
                    }
                    case 4 -> System.exit(0);
                    default -> System.out.println("Invalid option. Please try again.");
                }
                System.out.println();
            }
        }
    }
}