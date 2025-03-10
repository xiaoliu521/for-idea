package org.example.alg;

import java.io.*;
import java.net.Socket;
 
public class Client {
    public static void main(String[] args) {
        try {
            // 创建Socket对象，指定服务端的IP地址和端口号
            Socket socket = new Socket("127.0.0.1", 12345);
//            Socket socket = new Socket("192.168.16.151", 12345);

            InputStream inputStream = socket.getInputStream();




            // 从控制台读取用户输入
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String message;
 
            while (true) {
                System.out.println("请输入要发送的信息（输入 'exit' 退出）：");
                message = reader.readLine();
 
                if (message.equalsIgnoreCase("exit")) {
                    // 如果用户输入 'exit'，发送终止标志给服务端并退出循环
                    break;
                }
                OutputStream outputStream = socket.getOutputStream();
                System.out.println("asdasd");
                outputStream.write(message.getBytes()); // 发送数据到服务器
                outputStream.flush(); // 刷新输出流
                //添加关闭socket 输出流
//                socket.shutdownOutput();

                // 读取服务器的响应
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String response = new String(buffer, 0, bytesRead);
                System.out.println("Server response: " + response);
                // 将用户输入的信息发送给服务端

            }
 
            // 关闭连接
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}