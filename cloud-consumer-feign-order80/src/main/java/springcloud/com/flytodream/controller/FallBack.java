package springcloud.com.flytodream.controller;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Date 2021/5/29 21:16
 * @Author by tongxm
 */
@Component
public class FallBack implements OrderInterface{
    @Override
    public String ok() {
        return "FallBack --ok";
    }

    @Override
    public String timeout() {
        return "FallBack --timeout";
    }

    @Override
    public String ok2() {
        return "FallBack --ok2";
    }

    @Override
    public String timeout2() {
        return "FallBack --timeout2";
    }
}
