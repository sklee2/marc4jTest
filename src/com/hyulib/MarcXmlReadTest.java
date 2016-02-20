package com.hyulib;


import org.marc4j.MarcReader;
import org.marc4j.MarcXmlReader;
import org.marc4j.MarcXmlWriter;
import org.marc4j.marc.Record;

import java.io.FileInputStream;
import java.io.InputStream;

public class MarcXmlReadTest {

    public static void main(String args[]) throws Exception {

        InputStream in = new FileInputStream("000001666010.xml");
        MarcReader reader = new MarcXmlReader(in);

        MarcXmlWriter writer = new MarcXmlWriter(System.out);


        while (reader.hasNext()) {
            Record record = reader.next();
            writer.write(record);
            System.out.println(record.toString());
        }
        writer.close();

    }

}
