package Exemples;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import classesEmpleat.Empleat;

public class Prova6 {

    public static void main(String[] args) {
        ObjectContainer bd = Db4oEmbedded.openFile("Empleats.db4o");

        Empleat e = new Empleat("11111111a");
        ObjectSet<Empleat> llista = bd.queryByExample(e);
        if (llista.hasNext()) {
            e = llista.next();
            e.setSou(e.getSou() + 200);

            bd.close(); // Tanquem i tornem a obrir la BD, per veure que hem
                        // perdut la correspondència de e amb l'objecte de la BD
            bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "Empleats.db4o");

            bd.store(e);
            
            //Se empastrará y tendremos un duplicado de este usuario
        }
        bd.close();
    }
}