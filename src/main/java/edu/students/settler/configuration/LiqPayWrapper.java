package edu.students.settler.configuration;

import com.liqpay.LiqPay;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class LiqPayWrapper {

    private LiqPay liqPay;
    private String publicKey;
}
