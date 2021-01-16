package com.example.demo.task;

import com.example.demo.config.mail.EmailUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(MyJob.class);

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {

        log.info("MyJob is start ..................");
        EmailUtil.send("你最爱的帅帅",  "shuai.hu@fksaas.com", "爱你么么哒", "<h1>小垃圾起床没</h1>", null);
        log.info("MyJob is end .....................");

    }
}
