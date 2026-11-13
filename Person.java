import java.util.Random;

public class Person {
    boolean isSick;
    boolean isDead;

    double xPos;
    double yPos;

    double RANGE = 100.0;

    int daysLeftImmune = 0;

    static final double DISTANCING = 0.25;      // 1 alla följer riktlinjer
    final int DAYS_IMMUNE = 1000;

    final double INIT_SICK_PROB = 0.02;  // 1 alla startar sjuka
    final double GET_WELL_PROB = 0.2;   // 1 alltid frisk
    final double DIE_PROB = 0.01;        // 1 alltid död
    final double INFECT_PROB = 0.02;       // 1 smittar alltid

    Person(){
        // isSick = (new Random().nextDouble() <= INIT_SICK_PROB) ? true : false;
        
        xPos = new Random().nextDouble(1000);
        yPos = new Random().nextDouble(1000);

        isSick = ((this.xPos >= 300 && this.xPos <= 700) && (this.yPos >= 200 && this.yPos <= 800));
    
        if (new Random().nextDouble() <= DISTANCING) RANGE /= 2;
    }
    void dayPasses(Person[] allPersons){
        if(isDead){return;} 
        if (daysLeftImmune > 0) daysLeftImmune--;
        if(!isSick){return;}
        
        if (new Random().nextDouble() <= DIE_PROB) {
            isDead = true;
            isSick = false;
            return;
        } else if (new Random().nextDouble() < GET_WELL_PROB){
            isSick = false;
            daysLeftImmune = DAYS_IMMUNE;
        } else {
            for (Person person : allPersons) {infect(person);}    
        }
    }
    void infect(Person victim){
        if(victim != this){
            double distance = Math.sqrt((victim.xPos - this.xPos)*(victim.xPos - this.xPos) +(victim.yPos - this.yPos)*(victim.yPos - this.yPos));
            if(distance <= RANGE) victim.becomesInfected();
        } 
    }
    void becomesInfected(){
        if(!isDead && !isSick && daysLeftImmune == 0){
            isSick = (new Random().nextDouble() <= INFECT_PROB);
        }
    }
}
