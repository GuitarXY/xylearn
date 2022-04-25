//package com.example.xylearn.netty;
//
//import io.netty.bootstrap.Bootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelFutureListener;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioSocketChannel;
//
///**
// * @author xiaoy
// * @date 2022/1/12
// */
//public class MyClient {
//
//    public static void main(String[] args) throws Exception {
//        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
//        try {
//            //创建bootstrap对象，配置参数
//            //Bootstrap和ServerBootStrap是Netty提供的一个创建客户端和服务端启动器的工厂类，
//            // 使用这个工厂类非常便利地创建启动类，根据上面的一些例子，其实也看得出来能大大地减少了开发的难度
//            Bootstrap bootstrap = new Bootstrap();
//            //设置线程组
//            bootstrap.group(eventExecutors)
//                    //设置客户端的通道实现类型
////                  //一种连接到网络套接字或能进行读、写、连接和绑定等I/O操作的组件。
//                    .channel(NioSocketChannel.class)
//                    //使用匿名内部类初始化通道
//                    .handler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        protected void initChannel(SocketChannel ch) throws Exception {
//                            //添加客户端通道的处理器
//                            ch.pipeline().addLast(new MyClientHandler());
//                        }
//                    });
//            System.out.println("客户端准备就绪，随时可以起飞~");
//            //连接服务端
//            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6666).sync();
//            //对通道关闭进行监听
//            /**
//             * ChannelFuture提供操作完成时一种异步通知的方式。一般在Socket编程中，
//             * 等待响应结果都是同步阻塞的，而Netty则不会造成阻塞，
//             * 因为ChannelFuture是采取类似观察者模式的形式进行获取结果
//             */
//            channelFuture.addListener(new ChannelFutureListener() {
//                //使用匿名内部类，ChannelFutureListener接口
//                //重写operationComplete方法
//                @Override
//                public void operationComplete(ChannelFuture future) throws Exception {
//                    //判断是否操作成功
//                    if (future.isSuccess()) {
//                        System.out.println("连接成功");
//                    } else {
//                        System.out.println("连接失败");
//                    }
//                }
//            });
//            channelFuture.channel().closeFuture().sync();
//        } finally {
//            //关闭线程组
//            eventExecutors.shutdownGracefully();
//        }
//    }
//}
