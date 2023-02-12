package com.ren.boot;

import com.ren.boot.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootTest
class Boot09FeaturesProfileApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private Person person;

    @Test
    public void test() {
             System.out.println("person : "+person);
    }

}
