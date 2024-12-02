
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProduttoreMattoni implements Runnable {

    private int codiceThreadProduttore;
    private ArrayList<Mattone> mattoniStampatiList;
    private Forno forno;
    private StringBuilder strB;

    public ProduttoreMattoni(int codiceThreadProduttore, Forno f, StringBuilder strBuilder) {
        this.codiceThreadProduttore = codiceThreadProduttore;
        forno = f;
        this.strB = strBuilder;
    }

    @Override
    public void run() {
        try {
            String result;
            Impastatore i = new Impastatore(codiceThreadProduttore);
            result = i.Impasta();
            System.out.println(result);
            strB.append(result);
            strB.append(System.getProperty("line.separator"));
            RulloStampante r = new RulloStampante(codiceThreadProduttore);
            result = r.StampaMattoni();
            System.out.println(result);
            strB.append(result);
            strB.append(System.getProperty("line.separator"));
            mattoniStampatiList = r.TrasportaMattoni();
            result = forno.Inforna(mattoniStampatiList, codiceThreadProduttore);
            // insisti ad infornare fintanto che il num di mattoni non torna <= 200
            while (result.equals(new String(""))) {// se resittuisce stringa vuota
                // vuol dire che non ha infornato
                // perché il num di mattoni è maggiore di 200
                // deve aspettare che il forno cuocia e venga svuotato
                result = forno.Inforna(mattoniStampatiList, codiceThreadProduttore);
            }
            strB.append(result);
            strB.append(System.getProperty("line.separator"));
            result = forno.Cuoci();
            if (!result.equals(new String(""))) {
                strB.append(result);
                strB.append(System.getProperty("line.separator"));
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ProduttoreMattoni.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Mattone> getMattoniList() {
        return mattoniStampatiList;
    }

}