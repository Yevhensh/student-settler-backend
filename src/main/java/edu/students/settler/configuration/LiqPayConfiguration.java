package edu.students.settler.configuration;

import com.liqpay.LiqPay;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LiqPayConfiguration {

    @Bean
    LiqPayWrapper getLiqPayWrapper(@Value("${liqpay.publickey}") String publicKey,
                                   @Value("${liqpay.privatekey}") String privateKey) {
        LiqPayWrapper wrapper = new LiqPayWrapper();
        wrapper.setLiqPay(new LiqPay(publicKey, privateKey));
        wrapper.setPublicKey(publicKey);

        return wrapper;
    }
}
