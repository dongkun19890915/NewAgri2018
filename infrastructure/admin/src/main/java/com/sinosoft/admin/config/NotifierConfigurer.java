package com.sinosoft.admin.config;

import de.codecentric.boot.admin.notify.LoggingNotifier;
import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import de.codecentric.boot.admin.notify.filter.FilteringNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * Created by Jason on 2017/6/14.
 */
@Configuration
@EnableScheduling
public class NotifierConfigurer {

    @Bean
    @Primary
    public RemindingNotifier remindingNotifier() {
        RemindingNotifier notifier = new RemindingNotifier(filteringNotifier(loggerNotifier()));
        notifier.setReminderPeriod(TimeUnit.SECONDS.toMillis(60));
        return notifier;
    }

    @Scheduled(fixedRate = 1_000L)
    public void remind() {
        remindingNotifier().sendReminders();
    }

    @Bean
    public FilteringNotifier filteringNotifier(Notifier delegate) {
        return new FilteringNotifier(delegate);
    }

    @Bean
    public LoggingNotifier loggerNotifier() {
        return new LoggingNotifier();
    }

}
