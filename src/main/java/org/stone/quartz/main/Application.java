package org.stone.quartz.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.stone.quartz.job.MyJob;
import org.stone.quartz.job.QuartzManager;

/**
 * Created by dslht on 2016/8/14.
 */
@ComponentScan("org.stone.quartz")
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        //http://blog.csdn.net/pengpegv5yaya/article/details/37595889/
        //http://snailxr.iteye.com/blog/2076903
        //https://nkcoder.github.io/tags/quartz/
        //https://github.com/nkcoder/quartz-explained.git
        //http://ifeve.com/quartz-tutorial-job-jobdetail/
        SpringApplication.run(Application.class, args);
        String job_name = "动态任务调度";
        System.out.println("【系统启动】开始(每1秒输出一次)...");
        QuartzManager.addJob(job_name, MyJob.class, "0/1 * * * * ?");

    }
}
