package co.edu.escuelaing.arsw.tallernet.sockets;

import java.net.*;
import java.io.*;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

public class HTTPServer {
    


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
           
            while (true) {
                System.out.println("Listo para recibir...");
                clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine, outputLine;
                 String[] recursos={};
                boolean flag = true;
                while ((inputLine = in.readLine()) != null) {
                    if (flag){
                       recursos = inputLine.split(" ");
                        flag=false;
                    }
                    if (!in.ready()) {
                        break;
                    }
                }    
            EncoderFile encod =  new EncoderFile();
            if (recursos[1].contains(".JPG")){
                String img = encod.EncodeImage2("resources/"+recursos[1].substring(1));
                outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Title of the document</title>\n" + "</head>"
                    + "<body>"
                    + "My Web Site" + recursos[1]
                    + "<img src="+"data:image/jpg;base64,"+img+">"
                    + "</body>"
                    + "</html>" ;
                
            out.println(outputLine);
            out.close();
            in.close();
           
            }else if(recursos[1].contains(".html")){
                String file = encod.EncodeHtml("resources/"+recursos[1].substring(1));
                outputLine = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + file;
            out.println(outputLine);
            out.close();
            in.close();
            }else{
                outputLine = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html\r\n"
                        + "\r\n"
                        + "<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<meta charset=\"UTF-8\">"
                        + "<title>Title of the document</title>\n" + "</head>"
                        + "<body>"
                        + "My Web Site" + recursos[1]
                        + "</body>"
                        + "</html>" ;

                out.println(outputLine);
                out.close();
                in.close();
            }
           
            }
        }catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
         clientSocket.close();
         serverSocket.close();
}
    

    public static String imageReader(String path){
         try {
             System.out.println(path);
            byte[] fileContent = FileUtils.readFileToByteArray(new File(path));
            String encodedString = Base64.getEncoder().encodeToString(fileContent);
            System.out.println(encodedString);
            return encodedString;
        } catch (Exception ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
