package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private final static String SUBJECT = "Tasks: once a day email";

    private final SimpleEmailService simpleEmailService;
    private final TaskRepository taskRepository;
    private final AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        String message;
        if(size == 1) {
            message = "Currently in database you got: " + size + " task";
        } else {
            message = "Currently in database you got: " + size + " tasks";
        }
        simpleEmailService.administrationSend(
                new Mail(
                        adminConfig.getAdminMail(),
                        null,
                        SUBJECT,
                        message
                )
        );
    }
}
