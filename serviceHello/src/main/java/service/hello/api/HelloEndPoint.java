package service.hello.api;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloEndPoint {
    //log
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;
    @Value("${server.port}")
    private int serverPort = 0;


    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
        logger.info("/hello,instanceId:{},host:{}",eurekaInstanceConfig.getInstanceId(),eurekaInstanceConfig.getHostName(false));
        return "Hello,SpringCloud! My port is " + String.valueOf(serverPort);

    }

}
