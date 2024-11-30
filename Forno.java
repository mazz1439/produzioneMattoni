public class Forno {
    private static final int CAPACITA_FORNO = 400;
    
    public void cuociMattoni(int mattoni) throws InterruptedException {
        System.out.println("Forno: inizio cottura di " + mattoni + " mattoni.");
        Logger.scriviLog("Forno: inizio cottura di " + mattoni + " mattoni.");
        Thread.sleep(3000); // Simula il tempo di cottura
        System.out.println("Forno: cottura completata.");
        Logger.scriviLog("Forno: cottura completata.");
    }
}
