# Ä°ngilizce Dil Kursu YÃ¶netim Sistemi

Bu proje, Nesne YÃ¶nelimli Programlama (NYP) dersi bÃ¼tÃ¼nleme sÄ±navÄ± kapsamÄ±nda Java ve JavaFX teknolojileri kullanÄ±larak geliÅŸtirilmiÅŸ bir masaÃ¼stÃ¼ uygulamasÄ±dÄ±r. Kurs yÃ¶neticilerinin Ã¶ÄŸrencileri, kurlarÄ±nÄ± ve sÄ±nav sonuÃ§larÄ±nÄ± kolayca yÃ¶netebilmesini saÄŸlar.

## ğŸš€ Ã–zellikler

*   **Yeni Ã–ÄŸrenci Ekleme**: Ã–ÄŸrencinin Ad-Soyad, YaÅŸ, Telefon, Kur (A1, A2, B1...) ve SÄ±nav Notu bilgileriyle sisteme kaydedilmesi. Her Ã¶ÄŸrenciye otomatik artan benzersiz bir ID tanÄ±mlanÄ±r.
*   **Ã–ÄŸrenci Listeleme**: KayÄ±tlÄ± tÃ¼m Ã¶ÄŸrencileri tek bir ekranda detaylÄ±ca listeleme.
*   **Ä°sim ve Kura GÃ¶re Arama**: KayÄ±tlÄ± Ã¶ÄŸrenciler arasÄ±nda isme veya kura gÃ¶re hÄ±zlÄ± arama ve filtreleme yapabilme.
*   **Ã–ÄŸrenci Silme**: Ã–ÄŸrencinin ID'si girilerek sistemden kolayca silinmesi.
*   **Kur Atlama KontrolÃ¼**:
    *   Ã–ÄŸrenci ID'si ile kur atlama hakkÄ± sorgulanÄ±r.
    *   Kur atlayabilmek iÃ§in sÄ±nav notunun en az **85** olmasÄ± gereklidir.
    *   SÄ±rasÄ±yla A1 -> A2 -> B1 -> B2 -> C1 -> C2 geÃ§iÅŸleri yapÄ±lÄ±r. C2 seviyesindeki Ã¶ÄŸrenciler iÃ§in en yÃ¼ksek seviye uyarÄ±sÄ± verilir.

## ğŸ› ï¸ KullanÄ±lan Teknolojiler

*   **Dil**: Java (JDK 21)
*   **ArayÃ¼z**: JavaFX (MasaÃ¼stÃ¼ Grafik ArayÃ¼zÃ¼)
*   **GeliÅŸtirme OrtamÄ±**: IntelliJ IDEA

## âš™ï¸ Kurulum ve Ã‡alÄ±ÅŸtÄ±rma

Projeyi sorunsuz bir ÅŸekilde Ã§alÄ±ÅŸtÄ±rmak iÃ§in aÅŸaÄŸÄ±daki adÄ±mlarÄ± izleyebilirsiniz:

1.  **Projeyi AÃ§Ä±n**: IntelliJ IDEA uygulamasÄ±nÄ± aÃ§Ä±n ve bu proje klasÃ¶rÃ¼nÃ¼ aÃ§Ä±n.
2.  **SDK AyarlarÄ±nÄ± YapÄ±n**: File -> Project Structure -> Project yolundan Java sÃ¼rÃ¼mÃ¼nÃ¼ (Ã–rn: JDK 21) seÃ§in.
3.  **KÃ¼tÃ¼phaneyi Ekleyin**: File -> Project Structure -> Libraries sekmesinden projeye dahil edilmiÅŸ olan javafx-sdk-21/lib klasÃ¶rÃ¼nÃ¼ kÃ¼tÃ¼phane olarak ekleyin.
4.  **UygulamayÄ± BaÅŸlatÄ±n**: Ek Ã§alÄ±ÅŸtÄ±rma parametreleri (VM Options) ile uÄŸraÅŸmamak iÃ§in projede yer alan **Launcher.java** dosyasÄ±nÄ± aÃ§Ä±p yeÅŸil oynatma (Run) butonuna basarak projeyi baÅŸlatabilirsiniz.

---
*GeliÅŸtirici: Elif GÃ¼ndoÄŸdu*