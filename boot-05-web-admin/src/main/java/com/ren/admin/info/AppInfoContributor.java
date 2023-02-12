package com.ren.admin.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-10 19:23
 * @description:
 **/
@Component
public class AppInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {

        builder.withDetail("message", "你好 我是Info")
                .withDetail("hello", "ren")
                .withDetails(Collections.singletonMap("word", 666666));
    }
}
