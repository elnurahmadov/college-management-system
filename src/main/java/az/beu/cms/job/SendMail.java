package az.beu.cms.job;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendMail {

    private final JavaMailSender mailSender;

    public SendMail(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Scheduled(fixedDelay = 10000)
    @SchedulerLock(name = "sendEmailJob", lockAtLeastFor = "9s", lockAtMostFor = "15s")
    public void sendEmail() {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo("eelnur020@gmail.com");
            msg.setSubject("Test Email");
            msg.setText("Salam! Bu 10 saniyədə bir göndərilən test mesajıdır.");
            mailSender.send(msg);
            log.info("Email göndərildi: eelnur020@gmail.com");
        } catch (Exception e) {
            log.error("Email göndərilmədi: " + e.getMessage());
        }
    }
}