package org.stone.quartz.job;

import org.joda.time.DateTime;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by dslht on 2016/8/14.
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(DateTime.now().toString("yyyyMMdd HH:mm:ss"));
    }
}
