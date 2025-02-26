package com.example.covidtracking2.Persistencia.Persistencia;

import com.example.covidtracking2.Entidades.Firebase.Firebase.Mensaje;
import com.example.covidtracking2.Utilidades.Constantes;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MensajeriaDAO {

    private static com.example.covidtracking2.Persistencia.Persistencia.MensajeriaDAO mensajeriaDAO;

    private FirebaseDatabase database;
    private DatabaseReference referenceMensajeria;

    public static com.example.covidtracking2.Persistencia.Persistencia.MensajeriaDAO getInstancia(){
        if(mensajeriaDAO==null) mensajeriaDAO = new com.example.covidtracking2.Persistencia.Persistencia.MensajeriaDAO();
        return mensajeriaDAO;
    }

    private MensajeriaDAO(){
        database = FirebaseDatabase.getInstance();
        referenceMensajeria = database.getReference(Constantes.NODO_MENSAJES);
        //storage = FirebaseStorage.getInstance();
        //referenceUsuarios = database.getReference(Constantes.NODO_USUARIOS);
        //referenceFotoDePerfil = storage.getReference("Fotos/FotoPerfil/"+getKeyUsuario());
    }

    public void nuevoMensaje(String keyEmisor, String keyReceptor, Mensaje mensaje){
        DatabaseReference referenceEmisor = referenceMensajeria.child(keyEmisor).child(keyReceptor);
        DatabaseReference referenceReceptor = referenceMensajeria.child(keyReceptor).child(keyEmisor);
        referenceEmisor.push().setValue(mensaje);
        referenceReceptor.push().setValue(mensaje);
    }

}
