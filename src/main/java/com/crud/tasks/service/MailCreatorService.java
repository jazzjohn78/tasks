package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Value("${info.company.name}")
    private String companyName;
    @Value("${info.company.email}")
    private String companyEmail;
    @Value("${info.company.phone}")
    private String companyPhone;


    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your task");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye", "Your TaskCrudApp crew");
        context.setVariable("company_name", companyName);
        context.setVariable("company_email", companyEmail);
        context.setVariable("company_phone", companyPhone);
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String administrationEmail(String message) {
        List<String> companyData = new ArrayList<>();
        companyData.add(companyName);
        companyData.add("email: " + companyEmail);
        companyData.add("phone no: " + companyPhone);

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("company_data", companyData);
        context.setVariable("is_friday", true);
        context.setVariable("show_button", false);

        return templateEngine.process("mail/administration-mail", context);
    }
}
