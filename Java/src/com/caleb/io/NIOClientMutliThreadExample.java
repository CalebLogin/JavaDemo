package com.caleb.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * NIO客户端
 *
 * @author：hanzhigang
 * @Date : 2021/4/5 3:01 PM
 */
public class NIOClientMutliThreadExample {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new NIOClient());
            thread.setName("thread"+i);
            thread.start();
        }
    }

}

class NIOClient implements Runnable {

    @Override
    public void run() {
        Socket socket = null;
        try {
            Thread.sleep(100);
            socket = new Socket("127.0.0.1", 8888);
            OutputStream outputStream = socket.getOutputStream();
            String s = Thread.currentThread().getName() + "-->" + "hello world";
            outputStream.write(s.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

