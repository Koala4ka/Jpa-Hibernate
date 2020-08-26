package com.anna.executor;

import com.anna.config.Config;
import com.anna.view.menu.MainMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Executor {

    public  static void start(){
        var context = new AnnotationConfigApplicationContext(Config.class);
        var menu = context.getBean(MainMenu.class);
        menu.show();
    }
}
