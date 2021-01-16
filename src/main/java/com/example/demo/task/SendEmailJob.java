package com.example.demo.task;

import com.example.demo.config.mail.EmailUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SendEmailJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(MyJob.class);

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        // 拼接邮件内容
        log.info("SendEmailJob is start ..................");
//        content()
        EmailUtil.send("爱你的帅帅",  "wangpiao@yonyou.com", "生日快乐哟", "<h1>爱你一辈子哦</h1>", null);
        log.info("SendEmailJob is end .....................");
    }

//    private String content() {
//        StringBuilder strBuilder = new StringBuilder("<table border='1' style='order-collapse:collapse'>" +
//                "<tr><h2 style=\"text-align: center;" + "\">" + "</h2></tr>" +
//                "<tr><th>序号</th><th>操作人</th></tr>");
//        for (int i = 0; i < 10; i++) {
//            strBuilder.append("<tr><td>").append(i + 1);
//            strBuilder.append("</td><td>").append("王漂");
//            strBuilder.append("</td></tr>");
//        }
//        strBuilder.append("</table>");
//        return strBuilder.toString();
//    }
}