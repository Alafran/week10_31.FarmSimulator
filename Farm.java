
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive{
    private String owner;
    private Barn thisOwnersBarn;
    private List<Cow> herdOfCows;
    
    public Farm(String owner, Barn barn){
        this.owner = owner;
        this.thisOwnersBarn = barn;
        this.herdOfCows = new ArrayList<Cow>();
    }
    
    public String getOwner() {
        return this.owner;
    }
    
    public void installMilkingRobot(MilkingRobot robot) {
        this.thisOwnersBarn.installMilkingRobot(robot);
    }

    @Override
    public void liveHour() {
        for(Cow cow : this.herdOfCows) {
            cow.liveHour();
        }
    }
    
    public void manageCows() {
        this.thisOwnersBarn.takeCareOf(this.herdOfCows);
    }
    
    public void addCow(Cow cow) {
        this.herdOfCows.add(cow);
    }

    @Override
    public String toString() {
        System.out.println("Farm owner: " + this.owner +"\nBarn bulk tank: " + this.thisOwnersBarn.getBulkTank());
        System.out.println("Animals:");
        for(Cow cow : this.herdOfCows) {
            System.out.println("        " + cow);
        }
        return "";
    }
    
    
}
