public class Lab3 {
    public static void main(String[] args) {
        Village town = new Village();
        int days = 0;

        while (town.countSick() > 0) {
            System.out.println("\nInfected: " + town.countSick());
            System.out.println("Dead: " + town.countDead() + ", by day " + days);
            System.out.println("Immune: " + town.countImmune() + ", by day " + days);
            town.dayPassesAll();
            days++;
        }

        System.out.println("\nIs population cured: " + (town.countSick() == 0) + " in " + days + " days.");
        // System.out.println("Dead: " + town.countDead());
    }
}
