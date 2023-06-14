package de.kyleonaut.webhookplugin.api;

import de.kyleonaut.webhookplugin.api.internal.WebhookServer;
import de.kyleonaut.webhookplugin.handler.InternalWebhookHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WebhookServerBuilder {
    private static WebhookServerBuilder INSTANCE;
    private String key;
    private Runnable callback;

    public static WebhookServerBuilder builder() {
        if (INSTANCE == null) {
            INSTANCE = new WebhookServerBuilder();
        }
        return INSTANCE;
    }

    public WebhookServerBuilder key(String key) {
        this.key = key;
        return this;
    }

    public WebhookServerBuilder handle(Runnable callback) {
        this.callback = callback;
        return this;
    }

    public void register() {
        InternalWebhookHandler.register(new WebhookServer(this.key, this.callback));
    }

}
