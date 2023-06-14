package de.kyleonaut.webhookplugin.handler;

import de.kyleonaut.webhookplugin.api.internal.WebhookServer;

import static spark.Spark.post;

public class InternalWebhookHandler {
    public static void register(WebhookServer webhookServer) {
        post("/" + webhookServer.getKey(), ((request, response) -> {
            webhookServer.getCallback().run();
            return 200;
        }));
    }

}
