package com.spot.water.config;

import com.spot.water.service.bot.MdBotService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Configuration
@EnableScheduling
public class AppConfig {
    @Value("${telegram.bot-proxy-host}")
    private String host;
    @Value("${telegram.bot-proxy-port}")
    private Integer port;

    @Bean
    public MdBotService getMdBot() {
        DefaultBotOptions options = new DefaultBotOptions();
        options.setProxyType(DefaultBotOptions.ProxyType.SOCKS4);
        options.setProxyHost(host);
        options.setProxyPort(port);
        return new MdBotService(options);
    }
}
