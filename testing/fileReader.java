package testing;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class fileReader {
    public static void main(String[] args) {
        DataProvider testing = new DataProvider();

        ArrayList<Monitor> test = testing.returnCategory("Gaming");
        for (Monitor tempMon : test) {
            System.out.println(tempMon.getName());
        }
    }
}
