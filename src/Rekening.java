public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo; // protected agar dapat diakses subclass

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getPemilik() {
        return pemilik;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) return false;
        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) return false;
        saldo -= jumlah;
        return true;
    }

    // Method abstract untuk biaya admin bulanan
    public abstract int biayaAdminBulanan();

    // Method konkret potongBiayaAdmin yang memanggil biayaAdminBulanan()
    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    protected String formatRupiah(int nominal) {
        java.text.NumberFormat formatRupiah = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("id", "ID"));
        return formatRupiah.format(nominal).replace("Rp", "Rp ");
    }

    public void cetakInfo() {
        System.out.println(nomor + " | " + pemilik + " | " + formatRupiah(saldo));
    }
}