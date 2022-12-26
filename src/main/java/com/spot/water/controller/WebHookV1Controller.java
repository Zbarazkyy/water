package com.spot.water.controller;

import com.spot.water.service.bot.MdBotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebHookV1Controller {

    private final MdBotService mdBot;

    public WebHookV1Controller(MdBotService mdBot) {
        this.mdBot = mdBot;
    }

    @PostMapping(value = "/")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return mdBot.onWebhookUpdateReceived(update);
    }

    @GetMapping(value = "/")
    public String testUrl() {
        return "hello world";
    }
}
