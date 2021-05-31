package springcloud.com.flytodream.controller;

import com.flytodream.springcloud.entities.CommonResult;
import com.flytodream.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description
 * @Date 2021/5/29 15:21
 * @Author by tongxm
 */
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = FallBack.class)
@Component
public interface OrderInterface {
    @GetMapping(value = "/payment/ok")
     String ok();
    @GetMapping(value = "/payment/timeout")
     String timeout();
    @GetMapping(value = "/payment/ok2")
     String ok2();
    @GetMapping(value = "/payment/timeout2")
     String timeout2();
}
