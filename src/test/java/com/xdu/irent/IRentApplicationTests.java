package com.xdu.irent;

import com.xdu.irent.pojo.Renter;
import com.xdu.irent.service.RenterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IRentApplicationTests {

    @Autowired
    private RenterService renterService;
    @Test
    void contextLoads() {
    }

    @Test
    void login(){
        Renter ren = renterService.findRenterByUsernameAndPassword("admin", "admin");
        System.out.println(ren);

    }

}
