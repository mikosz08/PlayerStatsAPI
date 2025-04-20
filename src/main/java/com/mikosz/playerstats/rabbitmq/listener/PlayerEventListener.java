package com.mikosz.playerstats.rabbitmq.listener;

import com.mikosz.playerstats.model.PlayerCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PlayerEventListener {

    @RabbitListener(queues = "${player.queue.name}")
    public void handlePlayerCreatedEvent(PlayerCreatedEvent event) {
        System.out.println("🎉 Received event: " + event);
    }
}
