import java.util.Random;
import java.util.Scanner;
public class Monopoly {
    static placesproperty[] propertyList={new placesproperty("Start"),new placesproperty("WinterFell",200),new placesproperty("Dragonstone",400),new placesproperty("King's Landing",700),new placesproperty("Tower of Joy",1000),new placesproperty("Beyond the wall",700),new placesproperty("Jail"),new placesproperty("Highgarden",600),new placesproperty("Castly Rock",800),new placesproperty("Magic Box"),new placesproperty("Night's Watch",900),new placesproperty("Dorne",300),new placesproperty("Yunkai",200),new placesproperty("Castle Black",400)};
    static String[] color={"Red","Green","Yellow","Blue","Purple"};
    static player[] playerList;
    static bank bank =new bank();
    static Scanner s=new Scanner(System.in);
    public static  void setPlayer(int num){
        playerList=new player[num];
        for(int i=0;i<playerList.length;i++){
            playerList[i]=new player(i,color[i]);
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Monopoly presented by PHK");
        System.out.print("Enter the number of players(must at least 2 and max 5 player can play): ");
        int num=scanner.nextInt();
        while(num<2||num>5){
            System.out.print("Enter again: ");
            num=scanner.nextInt();
        }
        setPlayer(num);
        for(int i=0;i<playerList.length;i++){
            System.out.println("Player "+playerList[i].color+" joins the game");
        }
        runGame();
    }
    public static int rollDice(){
        boolean rollCompleted=false;
        while(!rollCompleted){
            System.out.print("Type r to roll Dice: ");
            char type=s.next().charAt(0);
            if(type=='r'){
                rollCompleted=true;
            }
        }
        return new Random().nextInt(7)+1;
    }
    
    public static void optionToSell(player currentPlayer){
        
        boolean complete=false;
        do{
            if(currentPlayer.totalownplace!=0){
                int[] places=currentPlayer.getOwnPlaces();
                System.out.println("Here are places that you own : ");
                for(int place:places){
                    System.out.println(" "+place+". "+propertyList[place].name+" $"+propertyList[place].sellPrice());
                }
            }else{
                complete=false;
                break;
            }
            System.out.println("press 0 to exit: ");
            int answer=s.nextInt();
            if(currentPlayer.own(answer)){
                sell(currentPlayer, answer, bank);
            }
            if(answer==0){
                complete=true;
            }
        }while(!complete);
    }
    public static void buy(player currentPlayer,int placeId,bank bank){
        if(currentPlayer.getMoney()>=propertyList[placeId].buyPrice){
            bank.addMoney(currentPlayer.adstractMoney(propertyList[placeId].buyPrice));
            currentPlayer.addOwnPlace(placeId);
            propertyList[placeId].setOwner(currentPlayer.id);
            System.out.println("You have bought "+propertyList[placeId].name);
        }else{
            System.out.println("You don't have enough money");
        }
        System.out.println("Total Amount: "+currentPlayer.getMoney());
    }
    public static void sell(player currentPlayer,int placeId,bank bank){
        currentPlayer.removePlace(placeId);
        currentPlayer.addMoney(bank.adstractMoney(propertyList[placeId].sellPrice()));
        propertyList[placeId].sell();
        System.out.println("Selling "+propertyList[placeId].name+" Success");
        System.out.println("Player "+currentPlayer.color+" has $ "+currentPlayer.getMoney());
    }
    public static void rollForWhoGoFirst(){
        int[] rollnumbers=new int[playerList.length];
        System.out.println("Now Let's row some dice to decide who go fist");
        for(int i=0;i<rollnumbers.length;i++){
            System.out.println("Player "+playerList[i].color+" turn: (press r)");
            char roll='a';
             while(roll!='r'){
                 roll=s.next().charAt(0);
             }
            rollnumbers[i]=rollDice();
        }
        for(int i=0;i<rollnumbers.length;i++){
            for(int j=i+1;j<rollnumbers.length;j++){
                if(rollnumbers[j]>rollnumbers[i]){
                    player tempPlayer=new player(-1,"");
                    int temp=rollnumbers[i];
                    rollnumbers[i]=rollnumbers[j];
                    rollnumbers[j]=temp;
                    tempPlayer.id=playerList[i].id;
                    tempPlayer.color=playerList[i].color;
                    playerList[i].id=playerList[j].id;
                    playerList[i].color=playerList[j].color;
                    playerList[j].id=tempPlayer.id;
                    playerList[j].color=tempPlayer.color;
                }
            }
        }
        for(int i=0;i<playerList.length;i++){
            System.out.println("Player "+playerList[i].color+" roll: "+rollnumbers[i]);
        }
        System.out.println("Player "+playerList[0].color+" go first");
    }
    public static void Option(player currentPlayer){
        //if position not == to jail magi nor
        if(propertyList[currentPlayer.currentPosition].hasOwner){
            if(propertyList[currentPlayer.currentPosition].ownerId!=currentPlayer.id){
                System.out.println("This place is owned by Player"+playerList[propertyList[currentPlayer.currentPosition].ownerId].color);
                int rentMoney=propertyList[currentPlayer.currentPosition].rentPrice();
                if(rentMoney>currentPlayer.getMoney()){
                    System.out.println("You don't have enough money");
                    //abletopay
                }else{
                    playerList[propertyList[currentPlayer.currentPosition].ownerId].addMoney(currentPlayer.adstractMoney(rentMoney));
                    System.out.println("You have paid $"+rentMoney+" to the owner");
                }
            }else{
                System.out.println("You own this place!");
            }
            
        }
            boolean complete=false;
            do{
                if(currentPlayer.currentPosition!=6&&currentPlayer.currentPosition!=9&&currentPlayer.currentPosition!=0){
                    if(!propertyList[currentPlayer.currentPosition].hasOwner){
                        if(!propertyList[currentPlayer.currentPosition].isOwner(currentPlayer.id)){
                            System.out.println("1: Buy "+propertyList[currentPlayer.currentPosition].name+" Price: "+propertyList[currentPlayer.currentPosition].buyPrice);
                        }
                    }
                }
                if(currentPlayer.totalownplace>0){
                    System.out.println("2: Sell Place");
                }
                System.out.println("0: exit: ");
                int answer=s.nextInt();
                switch(answer){
                    case 0:
                        complete=true;
                        
                        break;
                    case 1:
                        buy(currentPlayer,currentPlayer.currentPosition,bank);
                        break;
                    case 2:
                        optionToSell(currentPlayer);
                        break;
                    default:
                        System.out.println("Unknown Operation");
                        break;
                }
            }while(!complete);
        
    }
    public static int RichestPlayer(){
        int currentrichest=-1;
        int tempMoney=0;
        for(int i=0;i<playerList.length;i++){
            if(playerList[i].getMoney()>tempMoney){
                tempMoney=playerList[i].getMoney();
                currentrichest=playerList[i].id;
            }
        }
        return currentrichest;
    }
    public static void runGame(){
        board board=new board(playerList);
        jail jail=new jail();
        int ingameplayer=playerList.length;
        int playerCounter=0;
        boolean gameCompleted=false;
        System.out.println("Start Money for Player: ");
        int amount=s.nextInt();
        bank.startmoneyforplayer(playerList,amount);
        System.out.println("Added $"+amount+" to each player");
        //rollForWhoGoFirst();
        board.printBoard();
        while(!gameCompleted){
            if(playerCounter>playerList.length-1){
                playerCounter=0;
            }
            player currentPlayer=playerList[playerCounter];
            if(currentPlayer.getMoney()<=0&&currentPlayer.isflatbroke()){
                playerCounter+=1;
                continue;
            }
            System.out.println("Player "+currentPlayer.color+" Turn: ");
            System.out.println("Total Amount: $ "+currentPlayer.getMoney());
            int diceNumber=rollDice();
            
            if(currentPlayer.injail){
                if(!jail.option(diceNumber, currentPlayer)){
                    playerCounter+=1;
                    continue;
                }
            }
            currentPlayer.currentPosition=board.movePlayer(currentPlayer.currentPosition, currentPlayer.id, diceNumber);
            board.printBoard();
            System.out.println("Player "+currentPlayer.color+" got "+diceNumber);
            System.out.println("Player "+currentPlayer.color+" move to "+propertyList[currentPlayer.currentPosition].name);
            switch(currentPlayer.currentPosition){
                case 6:
                //jail
                    currentPlayer.injail=true;
                    System.out.print("You are in jail now");
                    Option(currentPlayer);
                    break;
                case 9:
                    //magic box
                    Option(currentPlayer);
                    break;
                default:
                    Option(currentPlayer);
                
            }
            if(currentPlayer.isflatbroke()&&currentPlayer.totalownplace==0){
                System.out.println("Player "+currentPlayer.color+" is running out of money and remove from the game");
                ingameplayer-=1;
            }
            if(ingameplayer==1){
                System.out.println("Player "+playerList[RichestPlayer()].color+" win the game!");
                System.out.println("Total Money: "+playerList[RichestPlayer()].getMoney());
                gameCompleted=true;
            }
            playerCounter+=1;
        }
    }
}
