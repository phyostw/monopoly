public class board {
    String[] places={"Start","WinterFell","Dragonstone","King's Landing","Tower of Joy","Beyond the Wall","Jail","Highgarden","Castly Rock","Magic Box","Night's Watch","Dorne","Yunkai","Castle Black"};
    char[] playerName;
    char[][] playerArea;
    board(player[] playerList){
        getPlayersTotal(playerList);
    }
    public void printBoard(){
        // horizontal place area  from 0 to 4
        System.out.print(" ");
        for(int i=0;i<5;i++){
            System.out.print("_"+"_".repeat(getLongestStringLength())+"_ ");
        }
        System.out.print(" ");
        System.out.println();
        System.out.print("| ");
        for(int i=0;i<5;i++){
            System.out.print(" ".repeat(getLongestStringLength())+" | ");
        }
        System.out.println();
        System.out.print("| ");
        for(int i=0;i<5;i++){
            System.out.print(places[i]+" ".repeat(getLongestStringLength()-places[i].length())+" | ");
        }
        System.out.println();
        System.out.print("|");
        for(int i=0;i<5;i++){
            System.out.print("_"+"_".repeat(getLongestStringLength())+"_|");
        }
        System.out.println();
        //horizontal player area for 0 to 4
        System.out.print("  ");
        for(int i=0;i<5;i++){
            for(int j=0;j<playerName.length;j++){
                if(playerArea[i][j]!='\0'){
                    System.out.print(playerArea[i][j]+" ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print(" ".repeat(getLongestStringLength()-(playerName.length*2))+"   ");
        }
        System.out.println();
        //vertical place area for 13 and 5
        //l
        System.out.print(" _"+"_".repeat(getLongestStringLength())+"_  ");
        //r
        System.out.print("                                                     ");
        System.out.print("_"+"_".repeat(getLongestStringLength())+"_ ");
        System.out.print(" ");
        //l
        System.out.println();
        System.out.print("| ");
        System.out.print(" ".repeat(getLongestStringLength())+" | ");
        //r
        System.out.print("                                                    ");
        System.out.print("| ");
        System.out.print(" ".repeat(getLongestStringLength())+" | ");
        //l
        System.out.println();
        System.out.print("| ");
        System.out.print(places[13]+" ".repeat(getLongestStringLength()-places[13].length())+" | ");
        //r
        System.out.print("                                                    ");
        System.out.print("| ");
        System.out.print(places[5]+" ".repeat(getLongestStringLength()-places[5].length())+" | ");
        System.out.println();
        //l
        System.out.print("|");
        System.out.print("_"+"_".repeat(getLongestStringLength())+"_|");
        //r
        System.out.print("                                                     ");
        System.out.print("|");
        System.out.print("_"+"_".repeat(getLongestStringLength())+"_|");
        System.out.println();
        //vertical player area for place 13 and 5
        //l
        System.out.print("  ");
        for(int j=0;j<playerName.length;j++){
            if(playerArea[13][j]!='\0'){
                System.out.print(playerArea[13][j]+" ");
            }else{
                System.out.print("  ");
            }
        }
        System.out.print(" ".repeat(getLongestStringLength()-(playerName.length*2))+"   ");
        //r
        System.out.print("                                                     ");
        for(int j=0;j<playerName.length;j++){
            if(playerArea[5][j]!='\0'){
                System.out.print(playerArea[5][j]+" ");
            }else{
                System.out.print("  ");
            }
        }
        System.out.print(" ".repeat(getLongestStringLength()-(playerName.length*2))+"   ");
        System.out.println();
        //vertical place area for 12 and 6
        System.out.print(" _"+"_".repeat(getLongestStringLength())+"_  ");
        //r
        System.out.print("                                                     ");
        System.out.print("_"+"_".repeat(getLongestStringLength())+"_ ");
        System.out.print(" ");
        //l
        System.out.println();
        System.out.print("| ");
        System.out.print(" ".repeat(getLongestStringLength())+" | ");
        //r
        System.out.print("                                                    ");
        System.out.print("| ");
        System.out.print(" ".repeat(getLongestStringLength())+" | ");
        //l
        System.out.println();
        System.out.print("| ");
        System.out.print(places[12]+" ".repeat(getLongestStringLength()-places[12].length())+" | ");
        //r
        System.out.print("                                                    ");
        System.out.print("| ");
        System.out.print(places[6]+" ".repeat(getLongestStringLength()-places[6].length())+" | ");
        System.out.println();
        //l
        System.out.print("|");
        System.out.print("_"+"_".repeat(getLongestStringLength())+"_|");
        //r
        System.out.print("                                                     ");
        System.out.print("|");
        System.out.print("_"+"_".repeat(getLongestStringLength())+"_|");
        System.out.println();
        //vertical player Area for 12 and 6
        //l
        System.out.print("  ");
        for(int j=0;j<playerName.length;j++){
            if(playerArea[12][j]!='\0'){
                System.out.print(playerArea[12][j]+" ");
            }else{
                System.out.print("  ");
            }
        }
        System.out.print(" ".repeat(getLongestStringLength()-(playerName.length*2))+"   ");
        //r
        System.out.print("                                                     ");
        for(int j=0;j<playerName.length;j++){
            if(playerArea[6][j]!='\0'){
                System.out.print(playerArea[6][j]+" ");
            }else{
                System.out.print("  ");
            }
        }
        System.out.print(" ".repeat(getLongestStringLength()-(playerName.length*2))+"   ");
        System.out.println();
        //horizonal place from 11 to 7 
        System.out.print(" ");
        for(int i=11;i>6;i--){
            System.out.print("_"+"_".repeat(getLongestStringLength())+"_ ");
        }
        System.out.print(" ");
        System.out.println();
        System.out.print("| ");
        for(int i=11;i>6;i--){
            System.out.print(" ".repeat(getLongestStringLength())+" | ");
        }
        System.out.println();
        System.out.print("| ");
        for(int i=11;i>6;i--){
            System.out.print(places[i]+" ".repeat(getLongestStringLength()-places[i].length())+" | ");
        }
        System.out.println();
        System.out.print("|");
        for(int i=11;i>6;i--){
            System.out.print("_"+"_".repeat(getLongestStringLength())+"_|");
        }
        System.out.println();
        // horizontal player Area from 11 to 7
        System.out.print("  ");
        for(int i=11;i>6;i--){
            for(int j=0;j<playerName.length;j++){
                if(playerArea[i][j]!='\0'){
                    System.out.print(playerArea[i][j]+" ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print(" ".repeat(getLongestStringLength()-(playerName.length*2))+"   ");
        }
        System.out.println();
    }
    public void getPlayersTotal(player[] playerList){
        this.playerArea=new char[places.length][playerList.length];
        this.playerName=new char[playerList.length];
        for(int i=0;i<playerList.length;i++){
            this.playerArea[0][i]=playerList[i].color.charAt(0);
            this.playerName[i]=playerList[i].color.charAt(0);
        }
    }
     int getLongestStringLength(){
         //this function is to get longest string length in places array
         //for further use in defining square width beteen each place in printboard function
        int l=0;
        for(int i=0;i<places.length;i++){
            if(places[i].length()>l){
                l=places[i].length();
            }
        }
        return l;
    }
    public int movePlayer(int currentPosition,int playerId,int step){
        
        int nextPosition;
        playerArea[currentPosition][playerId]='\0';
        if(currentPosition+step>=places.length){
            nextPosition=(currentPosition+step)-(places.length);
        }else{
            nextPosition=currentPosition+step;
        }
        playerArea[nextPosition][playerId]=playerName[playerId];
        return nextPosition;
    }
}
