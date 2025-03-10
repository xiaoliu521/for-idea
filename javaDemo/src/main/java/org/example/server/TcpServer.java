package org.example.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xianr
 * @date 2023-11-24
 * @Description TODO
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {
        int port = 12345; // 监听的端口号
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept(); // 接受客户端连接请求
            // 创建一个新的线程来处理客户端请求
            Thread clientThread = new ClientThread(clientSocket);
            clientThread.start();
        }
    }
}
