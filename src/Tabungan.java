public class Tabungan extends Rekening implements BerBunga {
    private double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int biayaAdminBulanan() {
        // Tabungan gratis kalau saldo >= 1.000.000, selain itu Rp5.000
        if (saldo >= 1000000) {
            return 0;
        } else {
            return 5000;
        }
    }

    @Override
    public void tambahBunga() {
        int bunga = (int) (saldo * (bungaPersen / 100.0));
        saldo += bunga;
    }
}