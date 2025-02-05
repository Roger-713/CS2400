import java.util.ArrayList;
import java.util.Scanner;
/*
 * Author: Rogelio Flores 
 * Description: Task 3 of Lab 7 SRC; This program builds on top of Task 2 of Lab 7 SRC and it 
 * prints all the income items (positive values) first and provides an income subtotal, it
 * also prints all the expense items (negative values) second and provides an expense subtotal.
 * The monetary values, subtotals, and totals will be displayed in a well formatted way. It will
 * be tested using the troublesome data examples.
 * Date: 11/01/24
 */

 public class SRC_LAB7_TASK3{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> incomeNames = new ArrayList<>();
        ArrayList<Float> incomeValues = new ArrayList<>();
        ArrayList<String> expenseNames = new ArrayList<>();
        ArrayList<Float> expenseValues = new ArrayList<>();
        boolean inputContinue = true;
        float incomeSubtotal = 0;
        float expenseSubtotal = 0;
        float total = 0;

        System.out.println("Directions:");
        System.out.println("Enter income or expense items, to stop leave blank and click enter");
        System.out.println("Enter the value of the item without a dollar sign and use decimals");
        System.out.println();

        while(inputContinue){
            System.out.println("Enter item name:");
            String itemName = scanner.nextLine();
            
            if(itemName.length() == 0){
                inputContinue = false;
                break;
            }
            float itemValue = 0;
            boolean validInput = false;

            while(!validInput){
                System.out.println("Enter item value:");
                String valueInput = scanner.nextLine();

                try {
                    itemValue = Float.parseFloat(valueInput);
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("That input is not valid, please enter like this (-40.25, 35.50, or 0.30)");
                }

            }

            if(itemValue >= 0){
                incomeNames.add(itemName);
                incomeValues.add(itemValue);
            }
            else{
                expenseNames.add(itemName);
                expenseValues.add(itemValue);
            }
        }

        for(int i = 0; i < incomeValues.size(); i++){
            incomeSubtotal += incomeValues.get(i);
        }

        for(int i = 0; i < expenseValues.size(); i++){
            expenseSubtotal += expenseValues.get(i);
        }

        total = incomeSubtotal + expenseSubtotal;
        
        System.out.println("\nIncome:");
        for(int i = 0; i < incomeNames.size(); i++){
            System.out.printf("%-10s $ %8.2f%n", incomeNames.get(i), incomeValues.get(i));
        }
        System.out.printf("Subtotal:   $  (%8.2f)%n", incomeSubtotal);

        System.out.println("\nExpenses:");
        for(int i = 0; i < expenseNames.size(); i++){
            System.out.printf("%-10s $ (%8.2f)%n", expenseNames.get(i), Math.abs(expenseValues.get(i)));
        }
        System.out.printf("Subtotal:   $  (%8.2f)%n", Math.abs(expenseSubtotal));

        System.out.println("\nTotal:");
        if(total < 0 ){
            System.out.printf("Total:      $ (%8.2f)%n", Math.abs(total));
        }
        else{
            System.out.printf("Total      $ %8.2f%n", total);
        }
        scanner.close();
    }
 }