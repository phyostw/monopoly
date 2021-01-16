import java.util.ArrayList;

public class player {
    int id;
    int money=0;
    String color;
    int currentPosition=0;
    int jailpass=1;
    boolean injail=false;
    int totalownplace=0;
    ArrayList<Integer> ownplaces=new ArrayList<Integer>();
    player(int id,String color){
        this.id=id;
        this.color=color;
    }
    public int[] getOwnPlaces(){
        int[] places=new int[totalownplace];
        int counter=0;
        for(int i= 0;i<ownplaces.size();i++){
            if(ownplaces.get(i)!=null){
                places[counter]=ownplaces.get(i);
                counter+=1;
            }
        }
        return places;
    }
    public boolean own(int id){
        if(ownplaces.contains(id)){
            return true;
        }
        return false;
    }
    public void addOwnPlace(int placeId){
        boolean abletoadd=false;
        for(int i=0;i<ownplaces.size();i++){
            if(ownplaces.get(i)==null){
                ownplaces.set(i,placeId);
                totalownplace+=1;
                abletoadd=true;
                break;
            }
        }
        if(!abletoadd){
            ownplaces.add(placeId);
            totalownplace+=1;
        }
    }
    public  void removePlace(int placeId){
    
            if(ownplaces.contains(placeId)){
                ownplaces.set(ownplaces.indexOf(placeId), null);
                totalownplace-=1;
            }
    }
    public int getMoney(){
        return money;
    }
    public void addMoney(int amount){
        this.money+=amount;
    }
    public int adstractMoney(int amount){
        this.money-=amount;
        return amount;
    }
    public boolean isflatbroke(){
        if(money==0){
            return true;
        }
        return false;
    }
    public boolean hasJailPass(){
        if(jailpass>0){
            return true;
        }else{
            return false;
        }
    }
}
