package com.wkk.wkkbjsb.business.elasticjob.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.elasticjob.listener
 * @Description : 用于监听MySimpleJob的任务执行情况
 * @Create on : 2021/1/28 17:11
 * @email : lgy961228@gamil.com
 **/

@Slf4j
public class MyElasticJobListener implements ElasticJobListener {

    private long beginTime = 0;

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        beginTime = System.currentTimeMillis();
        log.info("===>{} MyElasticJobListener BEGIN TIME: {} <===",
                shardingContexts.getJobName(),
                DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        long endTime = System.currentTimeMillis();
        log.info("===>{} MyElasticJobListener END TIME: {},TOTAL CAST: {} <===",
                shardingContexts.getJobName(),
                DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"),
                endTime - beginTime);
    }
}
