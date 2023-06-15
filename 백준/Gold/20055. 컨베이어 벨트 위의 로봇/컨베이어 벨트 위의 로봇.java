import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static class Slot {
        int endurance;
        boolean isRobotExist;
        
        Slot (int endurance) {
            this.endurance = endurance;
            this.isRobotExist = false;
        }
        
        Slot (int endurance, boolean isRobotExist) {
            this.endurance = endurance;
            this.isRobotExist = isRobotExist;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfConveyorBeltSlots = sc.nextInt();
        int enduranceZeroConveyorBeltThreshold = sc.nextInt();
        sc.nextLine();
        
        LinkedList<Slot> slots = new LinkedList<>();
        for(int i = 0; i < numberOfConveyorBeltSlots * 2; i++) {
           slots.add(new Slot(sc.nextInt()));
        }
        
        int level = 0;
        while( enduranceZeroConveyorBeltThreshold > 0) {
            level ++;
            
            slots.addFirst(slots.pollLast());
            slots.get(numberOfConveyorBeltSlots - 1).isRobotExist = false;
            for(int i = numberOfConveyorBeltSlots - 2; i >= 0; i--) {
                if(slots.get(i).isRobotExist) {
                    if (!slots.get(i + 1).isRobotExist && slots.get(i + 1).endurance > 0) {
                        slots.get(i).isRobotExist = false;
                        slots.get(i + 1).isRobotExist 
                            = i + 1 == numberOfConveyorBeltSlots - 1 ? false : true;
                        slots.get(i + 1).endurance -= 1;
                        
                        if(slots.get(i + 1).endurance == 0) {
                            --enduranceZeroConveyorBeltThreshold;
                        }
                    }
                }
            }
            
            if(slots.getFirst().endurance > 0) {
                slots.getFirst().endurance -= 1;
                slots.getFirst().isRobotExist = true;
                
                if(slots.getFirst().endurance == 0) {
                    --enduranceZeroConveyorBeltThreshold;
                }
            }
        }
        
        System.out.println(level);
    }
} 