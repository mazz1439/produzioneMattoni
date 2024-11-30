
class Impastatore {

    private int codImpastatore;

    Impastatore(int codiceThreadProduttore) {
        codImpastatore = codiceThreadProduttore;
    }

    public String Impasta() {
        return "mescolata malta per 200 mattoni dall'impastatore " + codImpastatore;
    }
}
