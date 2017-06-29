package com.patty.dubbo.provider.serviceImpl;

import com.patty.dubbo.api.service.EatingService;
import org.springframework.stereotype.Service;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/6/29 下午4:16
 * Desc:
 */
@Service("eatingService")
public class EatingServiceImpl implements EatingService {
    public EatingServiceImpl() {

    }

    @Override
    public String eating() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Eating for 5 seconds";
    }
}
