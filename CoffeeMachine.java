package machine;
import java.util.Scanner;
import java.lang.Math;

public class CoffeeMachine {

    private static final Scanner scanner = new Scanner(System.in);

    private static int amountOfWater = 400;
    private static int amountOfMilk = 540;
    private static int amountOfCoffee = 120;
    private static int amountOfCups = 9;
    private static int amountOfMoney = 550;

    public static void main(String[] args) {

        action();

    }

    private static void printAmounts() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n", amountOfWater, amountOfMilk, amountOfCoffee, amountOfCups, amountOfMoney);
    }

    private static void action() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String choice = scanner.next();

        switch(choice) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String pickOfCoffee = scanner.next();
                if ("back".equals(pickOfCoffee)) {
                    action();
                } else {
                    int pickOfCoffeeInt = Integer.parseInt(pickOfCoffee);
                    if (checkAmounts(pickOfCoffeeInt)) {
                        changeAmounts(pickOfCoffeeInt);
                        System.out.println("I have enough resources, making you a coffee!");
                        action();
                    } else {
                        String missing = checkMissing(pickOfCoffeeInt);
                        System.out.printf("Sorry, not enough %s!\n", missing);
                        action();
                    }
                    action();
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                amountOfWater += scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                amountOfMilk += scanner.nextInt();
                System.out.println("Write how many grams of coffee you want to add:");
                amountOfCoffee += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add:");
                amountOfCups += scanner.nextInt();
                action();
                break;
            case "take":
                System.out.printf("I gave you $%d\n", amountOfMoney);
                amountOfMoney = 0;
                action();
                break;
            case "remaining":
                printAmounts();
                action();
                break;
            case "exit":
                System.exit(0);
        }
    }

    private static void changeAmounts(int pick) {
        switch(pick) {
            case 1:
                amountOfWater -= 250;
                amountOfCoffee -= 16;
                --amountOfCups;
                amountOfMoney += 4;
                break;
            case 2:
                amountOfWater -= 350;
                amountOfMilk -= 75;
                amountOfCoffee -= 20;
                --amountOfCups;
                amountOfMoney += 7;
                break;
            case 3:
                amountOfWater -= 200;
                amountOfMilk -= 100;
                amountOfCoffee -= 12;
                --amountOfCups;
                amountOfMoney += 6;
                break;
        }
    }

    private static boolean checkAmounts(int pick) {
        switch (pick) {
            case 1:
                if (amountOfWater >= 250 && amountOfCoffee >= 16 &&
                    amountOfCups >= 1) {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (amountOfWater >= 350 && amountOfMilk >= 75 &&
                        amountOfCoffee >= 20 && amountOfCups >= 1) {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (amountOfWater >= 200 && amountOfMilk >= 100 &&
                        amountOfCoffee >= 12 && amountOfCups >= 1) {
                    return true;
                } else {
                    return false;
                }
        }
        return true;
    }

    private static String checkMissing(int pick) {
        switch(pick) {
            case 1:
                if (amountOfWater < 250) {
                    return "water";
                } else if (amountOfCoffee < 16) {
                    return "coffee beans";
                } else if(amountOfCups < 1) {
                    return "disposable cups";
                }
                break;
            case 2:
                if (amountOfWater < 350) {
                    return "water";
                } else if (amountOfMilk < 75) {
                    return "milk";
                } else if (amountOfCoffee < 20) {
                    return "coffee beans";
                } else if(amountOfCups < 1) {
                    return "disposable cups";
                }
                break;
            case 3:
                if (amountOfWater < 200) {
                    return "water";
                } else if (amountOfMilk < 100) {
                    return "milk";
                } else if (amountOfCoffee < 12) {
                    return "coffee beans";
                } else if(amountOfCups < 1) {
                    return "disposable cups";
                }
                break;
        }
        return "1";
    }

}
