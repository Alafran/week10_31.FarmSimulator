
package farmsimulator;

import java.util.Collection;

public class Barn {
    private BulkTank thisBarnsBulkTank;
    private MilkingRobot thisBarnsMilkingRobot;
    
    public Barn(BulkTank tank) {
        this.thisBarnsBulkTank = tank;
        this.thisBarnsMilkingRobot = null;
    }
    
    public BulkTank getBulkTank() {
        return this.thisBarnsBulkTank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.thisBarnsMilkingRobot = milkingRobot;
        milkingRobot.setBulkTank(thisBarnsBulkTank);
        
    }
    
    public void takeCareOf(Cow cow) {
        if(this.thisBarnsMilkingRobot == null) {
            throw new IllegalStateException("The milking robot hasn't been installed");
        }
        
        this.thisBarnsMilkingRobot.milk(cow);
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        if(this.thisBarnsMilkingRobot == null) {
            throw new IllegalStateException("The milking robot hasn't been installed");
        }
        
        for(Cow cow : cows) {
            this.thisBarnsBulkTank.addToTank(cow.milk());
        }
        
    }
    
    public String toString() {
        return "Barn:" + this.thisBarnsBulkTank;
    }
}
