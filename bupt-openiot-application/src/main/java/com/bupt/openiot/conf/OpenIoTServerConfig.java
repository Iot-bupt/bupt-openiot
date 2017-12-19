package com.bupt.openiot.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dy on 2017/6/5.
 */
@Configuration
@ConfigurationProperties(prefix = "bupt.openiot")
public class OpenIoTServerConfig {

    // OpenIoT接入平台IP域名及端口号
    private String server;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Override
    public String toString() {
        return "OpenIoTServerConfig{" +
                "server='" + server + '\'' +
                '}';
    }
}
