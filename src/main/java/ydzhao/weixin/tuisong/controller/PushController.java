package ydzhao.weixin.tuisong.controller;

/**
 *@ClassName PushController
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 15:48
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ydzhao.weixin.tuisong.util.Pusher;

import static ydzhao.weixin.tuisong.constant.CommonConstant.SDL_OPENID;
import static ydzhao.weixin.tuisong.constant.CommonConstant.WLY_OPENID;

@RestController
public class PushController {



    /**
     * 微信测试账号推送
     *
     */
    @GetMapping("/push")
    public void push() {
        Pusher.push(SDL_OPENID);
    }

    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/wly")
    public void pushZyd() {
        Pusher.push(WLY_OPENID);
    }


    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/{id}")
    public void pushId(@PathVariable("id") String id) {
        Pusher.push(id);
    }
}