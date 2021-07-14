package com.wkk.wkkbjsb.business.elasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Var;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.elasticjob.job
 * @Description : TODO
 * @Create on : 2021/1/28 18:29
 * @email : lgy961228@gamil.com
 **/

@Slf4j
public class MyDataFlowJob implements DataflowJob<String> {


    private boolean flag = false;

    @Override
    public List<String> fetchData(ShardingContext shardingContext) {
        log.info("开始获取数据");
        if (flag) {
            return null;
        }
        return Arrays.asList("qingshan", "jack", "seven");
    }

    @Override
    public void processData(ShardingContext shardingContext, List<String> list) {
        for (String val : list) {
            // 处理完数据要移除掉，不然就会一直跑,处理可以在上面的方法里执行。这里采用 flag
            log.info("开始处理数据：" + val);
        }
        flag = true;
    }
}
