import java.util.Scanner;
public class jail {
    public  boolean option(int diceNumber,player currentPlayer){
        Scanner scan=new Scanner(System.in);
        boolean freeNow=false;
        if(diceNumber==6){
            System.out.println("You rolled 6 ! You are free from jail now");
            currentPlayer.injail=false;
            freeNow=true;    
        }else{
            System.out.println("You have to roll 6 to free from jail");
            if(currentPlayer.hasJailPass()){
                System.out.print("Wanna use jail pass card to free from jail? (y for yes)");
                char answer=scan.next().charAt(0);
                if(answer=='y'){
                    currentPlayer.jailpass-=1;
                    currentPlayer.injail=false;
                    freeNow=true;   
                }
            }
                    
        }
        return freeNow;
    }
}
