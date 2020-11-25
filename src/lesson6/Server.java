package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8777)) {
            System.out.println("Сервер " + serverSocket.isBound());
            Socket socket = serverSocket.accept();
            System.out.println(socket.toString() + "------" + socket.isConnected() );
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            Scanner scanner = new Scanner(System.in);

            readServer(dataInputStream);

            writeServer(dataOutputStream, scanner);

            closeServer(serverSocket, socket, inputStream, outputStream, scanner);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void closeServer(ServerSocket serverSocket, Socket socket, InputStream inputStream,
                                    OutputStream outputStream, Scanner scanner) throws IOException {
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        scanner.close();
    }

    private static void writeServer(DataOutputStream dataOutputStream, Scanner scanner) throws IOException {
        while (true) {
            System.out.print("Отправить сообщение на Клиент:: ");
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("/end")){
                break;
            }
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        }
    }

    private static void readServer(DataInputStream dataInputStream) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String message = dataInputStream.readUTF();
                        Date date = new Date();
                        System.out.println("\nCLIENT [" + date + "] :: " + message);
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Соединение с клиентом разорвано. /end -- для закрытия Сервера. ");
                        break;
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }


}




