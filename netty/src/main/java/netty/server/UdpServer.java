package netty.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import netty.handler.UdpServerHandler;

/**
 * Created by wangmingming
 */
public class UdpServer {

    private static int PROT = 6666;

    public static void main(String[] args) {

        try {
            Bootstrap bootstrap = new Bootstrap();

            EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

            bootstrap.group(eventLoopGroup)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new UdpServerHandler());
            bootstrap.bind(PROT).sync().channel().closeFuture().await();
            System.out.println("x");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
