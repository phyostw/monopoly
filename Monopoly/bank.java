public class bank {
    int money=15140;
    public void startmoneyforplayer(player[] players,int amount){
        for(int i=0;i<players.length;i++){
            players[i].addMoney(amount);
        }
    }
    public void addMoney(int amount){
        this.money+=amount;
    }
    public int adstractMoney(int amount){
        this.money-=amount;
        return amount;
    }
}
