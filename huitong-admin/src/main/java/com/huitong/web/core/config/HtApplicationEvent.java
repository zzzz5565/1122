package com.huitong.web.core.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class HtApplicationEvent implements ApplicationListener<WebServerInitializedEvent> {

    private int serverPort;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) { 
        this.serverPort = event.getWebServer().getPort();
    }

    public int getPort() {
        return this.serverPort;
    }
}