package Persistence;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class MongoDB {

    private MongoCollection collection;
    private MongoDatabase db;

    /**
     * Costructor de la clase, que permita crear la coneccion a la base de datos, Mongo
     */
    public MongoDB(){
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://johancortes:cortesarep@cluster0.axuan.mongodb.net/areplab3?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        db = mongoClient.getDatabase("areplab3");
        collection = db.getCollection("areplab3");
    }

    /**
     * Metodo que agrega documentos a la base de datos mongo
     */
    public void add(){
        Document object = new Document();
        object.append("nombre","sirve1");
        object.append("edad",21);
        object.append("Carrera","ISIS");
        collection.insertOne(object);
    }

    /**
     * Metodo que retorna los documentos que existen en a base de datos
     * @return Lsita de los documentos que se encuetran en la base de datos
     */
    public String select(){
        FindIterable<Document> registros = collection.find();
        String datos = "";
        for (Document r : registros){
            datos+= "\n"+r.toJson();
        }


        return datos;
    }




}
