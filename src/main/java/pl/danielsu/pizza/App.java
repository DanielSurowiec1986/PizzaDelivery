package pl.danielsu.pizza;


import java.io.IOException;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {


        int numberOfChoose;
        do {
            numberOfChoose = UserInterface.displayInterface();
            UserInterface.doChoosedAction(numberOfChoose);
        } while (numberOfChoose < UserInterface.getOptions().length);


    }
}
