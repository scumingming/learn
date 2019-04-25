package netty.rpc.socket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import netty.handler.TcpClientHandler;

/**
 * Created by wangmingming on 2019/4/25.
 */
public class MyNettyClient {

    private int port;

    private String ip;

    private Channel channel;

    public MyNettyClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.start();
    }


    public void start() {


        Bootstrap bootstrap = new Bootstrap();
        final EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new TcpClientHandler());
                        }
                    });
            final ChannelFuture future = bootstrap.connect(ip, port).sync();
            //监听是否连接成功
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture arg0) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("连接服务器成功");

                    } else {
                        System.out.println("连接服务器失败");
                        future.cause().printStackTrace();
                        eventLoopGroup.shutdownGracefully(); //关闭线程组
                    }
                }
            });

            this.channel = future.channel();
            channel.closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }

    }


    public Channel getChannel() {
        return this.channel;
    }

}
