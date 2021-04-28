package com.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {

    public static void testServer() throws IOException {
        //1.获取selector选择器
        Selector selector = Selector.open();

        //2.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //3.设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //4.绑定链接
        serverSocketChannel.bind(new InetSocketAddress(1024));

        //5.将通道注册到选择器上，并注册的操作为：“接收”操作
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6. 采用轮循的额方式，查询获取“准备就绪”的注册过的操作
        while (selector.select() > 0) {
            //7. 获取当前选择器中所有注册的选择键（“已经准备就绪的操作”）
            Iterator<SelectionKey> selectinonKeys = selector.selectedKeys().iterator();
            while (selectinonKeys.hasNext()) {
                //8.获取"准备就绪"的时间
                SelectionKey selectionKey = selectinonKeys.next();
                //9.判断key是具体的什么事件
                if (selectionKey.isAcceptable()) {
                    //10.若接收的事件是“接收就绪”操作，就获取客户断连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //11.切换为非阻塞
                    socketChannel.configureBlocking(false);
                    //12.将该通道注册到selector选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    //13.获取选择器上“读就绪”状态的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    //14.读取数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    while ((length = socketChannel.read(byteBuffer)) != -1) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, length));
                        byteBuffer.clear();
                    }
                    socketChannel.close();
                }

                //15. 移除选择器
                selectinonKeys.remove();
            }
        }
        //16.关闭连接
        serverSocketChannel.close();

    }

    public static void main(String[] args) throws IOException {
        testServer();
    }
}
