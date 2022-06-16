package com.ketul.config;

import com.ketul.entity.User;
import com.ketul.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerConfig {
    private Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @Autowired
    private UserRepository userRepository;

    @KafkaListener(topics = "wikimedia", groupId = "myGroup")
    public void consume(String s) {
        logger.info("Received stream ---> {}", s);

        User user = new User();
        user.setConsumedData(s);
        userRepository.save(user);
    }
}
