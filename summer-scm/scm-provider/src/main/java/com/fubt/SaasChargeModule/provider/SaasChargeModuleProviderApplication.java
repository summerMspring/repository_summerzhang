package com.fubt.SaasChargeModule.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fubt.SaasChargeModule.provider.copartner.mapper")
public class SaasChargeModuleProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaasChargeModuleProviderApplication.class,args);
    }

}
