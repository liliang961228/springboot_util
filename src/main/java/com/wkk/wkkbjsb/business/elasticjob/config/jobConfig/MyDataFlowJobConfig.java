package com.wkk.wkkbjsb.business.elasticjob.config.jobConfig;

import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.dataflow.DataflowJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.wkk.wkkbjsb.business.elasticjob.job.MyDataFlowJob;
import com.wkk.wkkbjsb.business.elasticjob.listener.MyElasticJobListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.elasticjob.config.jobConfig
 * @Description : 将其注入到zookeeper注册中心
 * @Create on : 2021/1/28 18:31
 * @email : lgy961228@gamil.com
 **/

@Configuration
public class MyDataFlowJobConfig {

    /**
     * 任务名称
     */
    @Value("${dataflowJob.myDataflowJob.name}")
    private String jobName;

    /**
     * cron表达式
     */
    @Value("${dataflowJob.myDataflowJob.cron}")
    private String jobCron;

    /**
     * 作业分片总数
     */
    @Value("${dataflowJob.myDataflowJob.shardingTotalCount}")
    private int jobShardingTotalCount;

    /**
     * 作业分片参数
     */
    @Value("${dataflowJob.myDataflowJob.shardingItemParameters}")
    private String jobShardingItemParameters;

    /**
     * 自定义参数
     */
    @Value("${dataflowJob.myDataflowJob.jobParameters}")
    private String jobParameters;

    @Autowired
    private ZookeeperRegistryCenter registryCenter;


    @Bean
    public MyDataFlowJob myDataFlowJob() {
        return new MyDataFlowJob();
    }

    @Bean(initMethod = "init")
    public JobScheduler dataFlowJobScheduler(final MyDataFlowJob myDataFlowJob) {
        MyElasticJobListener elasticJobListener = new MyElasticJobListener();
        return new SpringJobScheduler(myDataFlowJob, registryCenter, getLiteJobConfiguration(), elasticJobListener);
    }

    private LiteJobConfiguration getLiteJobConfiguration() {
        // 定义作业核心配置
        JobCoreConfiguration dataflowCoreConfig = JobCoreConfiguration.newBuilder(jobName, jobCron, jobShardingTotalCount).
                shardingItemParameters(jobShardingItemParameters).jobParameter(jobParameters).build();
        // 定义DATAFLOW类型配置
        DataflowJobConfiguration dataflowJobConfig = new DataflowJobConfiguration(dataflowCoreConfig, MyDataFlowJob.class.getCanonicalName(), false);
        // 定义Lite作业根配置
        LiteJobConfiguration dataflowJobRootConfig = LiteJobConfiguration.newBuilder(dataflowJobConfig).overwrite(true).build();
        return dataflowJobRootConfig;

    }
}
