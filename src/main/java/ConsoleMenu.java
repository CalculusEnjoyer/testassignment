import java.util.Scanner;

public class ConsoleMenu {
    private String menu = "\n1 -- Add customer to marketplace\n" +
            "2 -- Add product to marketplace\n" +
            "3 -- Make a purchase\n" +
            "4 -- Display all customers list\n" +
            "5 -- Display all products list\n" +
            "6 -- Display all customer's purchases\n" +
            "7 -- Display all customers that bought particular product\n" +
            "8 -- Delete product\n" +
            "9 -- Close the program\n" +
            "Please enter an integer value between 1 and 9:";


    public void runMenu(MarketplaceData marketplace){
        while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(menu);
                int answer = scanner.nextInt();
                switch (answer) {
                    case 1:
                        addCustomerFromConsole(marketplace);
                        break;
                    case 2:
                        addProductFromConsole(marketplace);
                        break;
                    case 3:
                        makePurchaseFromConsole(marketplace);
                        break;
                    case 4:
                        marketplace.displayListOfAllCustomers();
                        break;
                    case 5:
                        marketplace.displayListOfAllProducts();
                        break;
                    case 6:
                        displayCustomerPurchasesConsole(marketplace);
                        break;
                    case 7:
                        displayCustomersWithProdCons(marketplace);
                        break;
                    case 8:
                        deleteProductFromConsole(marketplace);
                        break;
                    case 9:
                        return;
                    default:
                        throw new Exception("Wrong input. You have to enter integers only from 1 to 9");
                }
            }catch (Exception e){
                System.out.println(e.getClass()+": "+e.getMessage());
            }
        }
    }

    public void addCustomerFromConsole(MarketplaceData marketplace){
        while (true){
            try{
                Scanner scanner = new Scanner(System.in);
                String firstName;
                String lastName;
                double amountOfMoney;
                System.out.println("Please enter first name:");
                firstName = scanner.nextLine();
                System.out.println("Please enter last name:");
                lastName = scanner.nextLine();
                System.out.println("Please enter customer's amount of money:");
                amountOfMoney = scanner.nextDouble();
                marketplace.addCustomer(firstName,lastName,amountOfMoney);
                return;
            }catch (Exception e){
                System.out.println(e.getClass()+": "+e.getMessage());
            }
        }
    }

    public void addProductFromConsole(MarketplaceData marketplace){
        while (true){
            try{
                Scanner scanner = new Scanner(System.in);
                String name;
                double amountOfMoney;
                System.out.println("Please enter product name:");
                name = scanner.nextLine();
                System.out.println("Please enter product's price:");
                amountOfMoney = scanner.nextDouble();
                marketplace.addProduct(name,amountOfMoney);
                return;
            }catch (Exception e){
                System.out.println(e.getClass()+": "+e.getMessage());
            }
        }
    }

    public void deleteProductFromConsole(MarketplaceData marketplace){
        while (true){
            try{
                Scanner scanner = new Scanner(System.in);
                int productId;
                System.out.println("Please enter product ID that you want to delete:");
                System.out.println("If you want to return to the main menu enter -1");
                productId = scanner.nextInt();
                if(productId==-1) return;
                else{
                    marketplace.deleteProduct(productId);
                    return;
                }
            }catch (Exception e){
                System.out.println(e.getClass()+": "+e.getMessage());
            }
        }
    }

    public void makePurchaseFromConsole(MarketplaceData marketplace){
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                int customerId;
                int productId;
                System.out.println("Please enter customer's ID: (if you want to go back to menu enter -1)");
                customerId = scanner.nextInt();
                if(customerId==-1) return;
                System.out.println("Please enter product's ID:");
                productId= scanner.nextInt();
                marketplace.buyProduct(customerId,productId);
                System.out.println("The product was successfully purchased");
                return;
            }catch (Exception e){
                System.out.println(e.getClass()+": "+e.getMessage());
            }
        }
    }
    //Display list of products that a particular customer has bought
    public void displayCustomerPurchasesConsole(MarketplaceData marketplace){
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                int customerId;
                System.out.println("Please enter customer's ID:");
                customerId = scanner.nextInt();
                marketplace.displayCustomerPurchases(customerId);
                return;
            }catch (Exception e){
                System.out.println(e.getClass()+": "+e.getMessage());
            }
        }
    }
    // Display customers that has bought particular product. User enters product's ID through console.
    public void displayCustomersWithProdCons(MarketplaceData marketplace){
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                int productId;
                System.out.println("Please enter product's ID:");
                productId = scanner.nextInt();
                marketplace.displayCustomersWithProduct(productId);
                return;
            }catch (Exception e){
                System.out.println(e.getClass()+": "+e.getMessage());
            }
        }
    }

    public ConsoleMenu(){}

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

}
