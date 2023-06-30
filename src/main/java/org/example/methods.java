package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class methods {
    public static void parseIt(String str) {
        str = str.replaceAll("[,{}\"]", "");
        StringBuilder builder = new StringBuilder();
        String[] a = str.split(" ");
        System.out.println(a.toString());
        for (int i = 0; i < a.length; i++) {
            if(!a[i].contains("null")){
                if(i!=0){
                    builder.append(" AND ");
                }
                builder.append(a[i].substring(0, a[i].indexOf(":")));
                builder.append(" = ");
                builder.append("\"");
                builder.append(a[i].substring(a[i].indexOf(":")+1));
                builder.append("\"");
            }
        }
        System.out.println("SELECT * FROM STUDENTS WHERE " + builder);
    }
    public static void parseFile(String path){
        char[] chars = null;
        try {
            File file = new File(path);
            FileReader reader = new FileReader(file);
            chars = new char[(int) file.length()];
            reader.read(chars, 0, (int) file.length());
            }
        catch (IOException e) {
            System.out.println("There is an exception!");
        }
        String str = Arrays.toString(chars).replace(", ", "");
        str = str.replaceAll("[{\"\\[\\]]", "");
        StringBuilder builder = new StringBuilder();
        String[] a = str.split("},");
        for (int i = 0; i < a.length; i++) {
            String[] stud = a[i].replace("}", "").split(",");
            builder.append("Студент ");
            builder.append(stud[0].substring(stud[0].indexOf(":")+1));
            builder.append(" получил ");
            builder.append(stud[1].substring(stud[1].indexOf(":")+1));
            builder.append(" по предмету ");
            builder.append(stud[2].substring(stud[2].indexOf(":")+1));
            builder.append("\n");
        }
        System.out.println(builder);

    }
}
