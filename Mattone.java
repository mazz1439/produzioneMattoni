
class Mattone {

    private String id;
    private String lotto;
    private float pesoKg;

    public Mattone(String codice) {
        id = codice;
        pesoKg = (float) 0.5;
    }

    public void setLotto(String l) {
        lotto = l;
    }

    public String getString() {
        return "mattone " + lotto + id + pesoKg;
    }
}
