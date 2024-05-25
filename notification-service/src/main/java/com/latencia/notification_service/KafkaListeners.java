package com.latencia.notification_service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class KafkaListeners {
    

    @KafkaListener(topics = "mensaje", groupId = "groupId")
    void listener(String data){
        System.out.println("Listener received: " + data + " uwu");
        PublishOtp publisher = new PublishOtp();
        publisher.publish(data);
    }


   
}
