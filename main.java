import java.util.*;
import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    ArrayList<Product> allProducts = new ArrayList<>();
    Product pen = new Product(0.20, 1, 20, "pen");
    allProducts.add(pen);
    Product stickyNotes = new Product(0.30, 2, 20, "stickyNotes");
    allProducts.add(stickyNotes);
    Product tape = new Product(0.50, 3, 20, "tape");
    allProducts.add(tape);
    Product folder = new Product(0.60, 4, 20, "folder");
    allProducts.add(folder);
    Product holePuncher = new Product(2, 5, 20, "holePuncher");
    allProducts.add(holePuncher);
    Product oneReam = new Product(3, 6, 20, "oneReam");
    allProducts.add(oneReam);
    Product tapeDispenser = new Product(4, 7, 20, "tapeDispenser");
    allProducts.add(tapeDispenser);
    Product stapler = new Product(5, 8, 20, "stapler");
    allProducts.add(stapler);
    Product calculator = new Product(6, 9, 20, "calculator");
    allProducts.add(calculator);
    Product twoReams = new Product(6, 10, 20, "twoReams");
    allProducts.add(twoReams);
    System.out.println("");
    System.out.println("Are You an Employee or a Customer?");
    String role = input.nextLine();
    if (role.toLowerCase().equals("employee")){
      System.out.println("");
      System.out.println("What is the Employee Password?");
      String password = input.nextLine();
      while (true){
        if (password.equals("password1234")){
          employee(allProducts);
          break;
        }
        else{
          System.out.println("That's Incorrect.");
          System.out.println("Would You Like To Try Again?");
          String respond = input.nextLine();
          if (respond.toLowerCase().equals("yes")){
            System.out.println("What is the Employee Password?");
            password = input.nextLine();
            if (password.equals("password1234")){
              employee(allProducts);
              break;
            }
            else{
              System.out.println("That's Incorrect.");
              System.out.println("Would You Like To Proceed as a Customer?");
              String response = input.nextLine();
              if (response.toLowerCase().equals("yes")){
                customer(allProducts);
              }
              else {
                System.out.println("Thank You for Visiting The Michael Scott Paper Company.");
                break;
              }
            }
          }
          else{
            break;
          }
        }
      }
    }
    else if(role.toLowerCase().equals("customer")){
      customer(allProducts);
    }  
    else{
      System.out.println("That is an Invalid Role.");
    }
    
  }
  public static void employee(ArrayList<Product> allProducts){
    System.out.println("");
      for (int i = 0; i < allProducts.size(); i++){
          System.out.println((i + 1) + ". " + allProducts.get(i).getName() + "\t $" + allProducts.get(i).getsellPrice() + "0 " + "\t Production Cost: $" + allProducts.get(i).getpurchaseCost() + "0" +"\t Quantity: " + allProducts.get(i).getQuantity());
      }
    while(true){
      Scanner input = new Scanner(System.in);
      System.out.println("");
      System.out.println("Choose an Operation:");
      System.out.println("");
      System.out.println("Type 0 When Finished.");
      System.out.println("1. Add a Product.");
      System.out.println("2. Remove a Product.");
      System.out.println("3. Change the Quantity of a Product.");
      System.out.println("4. Inform You of the Quantity of a product.");
      System.out.println("5. Change Cost Price of a Product.");
      System.out.println("6. Change Sale Price of a Product.");
      System.out.println("7. Switch to Employee Site.");
      String addItem;
      int operate = input.nextInt();
      if (operate == 0){
        break;
      }
      else if(operate == 1){
        System.out.println("What Would You Like To Add?");
        addItem = input.next();
        input.nextLine();
        System.out.println("What is the Production Cost of the Product?");
        double newproductionPrice = input.nextDouble();System.out.println("What is the Sale Price of the Product?");
        int newsalePrice = input.nextInt();
        Product newProduct = new Product(newproductionPrice, newsalePrice, 20, addItem);
        allProducts.add(newProduct);  
        for (int i = 0; i < allProducts.size(); i++){
          System.out.println((i + 1) + ". " + allProducts.get(i).getName() + "\t $" + allProducts.get(i).getsellPrice() + "0" + "\t Production Cost: $" + allProducts.get(i).getpurchaseCost() + "0" + "\t Quantity: " + allProducts.get(i).getQuantity());
        }
      }
      else if(operate == 2){
        System.out.println("What Would You Like To Remove?");
        int removeProduct = input.nextInt();
        input.nextLine();
        allProducts.remove(removeProduct - 1);
        for (int i = 0; i < allProducts.size(); i++){
          System.out.println((i + 1) + ". " + allProducts.get(i).getName() + "\t $" + allProducts.get(i).getsellPrice() + "0" + "\t Production Cost: $" + allProducts.get(i).getpurchaseCost() + "0" +"\t Quantity: " + allProducts.get(i).getQuantity());
        }
      }
      else if(operate == 3){
        System.out.println("Which Product's Quantity Would You Like to Change?");
        int changeNumber = input.nextInt();
        System.out.println("How Would You Like To Change It?");
        int changenumberAmount = input.nextInt();
        allProducts.get(changeNumber - 1).setQuantity(changenumberAmount);
        if (allProducts.get(changeNumber - 1).getQuantity() < 5){
          System.out.println("Your Quantity is Less than 5. Please Restock Item Number: " + changeNumber);
          System.out.println("");
        }
        for (int i = 0; i < allProducts.size(); i++){
          System.out.println((i + 1) + ". " + allProducts.get(i).getName() + "\t $" + allProducts.get(i).getsellPrice() + "0" + "\t Production Cost: $" + allProducts.get(i).getpurchaseCost() + "0" + "\t Quantity: " + allProducts.get(i).getQuantity());
        }
      }
      else if(operate == 4){
        System.out.println("Which Product's Quantity Do You Want to Know About?");
        int knowAmount = input.nextInt();
        System.out.println("");
        System.out.println("The Quantity of the Product is: "+ allProducts.get(knowAmount - 1).getQuantity());
        System.out.println("");
        if (allProducts.get(knowAmount - 1).getQuantity() < 5){
          System.out.println("Your Quantity is Less than 5. Please Restock Item: " + knowAmount);
          System.out.println("");
        }
        for (int i = 0; i < allProducts.size(); i++){
          System.out.println((i + 1) + ". " + allProducts.get(i).getName() + "\t $" + allProducts.get(i).getsellPrice() + "0" + "\t Production Cost: $" + allProducts.get(i).getpurchaseCost() + "0" + "\t Quantity: " + allProducts.get(i).getQuantity());
        }
      }
      else if(operate == 5){
        System.out.println("Which Product's Production Cost Do You Want to Change? ");
        int changeproductionCost = input.nextInt();
        System.out.println("What Do You Want to Change it To?");
        int changeproductionCost1 = input.nextInt();
        allProducts.get(changeproductionCost - 1).setpurchaseCost(changeproductionCost1);
        for (int i = 0; i < allProducts.size(); i++){
          System.out.println((i + 1) + ". " + allProducts.get(i).getName() + "\t $" + allProducts.get(i).getsellPrice() + "0"+ "\t Production Cost: $" + allProducts.get(i).getpurchaseCost() + "0" +"\t Quantity: " + allProducts.get(i).getQuantity());
        }
      }
      else if(operate == 6){
        System.out.println("Which Product's Sale Price Do You Want to Change? ");
        int changesaleCost = input.nextInt();
        System.out.println("What Do You Want to Change it To?");
        int changesaleCost1 = input.nextInt();
        allProducts.get(changesaleCost - 1).setsellPrice(changesaleCost1);
        for (int i = 0; i < allProducts.size(); i++){
          System.out.println((i + 1) + ". " + allProducts.get(i).getName() + "\t $" + allProducts.get(i).getsellPrice() + "0" + "\t Production Cost: $" + allProducts.get(i).getpurchaseCost() + "0" + "\t Quantity: " + allProducts.get(i).getQuantity());
        }
      }
      else if(operate == 7){
        customer(allProducts);
      }
      else{
        System.out.println("Unknown Operation.");
      }
    }
  }
  public static void customer(ArrayList<Product> allProducts){
    ArrayList<String> addProduct = new ArrayList<>();
    ArrayList<Integer> addQuantity = new ArrayList<>();
    
    System.out.println("");
    System.out.println("");
    System.out.println("Thank You For Choosing The Michael Scott Paper Company as Your #1 Office Supply Shop!!");
    System.out.println("");
    System.out.println("Seperate the Products With an Enter.");
    System.out.println("");
    System.out.println("Input done When You Are Done With Your Cart.");
    for (int i = 0; i < allProducts.size(); i++){
      System.out.println((i + 1) + ". " + allProducts.get(i).getName() + " - $" + allProducts.get(i).getsellPrice() + "0");
    }
    String n;
    int quantity;
    Scanner input = new Scanner(System.in);
    while (true) {
      System.out.println("Which Product Do You Wish For?(If you are done, write done.)");
      n = input.nextLine();
      if (n.equals("done")){
        System.out.println("Switch to Employee Site?");
        String answer = input.nextLine();
        if(answer.equals("yes")){
          System.out.println("What is the password?");
          String ans = input.nextLine();
          if(ans.equals("password1234")){
            employee(allProducts);
          }
          else{
            System.out.println("That is incorrect.");
            break;
          }
        }
        else{
          break;
        }
      }
      addProduct.add(n);
      System.out.println("What is the quantity?");
      quantity = input.nextInt();
      if(quantity == 0 || quantity > 20){
        System.out.println("Invalid Quantity");
        break;
      }
      addQuantity.add(quantity);
      input.nextLine();
    }
    double price = 0.0;
    for (int i = 0; i < addProduct.size(); i++){
      double j = (allProducts.get(i)).getsellPrice();
      double finalPrice = j * addQuantity.get(i);
      price = price + finalPrice;      
    }
    System.out.println("Your Total Price: $" + price + "0");
  } 
}
