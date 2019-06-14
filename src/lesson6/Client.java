package lesson6;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8777)) {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream (outputStream);
            DataInputStream dataInputStream = new DataInputStream (inputStream);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Клиент активен.");
            readClient(dataInputStream);
            writeClient(dataOutputStream, scanner);
            closeClient(socket, inputStream, outputStream, scanner);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void closeClient(Socket socket, InputStream inputStream, OutputStream outputStream, Scanner scanner) throws IOException {
        inputStream.close();
        outputStream.close();
        socket.close();
        scanner.close();
    }


    private static void writeClient(DataOutputStream dataOutputStream, Scanner scanner) throws IOException {
        while (true) {
            System.out.print("Отправить сообщение на Сервер:: ");
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("/end")) {
                break;
            }
            dataOutputStream.writeUTF(message);
        }
    }

    private static void readClient (DataInputStream dataInputStream) throws InterruptedException {
       Thread thread = new Thread(new Runnable() {
           @Override
           public void run() {
               while (true) {
                   try {
                       String message = dataInputStream.readUTF();
                       Date date = new Date();
                       System.out.println("SERVER [" + date + "] :: " + message);
                   } catch (IOException e) {

                       e.printStackTrace();
                       System.out.println("Соедиение с Сервером разорвано.--> /end для закрытия Клиента.");
                       break;
                   }
               }

           }
       });
        thread.setDaemon(true);
        thread.start();

    }

}

