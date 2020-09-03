package edu.escuelaing.AREP.httpServer;

import java.net.*;
import java.io.*;
import java.util.Base64;

public class HttpServer {

    public HttpServer() {

    };

    public void start() throws IOException {
        ServerSocket serverSocket = null;
        String[] path = null;
        boolean activo = false;
        String encabezado = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n";
        String dHtml =
                "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Title of the document</title>\n"
                + "</head>\n"
                + "<body>\n";
        String fDHtml = "</body>\n"
                + "</html>\n";

        try {
            serverSocket = new ServerSocket(36000);
            activo = true;
        } catch (IOException e) {
            System.err.println("Could not listen on port: 36000.");
            System.exit(1);
        }
        while (activo) {
            Socket clientSocket = null;
            try {

                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(
                    clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            if ((inputLine = in.readLine()) != null) {
                path = inputLine.split("/");
            }
            if (path != null) {
                if (path[1].contains(".html")) {
                    String docHtml = manageHtml();
                    outputLine = encabezado + docHtml;
                }
                else if (path[1].contains(".js")) {
                    String docJScript = manageJSript();
                    outputLine =
                            encabezado
                            + dHtml
                            + "<h1>Este es un documento JavaScript</h1>\n"
                            + "<script>\n"
                            + docJScript
                            + "</script>\n"
                            + "<button type='button' onclick ='boton()'>Ver author </button>\n"
                            + fDHtml;
                }else if (path[1].contains(".jpg") || path[1].contains(".JPG") || path[1].contains(".png") || path[1].contains(".PNG")) {
                    String docImg = manageImg();
                    outputLine = encabezado + dHtml
                            + "<h1>Este es una imagen</h1>\n"
                            + "<img src="
                            + "data:image/jpg;base64,"
                            + docImg
                            + ">"
                            + fDHtml;
                }else {
                    outputLine = encabezado
                            + dHtml
                            + "<h1>Mi propio mensaje</h1>\n"
                            + fDHtml;
                }
            } else {
                outputLine = encabezado
                        + dHtml
                        + "<h1>Mi propio mensaje</h1>\n"
                        + fDHtml;
            }

            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    private static String manageImg() throws IOException {
        String resultOutput;
        File archivo = new File ("src/main/resources/imagen.JPG");
        FileInputStream fIS = new FileInputStream (archivo);
        byte[] imageByte = new byte[(int)archivo.length()];
        fIS.read(imageByte);
        resultOutput = Base64.getEncoder().encodeToString(imageByte).toString();
        return resultOutput;
    }

    private static String manageJSript() throws IOException {
        String resultOutput = "";
        File archivo = new File ("src/main/resources/prueba2.js");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        while (linea != null){
            resultOutput = resultOutput + linea;
            linea = br.readLine();
        }
        return resultOutput;

    }

    private static String manageHtml() throws IOException {
        String resultOutput = "";
        File archivo = new File ("src/main/resources/prueba.html");
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        while (linea != null){
            resultOutput = resultOutput + linea;
            linea = br.readLine();
        }
        return resultOutput;
    }
}
