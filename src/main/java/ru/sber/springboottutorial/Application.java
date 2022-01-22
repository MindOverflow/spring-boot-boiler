package ru.sber.springboottutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sber.springboottutorial.components.AppConfig;
import ru.sber.springboottutorial.components.MyService;
import ru.sber.springboottutorial.components.MyService02;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //MyService myService = ctx.getBean(MyService.class);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("ru.sber.springboottutorial.components");
        ctx.refresh();
        MyService myService = ctx.getBean(MyService.class);
        MyService02 myService02 = ctx.getBean(MyService02.class);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("Executing sayHello!");
        return String.format("Hello %s!", name);
    }
}
