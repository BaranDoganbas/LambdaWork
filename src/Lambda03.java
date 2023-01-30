import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trileçe", "havucDilim", "güvec", "kokorec",
                "küşleme", "arabAşı", "waffle", "künefe"));

        alfBykTekrariz(menu);
        System.out.println();
        chrSayisiTersYazdir(menu);
        System.out.println();
        chrSayisiBykYazdir(menu);
        System.out.println();
        harfSayisi7denAzKontrol(menu);
    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrariz(List<String> yemek) {
        yemek.
                stream(). // Akış başladı
                map(String::toUpperCase). // Büyük harf
                sorted(). // Natural Order
                distinct(). // Elemanların tekrarsız olmasını sağladı
                forEach(t -> System.out.print(t + " ")); // print

    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersYazdir(List<String> ikram) {
        ikram.
                stream(). // akış alındı
                map(String::length). // Akışı güncelledim, kelimelerin uzunluğu olarak
                sorted(Comparator.reverseOrder()). // ters sıralı
                distinct(). // tekrarsız
                forEach(Lambda01::yazdir); // print
    }

    // Task-3 : List elemanlarini, character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBykYazdir(List<String> ikram) {
        ikram.
                stream(). // akış sağlandı
                sorted(Comparator.comparing(String::length)). // string ifadeleri karakter sayısına göre küçükten büyüğe göre sıraladım
                forEach(Lambda01::yazdir); // print
    }
    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfSayisi7denAzKontrol(List<String> ikram) {
        System.out.printf(ikram.
                stream().
                allMatch(t -> t.length() <= 7) ? "List elemanları 7 ve daha az harften oluşuyor" :
                "List elemanları 7 harften fazla");
    }
    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> ikram) {
        System.out.println(ikram.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile yemek ismi mi olur" :
                "w ile yemek icat ettik");
    }
    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBitenElKontrol(List<String> ikram) {
        System.out.println(ikram.stream().anyMatch(t -> t.endsWith("x")) ? "maşallah" : "x ile yemek ismi mi biter");
    }
    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiEnBykElPrint(List<String> ikram){
        Stream<String> sonIsim = ikram.
                stream(). // akış sağlandı
                        sorted(Comparator.comparing(t->t.toString().length()).
                        reversed()). // karakter sayısına göre terden sıralandı
                        limit(1);// limit metodu kullanılarak sadece ilk eleman çağrıldı
        // limit() metodunun dönen değeri Stream<String> yapıdadır

        System.out.println(Arrays.toString(sonIsim.toArray()));
        // sonIsim.toArray() --> Stream olan akış Artray e çevrildi
        // Arrays.toString(sonIsim.toArray()) --> Arrayı string yapıya çeviriyor
    }
    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHrcSonHrfSiraliPrint(List<String> ikram){
        ikram.
                stream(). // akış sağlandı
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). // son harfine göre alfabetik sıralandı
                skip(1). // akışdaki ilk eleman hariç tutuldu
                forEach(Lambda01::yazdir); // ekrana print edildi
    }

}
