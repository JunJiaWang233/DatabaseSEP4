package org.SEP4_Data.iot_gateway_endpoint;

import lombok.Getter;
import lombok.SneakyThrows;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;
import java.util.concurrent.ExecutionException;

public class WebSocketClient extends TextWebSocketHandler {


    @Getter
    private WebSocketSession clientSession;

    public WebSocketClient() throws ExecutionException, InterruptedException {
        var webSocketClient = new StandardWebSocketClient();
        this.clientSession = webSocketClient.doHandshake(this, new WebSocketHttpHeaders(), URI.create("wss://echo.websocket.org")).get();
    } // link to IoT gateway here

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        System.out.println(message.getPayload());

        // extract the message here(or somewhere else - S from SOLID) and make new measuremntDTO, then parse it to DB
    }

    @SneakyThrows
    public static void main(String[] args) { // stuff we send to IoT so tey can invoke callback
        var sampleClient = new WebSocketClient();
        sampleClient.getClientSession().sendMessage(new TextMessage("Hello!"));
        Thread.sleep(2000);
    }

}
