package de.kyleonaut.webhookplugin.api.internal;

import lombok.Data;

@Data
public class WebhookServer {
    private final String key;
    private final Runnable callback;
}
