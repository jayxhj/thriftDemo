package service.demo;

import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class HelloServer {
    public static void main(String[] args) {
        try {
            int port = 6666;
            TServerSocket serverTransport = new TServerSocket(port);
            // 关联处理器与 Hello 服务的实现
            TProcessor processor = new Hello.Processor(new HelloServiceImpl());
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));

            System.out.println(String.format("Start server on port:%s ...", port));
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
