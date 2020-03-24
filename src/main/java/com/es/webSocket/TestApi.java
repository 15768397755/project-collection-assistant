package com.es.webSocket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.net.URI;

/**
 * @MethodName:
 * @Description:
 * @Params:
 * @return:
 * @Author: yaobinbin
 * @Date: 2020-3-20
 */
@RestController
public
class TestApi {


    @GetMapping("/test")
    public void test1(){
        try {
            String url = "ws://127.0.0.1:7001/myHandler";

            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            MyClient client = new MyClient();
            container.connectToServer(client, new URI(url));
            // container.setDefaultMaxSessionIdleTimeout(5000L);
            int turn = 0;
            while (turn++ < 10) {
                client.send("client send: 客户端消息 " + turn+"|0");
                Thread.sleep(1000);
            }
//            client.onClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
