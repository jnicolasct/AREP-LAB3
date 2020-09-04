package edu.escuelaing.AREP.httpServer;

import Persistence.MongoDB;

import java.io.IOException;

public class App {

    /**
     * Metodo main que crea un servido de la clase HttpServer
     * @param args necesarios en metodo main
     * @throws IOException debido al menejo de archivos en HttpServer
     */
    public static void main(String[] args) throws IOException {
        MongoDB db = new MongoDB();
        HttpServer server = new HttpServer(db);
        server.start();
    }
}
