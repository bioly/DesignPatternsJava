package com.designpatterns.solid.srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text){
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index){
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    // here we break SRP - Journal should not be responsible for saving / loading
    public void save(String filename) throws FileNotFoundException {
        try(PrintStream out = new PrintStream(filename)){
            out.println(toString());
        }
    }

    public void load(String filename){}
    public void load(URL url){}
}

// handles the responsibility of persisting objects
class Persistance{

    public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
        if(overwrite || new File(filename).exists()){
            try(PrintStream out = new PrintStream(filename)){
                out.println(journal.toString());
            }
        }
    }

    public void load(Journal journal, String filename){}
    public void load(Journal journal, URL url){}
}

public class SRPDemo{
    public static void main(String[] args) throws IOException {
        Journal j = new Journal();
        j.addEntry("I cried today");
        j.addEntry("WOSP was not a good day for Poland");
        System.out.println(j);

        // rather bad idea, SRP broke
        String filename = "./journal.txt";
//        j.save(filename);

        Persistance p = new Persistance();
        p.saveToFile(j, filename, true);

        // MacOS
        Runtime.getRuntime().exec("open " + filename);
    }
}

