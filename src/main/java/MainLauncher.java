public class MainLauncher {
    public static void main(String[]args){
        MarketplaceData market=new MarketplaceData();
        ConsoleMenu consoleMenu=new ConsoleMenu();
        System.out.println("Welcome!");
        consoleMenu.runMenu(market);
    }
}
