package netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import netty.handler.TcpClientHandler;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangmingming on 2019/4/24.
 */
public class TcpClient {

    private static final int SERVER_PORT = 7777;

    private static Channel channel;

    public static void main(String[] args) {

        Bootstrap bootstrap = new Bootstrap();
        final EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
//                            pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
//                            pipeline.addLast(new LengthFieldPrepender(4));
                            pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new TcpClientHandler());
                        }
                    });
            final ChannelFuture future = bootstrap.connect("127.0.0.1", SERVER_PORT).sync();
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


            channel = future.channel();
            channel.writeAndFlush("hello,我是tcp client");

            //监听server close后执行后面的代码,
            channel.closeFuture().sync();
            //channel需要在server writeAndFlush到client之前保持开启状态,否则server报异常
//            Thread.sleep(1000L);
            System.out.println("server close");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }

    }

}
