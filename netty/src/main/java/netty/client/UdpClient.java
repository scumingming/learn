package netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;
import netty.handler.UdpClientHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangmingming on 2019/4/24.
 */
public class UdpClient {

    private static int SERVER_PORT = 6666;

    public static void main(String[] args) {


        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try{

            bootstrap.group(eventLoopGroup)
                    .channel(NioDatagramChannel.class)
                    .handler(new UdpClientHandler());

            Channel channel = bootstrap.bind(0).sync().channel();

            channel.writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer("你好,我是udb client", CharsetUtil.UTF_8),new InetSocketAddress("127.0.0.1", SERVER_PORT))
                    )
                    .sync();
            channel.closeFuture().await(1000, TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            eventLoopGroup.shutdownGracefully();
        }
    }
}
