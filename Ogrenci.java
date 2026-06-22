public class Ogrenci {
    public int id;
    public String adSoyad;
    public int yas;
    public String telefon;
    public String kur;
    public double not;

    public Ogrenci(int id, String adSoyad, int yas, String telefon, String kur, double not) {
        this.id = id;
        this.adSoyad = adSoyad;
        this.yas = yas;
        this.telefon = telefon;
        this.kur = kur;
        this.not = not;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + adSoyad + " | Yaş: " + yas + " | Tel: " + telefon + " | Kur: " + kur + " | Not: " + not;
    }
}
