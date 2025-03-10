package org.example.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class ClientThread extends Thread  {
    private Socket clientSocket;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // 获取输入流和输出流
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // 处理客户端请求
            // 例如，读取客户端发送的数据并返回响应
            byte[] buffer = new byte[1024];
            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
            while (true) {
                bytesRead = inputStream.read(buffer);
                String request = new String(buffer, 0, bytesRead);
                System.out.println(request);
                String response = "Server response: " + request;
                outputStream.write(response.getBytes());
            }
//            // 关闭连接
//            clientSocket.close();
        } catch (IOException e) {
            try {
                clientSocket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();

        }
    }
}