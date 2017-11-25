
package farmsimulator;

import java.util.Random;

public class Cow implements Alive, Milkable {
    
    private String name;
    private double udderCapacity;
    private double amountOfMilk;
    private Random random;
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    
    public Cow() {
        this.random = new Random();
        this.name = NAMES[random.nextInt(31)];
        this.udderCapacity = (double) random.nextInt(26) + 15;
        this.amountOfMilk = 0.0;
    }
    
    public Cow(String name) {
        this.random = new Random();
        this.name = name;
        this.udderCapacity = (double) random.nextInt(26) + 15;
        this.amountOfMilk = 0.0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCapacity() {
        return this.udderCapacity;
    }
    
    public double getAmount() {
        return this.amountOfMilk;
    }
    
    @Override
    public String toString() {
        return this.name + " " + this.amountOfMilk + "/" + this.udderCapacity;
    }

    @Override
    public void liveHour() {
        double milkProduced = Math.ceil(0.7 + (2.0 - 0.7) * this.random.nextDouble());
        if(this.udderCapacity >= this.amountOfMilk + milkProduced) {
            this.amountOfMilk += milkProduced;
        }
    }

    @Override
    public double milk() {
        double tempAmountOfMilk = this.amountOfMilk;
        this.amountOfMilk = 0;
        return tempAmountOfMilk;
    }
}
