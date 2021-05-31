package springcloud.com.flytodream.controller;

import com.flytodream.springcloud.entities.CommonResult;
import com.flytodream.springcloud.entities.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Date 2021/5/29 15:18
 * @Author by tongxm
 */
@RestController
@DefaultProperties(defaultFallback = "glableError")
public class OrderController {
    @Autowired
    private OrderInterface orderInterface;

    @GetMapping("/cunsumer/feign/ok")
    public String ok()
    {
        return orderInterface.ok();
    }
    @GetMapping("/cunsumer/feign/timeout")
    @HystrixCommand
    public String timeout()
    {
        return orderInterface.timeout();
    }

    @GetMapping("/cunsumer/feign/ok2")
    public String ok2()
    {
        return orderInterface.ok2();
    }



    @GetMapping("/cunsumer/feign/timeout2")
    @HystrixCommand(fallbackMethod = "error",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public String timeout2()
    {
        return orderInterface.timeout2();
    }



    public String error(){
        return "相应超时-consumer！！！";
    }

    public String glableError(){
        return "公共相应超时-consumer！！！";
    }

}
