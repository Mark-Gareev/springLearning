package gareev.learn.shell;

import gareev.learn.service.UserService;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.ShellComponent;

import java.io.PrintStream;
import java.util.Scanner;

@ShellComponent
public class UserCommands {
    UserService service;
    Scanner scanner;
    PrintStream printStream;

    @Command
    public void createUser() {

    }

    @Autowired
    public UserCommands(UserService service) {
        this.service = service;
        scanner = new Scanner(System.in);
        printStream = System.out;
    }

}
