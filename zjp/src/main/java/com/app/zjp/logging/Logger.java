package com.app.zjp.logging;

public class Logger {

    // Tworzymy instancje loggera, tylko raz, ale nie od razu tylko uzywajac lazy initialization
    private static Logger sInstance;

    // Prywatny konstruktor, zeby nie mozna bylo stworzyc obiektu z zewnatrz
    private Logger() {}

    // Zwraca wczesniej stworzona, jedyna instancje loggera
    // Jesli jeszcze jej nie utworzylismy ( == null ) to ja tworzymy (lazy initialization)
    public static Logger getInstance() {
        if(sInstance == null) {
            sInstance = new Logger();
        }
        return sInstance;
    }

    public void log(String message) {
        System.out.println("[LOGGER OUTPUT] " + message);
    }
}
