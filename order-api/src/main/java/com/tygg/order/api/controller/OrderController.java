package com.tygg.order.api.controller;

import com.tygg.order.api.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 * OrderController
 * Date: 2019/3/5
 * Time: 下午1:17
 *
 * @author 931635602@qq.com
 */
@RestController
public class OrderController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/order-json/{orderId}")
    public String getOrderJson(@PathVariable String orderId, Principal principal) {
        System.err.println(principal.getName());
        System.err.println("order id is : ".concat(orderId));
        return "order id is : ".concat(orderId);
    }

    @GetMapping("/test")
    public String test() {
        return "hello world, i'm order-api";
    }

    @GetMapping("/test-account")
    public String testAccountService() {
        return accountService.testAccountService();
    }
}
