public class Imballatore {
    private static final int LOTTO_IMBALLO = 1600;

    public void imballaMattoni(int mattoni) {
        System.out.println("Imballatore: inizio imballaggio di " + mattoni + " mattoni.");
        Logger.scriviLog("Imballatore: inizio imballaggio di " + mattoni + " mattoni.");
        System.out.println("Imballatore: completato imballaggio del lotto di " + LOTTO_IMBALLO + " mattoni.");
        Logger.scriviLog("Imballatore: imballaggio completato.");
    }
}
