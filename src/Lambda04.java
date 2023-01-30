import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
   TASK :
   fields --> Universite (String)
              bolum (String)
              ogrcSayisi (int)
              notOrt (int)
              olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
    */
    public static void main(String[] args) {
        University u01 = new University("bogazici", "matematik", 571, 93);
        University u02 = new University("istanbul tk", "matematik", 600, 81);
        University u03 = new University("istanbul", "hukuk", 1400, 71);
        University u04 = new University("marmara", "bilg muh", 1080, 77);
        University u05 = new University("odtu", "gemi mh", 333, 74);
        List<University> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));
        System.out.println(notOrt74BykUni(unv));
        System.out.println();
        System.out.println(matBolumVarMi(unv));
    }

    //task 01--> bütün ünv. lerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUni(List<University> unv) {
        return unv.
                stream(). // akış sağladık üniversiteler u01, u02, u03, u04, u05
                allMatch(t->t.getNotOrt()<74);
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<University> unv) {
        return unv.
                stream(). // akış sağlandı
                anyMatch(t->t.getBolum(). // objelerin bölüm isimleri alındı
                        toLowerCase(). // bölüm isimlerindeki karakterler küçük harfe çevrildi
                        contains("mat")); // mat kelimesi var mı kontrol
    }
    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<University> ogrSayisiBykSirala(List<University> unv) {
        return unv.
                stream(). // akış sağlandı
                        sorted(Comparator.comparing(University::getOgrSayisi).reversed()).
                // universiteler öğrenci sayısına göre terden sıralandı
                        collect(Collectors.toList()); // Stream yapısı List yapısına dönüştürüldü
    }

}