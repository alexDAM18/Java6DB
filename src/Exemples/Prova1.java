package Exemples;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import classesEmpleat.Adreca;
import classesEmpleat.Empleat;
import classesEmpleat.Telefon;

public class Prova1 {
    public static void main(String[] args) {
        ObjectContainer bd = Db4oEmbedded.openFile("Empleats.db4o");

        Empleat e = new Empleat("11111111a", "Albert", 10, 45, 1000, null, null, null, null, null);

        // les dades més complicades les introduïm de forma especial
        e.setAdreca(new Adreca("C/ Major, 7", "12001", "Castelló"));
        String[] corr = { "alu11111111a@ieselcaminas.org" };
        e.setCorreus_e(corr);
        Telefon[] tels = { new Telefon(true, "666777888"), new Telefon(false, "964112233") };
        e.setTelefons(tels);

        bd.store(e);

        bd.close();
    }
}