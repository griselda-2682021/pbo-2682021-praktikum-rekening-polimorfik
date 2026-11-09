public class Giro extends Rekening {
    private int batasOverdraft;

    public Giro(String nomor, String pemilik, int saldo, int batasOverdraft) {
        super(nomor, pemilik, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public int biayaAdminBulanan() {
        return 15000; // Giro selalu Rp15.000
    }

    @Override
    public boolean tarik(int jumlah) {
        // Giro memperbolehkan tarik melebihi saldo selama masih dalam batas overdraft
        if (jumlah <= 0 || (saldo - jumlah) < -batasOverdraft) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }
}