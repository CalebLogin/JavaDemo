import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author：hanzhigang
 * @Date : 2021/4/12 3:37 PM
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        // 创建EventLoopGroup
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            // 创建ServerBootStrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    .channel(NioServerSocketChannel.class)  // 指定使用NIO的传输Channel
                    .localAddress(new InetSocketAddress(port))  // 设置socket地址使用的所选的端口，添加EchoServerHandler到Channel的ChannelPipeline
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            ChannelFuture f = b.bind().sync();  // 异步地绑定服务器；调用sync()方法阻塞等待直到绑定完成
            System.out.println(EchoServer.class.getName() + " started and listen on" + f.channel().localAddress());
            f.channel().closeFuture().sync();   // 获取Channel的CloseFuture，并且阻塞当前线程直到它完成
        } finally {
            group.shutdownGracefully().sync();  // 关闭EventLoopGroup，释放所有资源

        }

    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: " + EchoServer.class.getSimpleName() + "<port>");
            return;
        }
        // 设置一个端口值
        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }

}
