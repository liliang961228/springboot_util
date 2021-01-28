package com.wkk.wkkbjsb.business.elasticjob.config.jobConfig;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.wkk.wkkbjsb.business.elasticjob.job.MySimpleJob;
import com.wkk.wkkbjsb.business.elasticjob.listener.MyElasticJobListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.elasticjob.config.jobConfig
 * @Description : 将MySimpleJob其注入到zookeeper
 * @Create on : 2021/1/28 17:13
 * @email : lgy961228@gamil.com
 **/

@Configuration
public class MySimpleJobConfig {

    /**
     * 任务名称
     */
    @Value("${simpleJob.mySimpleJob.name}")
    private String mySimpleJobName;

    /**
     * cron表达式
     */
    @Value("${simpleJob.mySimpleJob.cron}")
    private String mySimpleJobCron;

    /**
     * 作业分片总数
     */
    @Value("${simpleJob.mySimpleJob.shardingTotalCount}")
    private int mySimpleJobShardingTotalCount;

    /**
     * 作业分片参数
     */
    @Value("${simpleJob.mySimpleJob.shardingItemParameters}")
    private String mySimpleJobShardingItemParameters;

    /**
     * 自定义参数
     */
    @Value("${simpleJob.mySimpleJob.jobParameters}")
    private String mySimpleJobParameters;

    @Autowired
    private ZookeeperRegistryCenter registryCenter;

    @Bean
    public MySimpleJob mySimpleJob() {
        return new MySimpleJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(final MySimpleJob mySimpleJob) {
        //配置任务监听器
        MyElasticJobListener elasticJobListener = new MyElasticJobListener();
        return new SpringJobScheduler(mySimpleJob, registryCenter, getLiteJobConfiguration(), elasticJobListener);
    }

    private LiteJobConfiguration getLiteJobConfiguration() {
        // 定义作业核心配置
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder(mySimpleJobName, mySimpleJobCron, mySimpleJobShardingTotalCount).
                shardingItemParameters(mySimpleJobShardingItemParameters).jobParameter(mySimpleJobParameters).build();
        // 定义SIMPLE类型配置
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, MySimpleJob.class.getCanonicalName());
        // 定义Lite作业根配置
        LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).overwrite(true).build();
        return simpleJobRootConfig;

    }
}
