package Exemples;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import classesEmpleat.Empleat;

public class Prova2 {
    public static void main(String[] args) {
        ObjectContainer bd = Db4oEmbedded.openFile("Empleats.db4o");
        Empleat e = null;

        ObjectSet<Empleat> llista = bd.queryByExample(new Empleat("11111111a"));

        if (llista.hasNext()) {
            e = llista.next();
            System.out.println("Nif: " + e.getNif() + ". Nom: " + e.getNom() + ". Població: " + e.getAdreca().getPoblacio());
            System.out.println("Primer correu: " + e.getCorreus_e()[0] + ". Primer telèfon: " + e.getTelefons()[0].getNumero());
        }
        bd.close();
    }
}