import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class DilKursYonetimSistemi extends Application {

    static ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
    static int sayac = 1;

    private ListView<Ogrenci> listView = new ListView<>();
    private TextField txtAdSoyad, txtYas, txtTelefon, txtKur, txtNot, txtArama, txtSilId, txtKurAtlaId;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("İngilizce Dil Kursu Yönetim Sistemi");

        // ---- SOL PANEL: ÖĞRENCİ EKLEME FORMU ----
        VBox solPanel = new VBox(10);
        solPanel.setPadding(new Insets(10));
        solPanel.setStyle("-fx-border-color: #ccc; -fx-border-width: 0 1 0 0;");

        Label lblBaslik = new Label("YENİ ÖĞRENCİ EKLE");
        lblBaslik.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        txtAdSoyad = new TextField(); txtAdSoyad.setPromptText("Ad Soyad");
        txtYas = new TextField(); txtYas.setPromptText("Yaş");
        txtTelefon = new TextField(); txtTelefon.setPromptText("Telefon");
        txtKur = new TextField(); txtKur.setPromptText("Kur (A1, A2, B1...)");
        txtNot = new TextField(); txtNot.setPromptText("Sınav Notu");

        Button btnEkle = new Button("Öğrenci Ekle");
        btnEkle.setMaxWidth(Double.MAX_VALUE);
        btnEkle.setOnAction(e -> ogrenciEkle());

        solPanel.getChildren().addAll(lblBaslik, txtAdSoyad, txtYas, txtTelefon, txtKur, txtNot, btnEkle);

        // ---- SAĞ PANEL: LİSTELEME ----
        VBox sagPanel = new VBox(10);
        sagPanel.setPadding(new Insets(10));

        HBox aramaKutusu = new HBox(5);
        txtArama = new TextField();
        txtArama.setPromptText("İsim veya Kur Ara...");
        Button btnAra = new Button("İsimle Ara");
        Button btnKurAra = new Button("Kura Göre Listele");
        Button btnHepsiniListele = new Button("Tümünü Listele");

        btnAra.setOnAction(e -> ogrenciAra());
        btnKurAra.setOnAction(e -> kuraGoreListele());
        btnHepsiniListele.setOnAction(e -> tumOgrencileriListele());
        aramaKutusu.getChildren().addAll(txtArama, btnAra, btnKurAra, btnHepsiniListele);

        HBox islemlerKutusu = new HBox(10);

        VBox silKutusu = new VBox(5);
        txtSilId = new TextField(); txtSilId.setPromptText("Silinecek ID");
        Button btnSil = new Button("Öğrenci Sil");
        btnSil.setOnAction(e -> ogrenciSil());
        silKutusu.getChildren().addAll(txtSilId, btnSil);

        VBox kurAtlaKutusu = new VBox(5);
        txtKurAtlaId = new TextField(); txtKurAtlaId.setPromptText("Öğrenci ID");
        Button btnKurAtla = new Button("Kur Atlama Kontrolü");
        btnKurAtla.setOnAction(e -> kurAtlamaKontrol());
        kurAtlaKutusu.getChildren().addAll(txtKurAtlaId, btnKurAtla);

        islemlerKutusu.getChildren().addAll(silKutusu, kurAtlaKutusu);

        sagPanel.getChildren().addAll(aramaKutusu, listView, islemlerKutusu);

        HBox anaDuzen = new HBox(10);
        anaDuzen.getChildren().addAll(solPanel, sagPanel);

        Scene scene = new Scene(anaDuzen, 850, 480);
        primaryStage.setScene(scene);
        primaryStage.show();

        tumOgrencileriListele();
    }

    public void ogrenciEkle() {
        try {
            String ad = txtAdSoyad.getText();
            int yas = Integer.parseInt(txtYas.getText());
            String telefon = txtTelefon.getText();
            String kur = txtKur.getText().toUpperCase();
            double not = Double.parseDouble(txtNot.getText());

            Ogrenci yeni = new Ogrenci(sayac, ad, yas, telefon, kur, not);
            ogrenciler.add(yeni);
            sayac++;

            txtAdSoyad.clear(); txtYas.clear(); txtTelefon.clear(); txtKur.clear(); txtNot.clear();
            tumOgrencileriListele();
            bilgiMesaji("Başarılı", "Öğrenci başarıyla eklendi.");
        } catch (Exception e) {
            hataMesaji("Giriş Hatası", "Lütfen tüm alanları doğru doldurun!");
        }
    }

    public void tumOgrencileriListele() {
        listView.getItems().clear();
        if (!ogrenciler.isEmpty()) {
            listView.getItems().addAll(ogrenciler);
        }
    }

    public void kuraGoreListele() {
        String arananKur = txtArama.getText().toUpperCase();
        listView.getItems().clear();
        boolean bulundu = false;

        for (Ogrenci o : ogrenciler) {
            if (o.kur.equals(arananKur)) {
                listView.getItems().add(o);
                bulundu = true;
            }
        }
        if (!bulundu) {
            hataMesaji("Bilgi", "Bu kurda öğrenci bulunamadı.");
        }
    }

    public void ogrenciAra() {
        String isim = txtArama.getText().toLowerCase();
        listView.getItems().clear();
        boolean bulundu = false;

        for (Ogrenci o : ogrenciler) {
            if (o.adSoyad.toLowerCase().contains(isim)) {
                listView.getItems().add(o);
                bulundu = true;
            }
        }
        if (!bulundu) {
            hataMesaji("Bilgi", "Öğrenci bulunamadı.");
        }
    }

    public void ogrenciSil() {
        try {
            int id = Integer.parseInt(txtSilId.getText());
            boolean silindi = false;

            for (int i = 0; i < ogrenciler.size(); i++) {
                if (ogrenciler.get(i).id == id) {
                    ogrenciler.remove(i);
                    silindi = true;
                    bilgiMesaji("Başarılı", "Öğrenci silindi.");
                    txtSilId.clear();
                    break;
                }
            }
            if (!silindi) {
                hataMesaji("Hata", "ID bulunamadı.");
            }
            tumOgrencileriListele();
        } catch (Exception e) {
            hataMesaji("Hata", "Geçerli bir ID girin.");
        }
    }

    public void kurAtlamaKontrol() {
        try {
            int id = Integer.parseInt(txtKurAtlaId.getText());
            boolean bulundu = false;

            for (Ogrenci o : ogrenciler) {
                if (o.id == id) {
                    bulundu = true;
                    if (o.not >= 85) {
                        String eskiKur = o.kur;
                        switch (o.kur) {
                            case "A1": o.kur = "A2"; break;
                            case "A2": o.kur = "B1"; break;
                            case "B1": o.kur = "B2"; break;
                            case "B2": o.kur = "C1"; break;
                            case "C1": o.kur = "C2"; break;
                            case "C2":
                                bilgiMesaji("Kur Durumu", o.adSoyad + " zaten en yüksek kurda (C2).");
                                return;
                        }
                        bilgiMesaji("Tebrikler", o.adSoyad + " kur atlamaya hak kazandı!\nEski Kuru: " + eskiKur + " -> Yeni Kuru: " + o.kur);
                        txtKurAtlaId.clear();
                    } else {
                        hataMesaji("Yetersiz Not", "Kur atlamak için not en az 85 olmalı.");
                    }
                }
            }
            if (!bulundu) {
                hataMesaji("Hata", "Öğrenci bulunamadı.");
            }
            tumOgrencileriListele();
        } catch (Exception e) {
            hataMesaji("Hata", "Geçerli bir ID girin.");
        }
    }

    private void bilgiMesaji(String baslik, String icerik) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(baslik);
        alert.setHeaderText(null);
        alert.setContentText(icerik);
        alert.showAndWait();
    }

    private void hataMesaji(String baslik, String icerik) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(baslik);
        alert.setHeaderText(null);
        alert.setContentText(icerik);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}