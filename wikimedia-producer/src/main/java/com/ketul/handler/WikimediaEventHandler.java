package com.ketul.handler;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaEventHandler implements EventHandler {

    private static final Logger logger = LoggerFactory.getLogger(WikimediaEventHandler.class);

    private KafkaTemplate<String, String> template;

    public WikimediaEventHandler(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        logger.info("event data : ---> {}", messageEvent.getData());

        template.send("wikimedia", messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
