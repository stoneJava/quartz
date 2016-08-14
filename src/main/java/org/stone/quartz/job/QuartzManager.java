package org.stone.quartz.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by dslht on 2016/8/14.
 */
public class QuartzManager {

    private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
    private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";
    private static String TRIGGER_GROUP_NAME = "EXTJWEB_TRIGGERGROUP_NAME";

    /**
     * @param jobName 任务名
     * @param cls     任务
     * @param time    时间设置，参考quartz说明文档
     * @Description: 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
     * @Title: QuartzManager.java
     * @Copyright: Copyright (c) 2014
     * @author Comsys-LZP
     * @date 2014-6-26 下午03:47:44
     * @version V2.0
     */
    @SuppressWarnings("unchecked")
    public static void addJob(String jobName, Class cls, String time) {
        try {
            Scheduler sched = gSchedulerFactory.getScheduler();

            JobDetail jobDetail = JobBuilder.newJob(cls).withIdentity(jobName, JOB_GROUP_NAME).build();
            //JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, cls);// 任务名，任务组，任务执行类
            // 触发器
           // CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);// 触发器名,触发器组
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, TRIGGER_GROUP_NAME)
                    .withSchedule(CronScheduleBuilder.cronSchedule(time)).build();
          /*  trigger.setCronExpression(time);// 触发器时间设定*/

            sched.scheduleJob(jobDetail, trigger);
            // 启动
            if (!sched.isShutdown()) {
                sched.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
