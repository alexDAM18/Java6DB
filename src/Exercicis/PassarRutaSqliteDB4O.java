package Exercicis;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import util.bd.GestionarRutesBD;
import util.bd.Ruta;

public class PassarRutaSqliteDB4O {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ObjectContainer bd = Db4oEmbedded.openFile("Rutes.db4o");
		
		GestionarRutesBD gRutes = new GestionarRutesBD();
		ArrayList<Ruta> llista = gRutes.llistat();
		
		gRutes.close();
		
		for (Ruta r : llista) {
			bd.store(r); //insertar todo los de Ruta en Rutes.db4o que se abre con el view de OME
		}
		bd.close();
	}
}
