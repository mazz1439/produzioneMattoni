public class Main {
    private static final int NUMERO_MESCOLATRICI = 8;
    private static final int MATTONI_PER_CICLO = 1600;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Processo di produzione avviato.");
        Logger.scriviLog("Processo di produzione avviato.");

        // Fase 1: Preparazione della malta
        Mescolatrice[] mescolatrici = new Mescolatrice[NUMERO_MESCOLATRICI];
        for (int i = 0; i < NUMERO_MESCOLATRICI; i++) {
            mescolatrici[i] = new Mescolatrice(i + 1);
            mescolatrici[i].start();
        }
        for (Mescolatrice mescolatrice : mescolatrici) {
            mescolatrice.join();
        }

        // Fase 2: Cottura dei mattoni
        Forno forno = new Forno();
        int mattoniCotti = 0;
        while (mattoniCotti < MATTONI_PER_CICLO) {
            forno.cuociMattoni(Math.min(400, MATTONI_PER_CICLO - mattoniCotti));
            mattoniCotti += 400;
        }

        // Fase 3: Imballaggio
        Imballatore imballatore = new Imballatore();
        imballatore.imballaMattoni(MATTONI_PER_CICLO);

        System.out.println("Processo di produzione completato.");
        Logger.scriviLog("Processo di produzione completato.");
    }
}
