
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static final int N_PRODUTTORI_MATTONI = 8;

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Thread> produttoriMattThreadList = new ArrayList<Thread>();
        ArrayList<ProduttoreMattoni> produttoriMattList = new ArrayList<>();
        StringBuilder strBuilder = new StringBuilder();
        Forno f = new Forno();
        for (int i = 0; i < N_PRODUTTORI_MATTONI; i++) {
            ProduttoreMattoni pm = new ProduttoreMattoni(i, f, strBuilder);
            produttoriMattList.add(pm);
            Thread pMThread = new Thread(pm);
            produttoriMattThreadList.add(pMThread);
            pMThread.start();
        }
        for (Thread pM : produttoriMattThreadList) {
            try {
                pM.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        ArrayList<Mattone> mattoniDaImballareList = new ArrayList<Mattone>();
        for (ProduttoreMattoni pM : produttoriMattList) {
            mattoniDaImballareList.addAll(pM.getMattoniList());
        }
        Imballatore i = new Imballatore(mattoniDaImballareList);
        strBuilder.append(i.imballaMattoni());
        strBuilder.append(System.getProperty("line.separator"));
        PrintWriter fileOutput = new PrintWriter("FileOutput.txt");
        fileOutput.append(strBuilder.toString());
        fileOutput.close();

    }
}