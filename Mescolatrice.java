public class Mescolatrice extends Thread {
    private static final int MATTONI_PER_MESCOLATRICE = 200;
    private int id;

    public Mescolatrice(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Mescolatrice " + id + ": inizio preparazione.");
            Thread.sleep(2000); // Simula il tempo di lavorazione
            System.out.println("Mescolatrice " + id + ": completata preparazione di " + MATTONI_PER_MESCOLATRICE + " mattoni.");
            Logger.scriviLog("Mescolatrice " + id + ": preparazione completata.");
        } catch (InterruptedException e) {
        }
    }
}
