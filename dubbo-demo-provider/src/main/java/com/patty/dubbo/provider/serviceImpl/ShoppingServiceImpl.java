package com.patty.dubbo.provider.serviceImpl;

import com.patty.dubbo.api.service.ShoppingService;
import org.springframework.stereotype.Service;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/6/29 下午4:14
 * Desc:
 */
@Service("shoppingService")
public class ShoppingServiceImpl implements ShoppingService {
    public ShoppingServiceImpl(){

    }

    @Override
    public String shopping() {
        try {

            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Shopping for 6 seconds";
    }
}
