package com.ren.admin.endpoion;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @program: SpringbootCode
 * @author: Ren  https://github.com/machsh64
 * @create: 2023-02-10 19:33
 * @description:
 **/
@Component
@Endpoint(id = "myservice")
public class MyServiceEndPoint {

    @ReadOperation
    public Map<String, Object> getDockerInfo(){
        // 端点的读操作 http://localhost:8080/actuator/myservice
        return Collections.singletonMap("dockerInfo","docker started ...");
    }

    @WriteOperation
    public void stopDocker(){
        System.out.println("docker Stopped");
    }
}
