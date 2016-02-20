/**
 * Copyright (C) 2002-2006 Bas Peters
 *
 * This file is part of MARC4J
 *
 * MARC4J is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public 
 * License as published by the Free Software Foundation; either 
 * version 2.1 of the License, or (at your option) any later version.
 *
 * MARC4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public 
 * License along with MARC4J; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.hyulib;

import org.marc4j.MarcReader;
import org.marc4j.MarcXmlReader;
import org.marc4j.MarcXmlWriter;
import org.marc4j.marc.Record;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.InputStream;
/**
 * Writes MODS to standard output.
 * 
 * @author Bas Peters
 */
public class MarcXml2ModsExample {

    public static void main(String args[]) throws Exception {

        String stylesheetUrl = "http://www.loc.gov/standards/mods/v3/MARC21slim2MODS3-5.xsl";
        Source stylesheet = new StreamSource(stylesheetUrl);

        Result result = new StreamResult(System.out);

//        InputStream input = new FileInputStream("resources/summerland.xml");
        InputStream input = new FileInputStream("resources/000001666010.xml");

//                ReadMarcExample.class
//                .getResourceAsStream("resources/summerland.xml");
//                .getResourceAsStream("resources/000001666010.xml");

        MarcReader reader = new MarcXmlReader(input);

        MarcXmlWriter writer = new MarcXmlWriter(result, stylesheet);
//        writer.setConverter(new AnselToUnicode());
        while (reader.hasNext()) {
            Record record =  reader.next();
            writer.write(record);
        }
        writer.close();
    }
}
