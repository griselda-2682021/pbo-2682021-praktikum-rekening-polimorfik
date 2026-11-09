public class BankPolimorfik {
    public static void main(String[] args) {
        // Ketentuan: Tulis new Rekening(...) di main, lalu jadikan komentar untuk melihat pesan error-nya
        // Rekening r = new Rekening("999", "Test", 10000); // Error karena Rekening abstract

        // Data sesuai soal:
        // Tabungan 101: Ani, saldo 1.000.000, bunga 2.5%
        // Tabungan 102: Citra, saldo 300.000, bunga 2.0%
        // Giro 201: Budi, saldo 200.000, batas overdraft 500.000

        Rekening[] semua = {
                new Tabungan("101", "Ani", 1000000, 2.5),
                new Tabungan("102", "Citra", 300000, 2.0),
                new Giro("201", "Budi", 200000, 500000)
        };

        BerBunga[] berbunga = {
                (Tabungan) semua[0],
                (Tabungan) semua[1]
        };

        System.out.println("=== KONDISI AWAL ===");
        for (Rekening r : semua) {
            r.cetakInfo();
        }

        // Urutan akhir bulan: potong biaya admin semua rekening
        for (Rekening r : semua) {
            r.potongBiayaAdmin();
        }

        // Tambahkan bunga untuk rekening yang berbunga
        for (BerBunga b : berbunga) {
            b.tambahBunga();
        }

        System.out.println("\n=== SALDO AKHIR BULAN (SETELAH ADMIN & BUNGA) ===");
        int totalDanaBank = 0;
        for (Rekening r : semua) {
            r.cetakInfo();
            totalDanaBank += r.getSaldo();
        }

        System.out.println("----------------------------------------");
        System.out.println("Total Dana Bank Keseluruhan: Rp " + java.text.NumberFormat.getInstance(new java.util.Locale("id", "ID")).format(totalDanaBank));
    }
}