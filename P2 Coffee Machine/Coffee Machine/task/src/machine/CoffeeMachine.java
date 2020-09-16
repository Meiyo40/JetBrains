package machine;

import java.util.Scanner;

enum coffeeResources {

    ESPRESSO("Espresso",4, 250, 16, 0),
    LATTE("Latte",7,350,20,75),
    CAPPUCCINO("Cappuccino",6,200,12,100);

    String name;
    int cost;
    int water;
    int beans;
    int milk;

    coffeeResources(String name, int cost, int water, int beans, int milk) {
        this.name = name;
        this.cost = cost;
        this.water = water;
        this.beans = beans;
        this.milk = milk;
    }
}

public class CoffeeMachine {

    static int machineAccount = 550;
    static int machineWater = 400;
    static int machineMilk = 540;
    static int machineBeans = 120;
    static int machineCups = 9;

    public static void main(String[] args) {
        CoffeeMachine.working();
    }

    public static void getState(int machineWater, int machineMilk, int machineBeans, int machineCups, int machineAccount) {
        System.out.println("The coffee machine has: ");
        System.out.println(machineWater + " of water");
        System.out.println(machineMilk + " of milk");
        System.out.println(machineBeans + " of coffee beans");
        System.out.println(machineCups + " of disposable cups");
        System.out.println(machineAccount + " of money");
    }

    public static void working() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            if(action.equals("fill")) {
                System.out.println("Write how many ml of water do you want to add:");
                int amount = scanner.nextInt();
                CoffeeMachine.machineWater += amount;
                System.out.println("Write how many ml of milk do you want to add:");
                amount = scanner.nextInt();
                CoffeeMachine.machineMilk += amount;
                System.out.println("Write how many grams of coffee beans do you want to add:");
                amount = scanner.nextInt();
                CoffeeMachine.machineBeans += amount;
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                amount = scanner.nextInt();
                CoffeeMachine.machineCups += amount;

            } else if (action.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                String answer = scanner.next();
                if (answer.equals("1")) {
                    if (CoffeeMachine.machineCups > 0 && CoffeeMachine.machineWater >= coffeeResources.ESPRESSO.water && CoffeeMachine.machineBeans >= coffeeResources.ESPRESSO.beans) {
                        CoffeeMachine.machineWater -= coffeeResources.ESPRESSO.water;
                        CoffeeMachine.machineBeans -= coffeeResources.ESPRESSO.beans;
                        CoffeeMachine.machineAccount += coffeeResources.ESPRESSO.cost;
                        CoffeeMachine.machineCups--;
                    } else {
                        if (CoffeeMachine.machineCups <= 0) {
                            System.out.println("Sorry, not enough coffee cups!");
                        } else if (CoffeeMachine.machineWater < coffeeResources.ESPRESSO.water) {
                            System.out.println("Sorry, not enough water!");
                        } else if (CoffeeMachine.machineBeans < coffeeResources.ESPRESSO.beans) {
                            System.out.println("Sorry, not enough coffee beans!");
                        }
                    }
                } else if (answer.equals("2")) {
                    if (CoffeeMachine.machineCups > 0 && CoffeeMachine.machineWater >= coffeeResources.LATTE.water && CoffeeMachine.machineBeans >= coffeeResources.LATTE.beans && CoffeeMachine.machineMilk >= coffeeResources.LATTE.milk) {
                        CoffeeMachine.machineWater -= coffeeResources.LATTE.water;
                        CoffeeMachine.machineBeans -= coffeeResources.LATTE.beans;
                        CoffeeMachine.machineAccount += coffeeResources.LATTE.cost;
                        CoffeeMachine.machineMilk -= coffeeResources.LATTE.milk;
                        CoffeeMachine.machineCups--;
                    } else {
                        if (CoffeeMachine.machineCups <= 0) {
                            System.out.println("Sorry, not enough coffee cups!");
                        } else if (CoffeeMachine.machineWater < coffeeResources.LATTE.water) {
                            System.out.println("Sorry, not enough water!");
                        } else if (CoffeeMachine.machineBeans < coffeeResources.LATTE.beans) {
                            System.out.println("Sorry, not enough coffee beans!");
                        } else if (CoffeeMachine.machineMilk < coffeeResources.LATTE.milk) {
                            System.out.println("Sorry, not enough milk!");
                        }
                    }
                } else if (answer.equals("3")) {
                    if (CoffeeMachine.machineCups > 0 && CoffeeMachine.machineWater >= coffeeResources.CAPPUCCINO.water && CoffeeMachine.machineBeans >= coffeeResources.CAPPUCCINO.beans && CoffeeMachine.machineMilk >= coffeeResources.CAPPUCCINO.milk) {
                        CoffeeMachine.machineWater -= coffeeResources.CAPPUCCINO.water;
                        CoffeeMachine.machineBeans -= coffeeResources.CAPPUCCINO.beans;
                        CoffeeMachine.machineMilk -= coffeeResources.CAPPUCCINO.milk;
                        CoffeeMachine.machineAccount += coffeeResources.CAPPUCCINO.cost;
                        CoffeeMachine.machineCups--;
                    } else {
                        if (CoffeeMachine.machineCups <= 0) {
                            System.out.println("Sorry, not enough coffee cups!");
                        } else if (CoffeeMachine.machineWater < coffeeResources.CAPPUCCINO.water) {
                            System.out.println("Sorry, not enough water!");
                        } else if (CoffeeMachine.machineBeans < coffeeResources.CAPPUCCINO.beans) {
                            System.out.println("Sorry, not enough coffee beans!");
                        } else if (CoffeeMachine.machineMilk < coffeeResources.CAPPUCCINO.milk) {
                            System.out.println("Sorry, not enough milk!");
                        }
                    }
                } else if (answer.equals("back")) {
                    continue;
                }
            } else if (action.equals("take")) {
                System.out.println("I gave you $"+CoffeeMachine.machineAccount);
                CoffeeMachine.machineAccount = 0;
            } else if (action.equals("remaining")) {
                CoffeeMachine.getState(CoffeeMachine.machineWater, CoffeeMachine.machineMilk, CoffeeMachine.machineBeans, CoffeeMachine.machineCups, CoffeeMachine.machineAccount);
            } else if (action.equals("exit")) {
                exit = true;
            }
        } while (!exit);
    }
}
