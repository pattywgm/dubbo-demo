package com.patty.dubbo.consumer.service;


import com.alibaba.dubbo.rpc.cluster.Merger;
import com.patty.dubbo.api.domain.UserVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/6/28 下午11:58
 * Desc:
 */

public class MyMerger implements Merger<List<UserVo>> {

    @Override
    public List<UserVo> merge(List<UserVo>... userVoLists) {
        ArrayList<UserVo> result = new ArrayList<>();
        for (List<UserVo> userVoList : userVoLists) {
            for (UserVo userVo : userVoList) {
                if (userVo.getwId().equals("10")) {
                    userVoList.remove(userVo);
                }
            }
            result.addAll(userVoList);
        }
        return result;
    }
}
