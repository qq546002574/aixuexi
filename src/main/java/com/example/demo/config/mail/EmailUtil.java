package com.example.demo.config.mail;

import com.google.common.base.Splitter;
import com.sun.mail.util.MailSSLSocketFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author beiley
 */
public class EmailUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
    private static Session session;

    static {
        Properties prop = new Properties();
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.host", "smtp.qq.com");
        prop.setProperty("mail.smtp.port", "465");
        prop.setProperty("mail.smtp.auth", "true");
//        prop.setProperty("mail.debug", "true"); // debug
        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            prop.put("mail.smtp.ssl.enable", "true");
            prop.put("mail.smtp.ssl.socketFactory", sf);
            session = Session.getDefaultInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(MyConfig.EMAIL_ACCOUNT, MyConfig.EMAIL_PWD);
                }
            });
        } catch (Throwable e) {
            LOGGER.error("邮件服务器配置错误", e);
        }
    }

    /**
     * @param fromAlias 发件人别名，应该采用系统名称如APP,TMS_SAAS,TMS_MASTER,SMSCENTER,NPROXY,DC等
     * @param to        接收人邮箱地址，多个收件人使用逗号分割
     * @param subject   邮件主题
     * @param content   邮件内容，支持html
     * @param fileStr   附件文件绝对地址
     */
    public static boolean send(String fromAlias, String to, String subject, String content, String fileStr) {
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            //发件人
            if (StringUtils.isNotBlank(fromAlias)) {
                mimeMessage.setFrom(new InternetAddress(MyConfig.EMAIL_ACCOUNT, fromAlias));
            } else {
                mimeMessage.setFrom(new InternetAddress(MyConfig.EMAIL_ACCOUNT));
            }
            //收件人
            List<String> recipients = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(to);
            for (String recipient : recipients) {
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            }
            mimeMessage.setSubject(subject);
            mimeMessage.setSentDate(new Date());
            Multipart mp = new MimeMultipart();
            MimeBodyPart body = new MimeBodyPart();
            body.setContent(content, "text/html; charset=UTF-8");
            mp.addBodyPart(body);
            if (StringUtils.isNotBlank(fileStr)) {
                body = new MimeBodyPart();
                body.attachFile(fileStr);
                mp.addBodyPart(body);
            }
            mimeMessage.setContent(mp);
            mimeMessage.saveChanges();
            Transport.send(mimeMessage);
            return true;
        } catch (Throwable e) {
            LOGGER.error("邮件发送失败,from:{},to:{},subject:{},content:{},fileStr:{}", fromAlias, to, subject, content, fileStr, e);
            return false;
        }
    }
}
