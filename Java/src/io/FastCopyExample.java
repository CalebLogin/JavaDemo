package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO快速复制文件的demo
 *
 * @author：hanzhigang
 * @Date : 2021/4/5 2:16 PM
 */
public class FastCopyExample {

    public static void fastCopy(String src, String dist) throws IOException {

        // 获得源文件的输入字节流
        FileInputStream fin = new FileInputStream(src);

        // 获得输入字节流的文件通道
        FileChannel fcin = fin.getChannel();

        // 获得目标文件的输出字节流
        FileOutputStream fout = new FileOutputStream(dist);

        // 获得输出字节流的文件通道
        FileChannel fcout = fout.getChannel();

        // 为缓冲区分配1024个字节
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        while (true) {

            // 从输入通道中读取数据到缓冲区中
            int r = fcin.read(byteBuffer);

            // read() 返回-1表示EOF
            if(r == -1){
                break;
            }

            // 切换读写
            byteBuffer.flip();

            // 缓冲区的内容写入目标文件中
            fcout.write(byteBuffer);

            // 清空缓冲区
            byteBuffer.clear();
        }

    }

}
