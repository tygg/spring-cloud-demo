package com.tygg.user.api.controller;

import com.tygg.user.api.client.OrderServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * <pre>
 *                             _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                            O\  =  /O
 *                         ____/`---'\____
 *                       .'  \\|     |//  `.
 *                      /  \\|||  :  |||//  \
 *                     /  _||||| -:- |||||-  \
 *                     |   | \\\  -  /// |   |
 *                     | \_|  ''\---/''  |   |
 *                     \  .-\__  `-`  ___/-. /
 *                   ___`. .'  /--.--\  `. . __
 *                ."" '<  `.___\_<|>_/___.'  >'"".
 *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 *               \  \ `-.   \_ __\ /__ _/   .-` /  /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 *
 *                     佛祖保佑        永无BUG
 *
 *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * </pre>
 * TestController
 * Date: 2019/3/5
 * Time: 上午11:08
 *
 * @author 931635602@qq.com
 */
@RestController
public class TestController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private OrderServiceClient orderServiceClient;

    @GetMapping("/test")
    public String test() {
        redisTemplate.opsForValue().set("test", "test001");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.err.println(redisTemplate.opsForValue().get("test"));
        System.err.println("over");
        return "hello world, i'm account-service";
    }

    @GetMapping("/test-order")
    public String getOrderTest() {
        return orderServiceClient.test();
    }

    @RequestMapping(path = "/current", method = RequestMethod.GET)
    public String getCurrentAccount(Principal principal) {
        return principal.getName();
    }

}
