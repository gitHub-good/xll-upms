package com.xll.upms.daemon.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.zen.elasticjob.spring.boot.annotation.ElasticJobConfig;

import java.util.List;

/**
 * @Author 徐亮亮
 * @Description：数据流任务Job
 * @Date 2019/1/18 21:21
 */
@ElasticJobConfig(cron = "0 0 0/1 * * ? ", shardingTotalCount = 3, shardingItemParameters = "0=Beijing,1=Shanghai,2=Guangzhou")
public class UmpsDataflowJob implements DataflowJob<Integer> {


    @Override
    public List<Integer> fetchData(ShardingContext shardingContext) {
        return null;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<Integer> list) {

    }
}
