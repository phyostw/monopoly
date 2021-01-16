public class placesproperty {
    String name;
    boolean hasOwner=false;
    int houseNumber=0;
    int ownerId=-1;
    int buyPrice;
    
    
    placesproperty(String name){
        this.name=name;
    }
    placesproperty(String name,int buyPrice){
        this.name=name;
        this.buyPrice=buyPrice;
    }
    public boolean isOwner(int id){
        if(this.ownerId==id){
            return true;
        }
        return false;
    }
    public void setOwner(int id){
        this.ownerId=id;
        hasOwner=true;
    }
    public int getOwnerId(){
        return ownerId;
    }
    public int rentPrice(){
        return buyPrice*10/100;
    }
    public int sellPrice(){
        return buyPrice-(buyPrice*20/100);
    }
    public void sell(){
        this.hasOwner=false;
    }
    public void sell(int id){
        this.hasOwner=true;
        this.ownerId=id;
    }
}

