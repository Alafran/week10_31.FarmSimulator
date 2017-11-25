
package farmsimulator;

public class MilkingRobot {

    private BulkTank bulkTank;
    
    public MilkingRobot() {
        this.bulkTank = null;
    }
    
    public BulkTank getBulkTank() {
        return this.bulkTank;
    }
    
    public void setBulkTank(BulkTank tank) {
        this.bulkTank = tank;
    }
    
    public void milk(Milkable milkable) {
        if(this.bulkTank == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        this.bulkTank.addToTank(milkable.milk());
    }
    
}
