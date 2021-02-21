package com.hemebiotech.analytics;

import java.io.*;

/**
 * <b> AnalyticsCounter is the class containing "main" method.</b>
 * <p>
 * The program will execute these actions :
 *     <ul>
 *         <li>Read a text file.</li>
 *         <li>Sort and count all symptoms.</li>
 *         <li>Write the results; "symptoms : occurences".</li>
 *     </ul>
 * </p>
 * <p> The program will also write its properties.</p>
 *
 * @author Samuel Verdière
 * @Version 1.0
 */

public class AnalyticsCounter {

    /**
     * <p> We create an instance of propertiesService,
     * so we have access to config.properties.
     * This will allow use of files while securing them.</p>
     *
     * <p>The code that will read the file.</p>
     * <p>We indicate the path of the file that must be read.</p>
     * <p>Then we effectively read them.</p>
     *
     * @see readDatas();
     *
     *
     * <p>The code that will write the results.</p>
     * <p>We indicate the path of the file in which to write.</p>
     * <p>Then effectively write them.</p>
     * @see WriteDatas();
     */

    public static void main(String[] args) {

        PropertiesService propertiesService = new PropertiesService(System.getProperties());

        //Declare and initialize File with path and method that will read (& count) data
        File file = new File(propertiesService.getProperty("inputFilePath"));
        ReadSymptomOnFile symptomReader = new ReadSymptomOnFile(file);
        symptomReader.readDatas();

        //Declare and initialize File2 that will write results as expected
        File file2 = new File(propertiesService.getProperty("outputFilePath"));
        WriteSymptomToFile wstf = new WriteSymptomToFile(file2);
        wstf.WriteDatas(symptomReader.getMyMap());
    }
}