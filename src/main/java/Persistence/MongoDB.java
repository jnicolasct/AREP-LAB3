package Persistence;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class MongoDB {

    private MongoCollection collection;
    private MongoDatabase db;

    public MongoDB(){
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://johancortes:cortesarep@cluster0.axuan.mongodb.net/areplab3?retryWrites=true&w=majority");
        MongoClient mongoClient = new MongoClient(uri);
        db = mongoClient.getDatabase("areplab3");
        collection = db.getCollection("areplab3");
    }

    public void add(){
        Document object = new Document();
        object.append("nombre","sirve1");
        object.append("edad",21);
        object.append("Carrera","ISIS");
        collection.insertOne(object);
    }

    public ArrayList<Document> select(){
        ArrayList<Document> registros = new ArrayList<Document>();
        ArrayList<String> registrosNuevos = new ArrayList<String>();
        for (Document d:registros){

        }


        return registros;
    }




}
