package org.tyaa.demo.java.se.io.streams;

import java.io.*;
import java.util.Date;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	    String nowDate = new Date().toString();
        // System.out.println(nowDate);
        String[] randomStrings = new String[3];
        for (int i = 0; i < 3; i++) {
            randomStrings[i] = String.valueOf(new Random().nextInt());
        }

        /* FileWriter fw = new FileWriter("output.txt");
        // ***
        fw.close(); */

        /* FileWriter fw = null;
        try {
            fw = new FileWriter("output.txt");
            // ***
        } catch (Exception ignore) {}
        finally {
            if (fw != null)
                fw.close();
        } */

        /* try (FileWriter fw = new FileWriter("output.txt", true)) {
            fw.append(
                String.format(
                    "%s -> %s, %s, %s\n",
                    nowDate,
                    randomStrings[0],
                    randomStrings[1],
                    randomStrings[2]
                )
            );
            fw.flush();
        } catch (Exception ignore) {}

        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        } */

        Employee manager = new Employee(1, "John", 30000, null);
        Employee clerk = new Employee(null, null, 25000, manager);

        /* Employee clerk1 = new Employee(clerk);
        Employee clerk2 = new Employee(clerk);

        clerk1.id = 2;
        clerk2.id = 3;

        clerk1.chief.name = "Smith";

        System.out.println(clerk2.chief); */

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(clerk);

        ObjectInputStream in =
            new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Employee clerk1 = (Employee) in.readObject();

        out.close();
        in.close();

        bos = new ByteArrayOutputStream();
        out = new ObjectOutputStream(bos);
        out.writeObject(clerk);

        in =
            new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Employee clerk2 = (Employee) in.readObject();

        clerk1.chief.name = "Smith";
        System.out.println(clerk1.chief);
        System.out.println(clerk2.chief);

        out.close();
        in.close();
    }
}
