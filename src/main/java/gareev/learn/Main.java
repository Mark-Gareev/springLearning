package gareev.learn;

import gareev.learn.domain.User;
import gareev.learn.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {


    public static void main(String... args) {
        ApplicationContext ctx = SpringApplication.run(Main.class);
        UserService service = ctx.getBean(UserService.class);
        System.out.println(service.countUsers());
        System.out.println(service.createJohnJohn().getName());
        System.out.println(service.createJohnJohn().getName());
        System.out.println(service.createJohnJohn().getName());
        List<User> userList = service.getAllUsers();
        System.out.println(service.countUsers());
        System.out.println("user list size = " + userList.size());
        System.out.println("iterate list : ");
        for(User user: userList){
            System.out.println(user.toString());
        }
    }
}
