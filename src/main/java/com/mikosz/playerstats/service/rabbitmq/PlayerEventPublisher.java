package com.mikosz.playerstats.service.rabbitmq;

import com.mikosz.playerstats.model.PlayerCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${player.queue.name}")
    private String queueName;

    public void publish(PlayerCreatedEvent event) {
        System.out.println("Publishing PlayerCreatedEvent: " + event);
        rabbitTemplate.convertAndSend(queueName, event);
    }
}
