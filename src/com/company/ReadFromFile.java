package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {

    public static Path rFF(String fileToRead) throws FileNotFoundException {
        Path readingPath = new Path();
        Scanner readFile = new Scanner(new File(fileToRead));
        while(readFile.hasNextLine()) {
            String text = readFile.nextLine();
            if (text.isEmpty())
                break;
            System.out.println(text);
            String[] point = text.split(" ");
            readingPath.addPoint(new Point(Integer.parseInt(point[0]),Integer.parseInt(point[1]),Integer.parseInt(point[2])));
        }
        return readingPath;
    }

}
