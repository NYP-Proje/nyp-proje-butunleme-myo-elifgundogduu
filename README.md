**# İngilizce Dil Kursu Yönetim Sistemi**

Bu proje, Nesne Yönelimli Programlama (NYP) dersi bütünleme sınavı kapsamında Java ve JavaFX teknolojileri kullanılarak geliştirilmiş bir masaüstü uygulamasıdır. Kurs yöneticilerinin öğrencileri, kurlarını ve sınav sonuçlarını kolayca yönetebilmesini sağlar.

Özellikler:

**Yeni Öğrenci Ekleme:** Öğrencinin Ad-Soyad, Yaş, Telefon, Kur (A1, A2, B1...) ve sınav notu bilgileriyle sisteme kaydedilmesi. Her öğrenciye otomatik artan benzersiz bir ID atar.
**Öğrenci Listeleme:** Kayıtlı tüm öğrencileri tek bir ekranda detaylıca listeler.
**İsim ve Kura Göre Arama:** Kayıtlı öğrenciler arasında isme veya kura göre arama ve filtreleme yapar.
**Öğrenci Silme:**  Öğrencinin ID'si girilerek sistemden kolayca silinmesi.
**Kur Atlama Kontrolü:**
    *   Öğrenci ID'si ile kur atlama hakkı sorgulanır.
    *   Kur atlayabilmek için sınav notunun en az **85** olması gereklidir.
    *   Sırasıyla A1 -> A2 -> B1 -> B2 -> C1 -> C2 geçişleri yapılır. C2 seviyesindeki öğrenciler için en yüksek seviye uyarısı verilir.

**Kullanılan Teknolojiler:**

*   **Dil**: Java (JDK 21)
*   **Arayüz**: JavaFX 
*   **Geliştirilen Uygulama**: IntelliJ IDEA
