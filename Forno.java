
import java.util.ArrayList;

class Forno {

    private static final int CAPIENZA_MATTONI = 400;
    private int num_mattoni = 0;
    private ArrayList<Mattone> mattoniDaCuocereList = new ArrayList<Mattone>();
    private boolean isInCottura = false;

    public synchronized String Inforna(ArrayList<Mattone> mattoniStampatiList, int codiceRullo) throws InterruptedException {
        while (isInCottura) {
            wait();
        }
        if (mattoniDaCuocereList.size() <= 200) {
            ArrayList<Mattone> listaMattAggiornata = new ArrayList<Mattone>();
            listaMattAggiornata.addAll(mattoniDaCuocereList);
            listaMattAggiornata.addAll(mattoniStampatiList);
            mattoniDaCuocereList = listaMattAggiornata;
        }
        String m = "rullo " + codiceRullo + " ha infornato 200 mattoni";
        System.out.println(m);
        return m;
    }

    public synchronized String Cuoci() {
        String m = "";
        if (mattoniDaCuocereList.size() >= CAPIENZA_MATTONI) {
            isInCottura = true;
            m = "sto cuocendo " + CAPIENZA_MATTONI + " mattoni";
            mattoniDaCuocereList = new ArrayList<Mattone>();
            isInCottura = false;
            notifyAll();
        }
        System.out.println(m);
        return m;
    }

}
