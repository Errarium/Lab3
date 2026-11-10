public class Village {
    final int SIZE = 1000;
    Person[] population = new Person[SIZE];

    Village(){
        for (int i = 0; i < SIZE; i++) {
            population[i] = new Person();
        }
    }
    int countSick(){
        int i = 0;
        for (Person individual : population) {
            if (individual.isSick) i++;
        }
        return i;
    }
    void dayPassesAll(){
        for (Person individual : population) {
            individual.dayPasses(population);
        }
    }
    int countDead(){
        int i = 0;
        for (Person individual : population) {
            if (individual.isDead) i++;
        }
        return i;
    }
    int countImmune(){
        int i = 0;
        for (Person individual : population) {
            if (individual.daysLeftImmune > 0) i++;
        }
        return i;
    }
}
