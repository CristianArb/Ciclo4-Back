package com.segioarboleda.divinacomedia;

import com.segioarboleda.divinacomedia.app.repositories.crud.HairProductCrudRepository;
import com.segioarboleda.divinacomedia.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.segioarboleda.divinacomedia.app.repositories.crud.OrderCrudRepositiry;

@SpringBootApplication
public class DivinacomediaApplication implements CommandLineRunner {
    
    @Autowired
    private UserCrudRepository userRepository;
    
    @Autowired
    private HairProductCrudRepository productRepository;
    
    @Autowired
    private OrderCrudRepositiry orderRepository;

    

    public static void main(String[] args) {
        SpringApplication.run(DivinacomediaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        userRepository.deleteAll();
        orderRepository.deleteAll();
    }
}
