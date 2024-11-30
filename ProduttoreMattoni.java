
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProduttoreMattoni implements Runnable {

    private int codiceThreadProduttore;
    private ArrayList<Mattone> mattoniStampatiList;
    private Forno forno;

    public ProduttoreMattoni(int codiceThreadProduttore, Forno f) {
        this.codiceThreadProduttore = codiceThreadProduttore;
        forno = f;
    }

    @Override
    public void run() {
        try {
            Impastatore i = new Impastatore(codiceThreadProduttore);
            System.out.println(i.Impasta());
            RulloStampante r = new RulloStampante(codiceThreadProduttore);
            System.out.println(r.StampaMattoni());
            mattoniStampatiList = r.TrasportaMattoni();
            forno.Inforna(mattoniStampatiList, codiceThreadProduttore);
            forno.Cuoci();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProduttoreMattoni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Mattone> getMattoniList() {
        return mattoniStampatiList;
    }

}
