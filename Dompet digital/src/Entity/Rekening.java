package Entity;

public class Rekening {
    protected int saldo;

    public Rekening(int saldo){
        this.saldo = saldo;
    }

    public int getSaldo (){
        return saldo;
    }
    public void setSaldo(String saldo){
        this.saldo = saldo;
    }
}
