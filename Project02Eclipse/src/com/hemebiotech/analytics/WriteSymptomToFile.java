package com.hemebiotech.analytics;

import java.io.*;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;
import java.io.FileWriter;

class WriteSymptomToFile implements ICanWritable {

    /**
     * The file variable named file.
     * <p>It can only be accessed from within this class.</p>
     */

    private File file2;

    /**
     * The TreeMap named myMap.
     * <p>For more informations on TreeMap,
     * check documentation.</p>
     */

    private Map<String, Integer> myMap;

    /**
     * This is the parameterized constructor for file2.
     * <p>It constructs the value when the object is created.</p>
     *
     * @param file2 <p>The this keyword is a reference to the file object.
     *              It is an explicit constructor invocation that will allow
     *              use of the file object in another method.</p>
     */

    public WriteSymptomToFile(File file2) {
        this.file2 = file2;
    }

    /**
     * This method declares that this.myMap is a map.
     * It also declares a BufferedWriter.
     *
     * <p>The BufferedWriter will write to the outputfile.</p>
     * <p>The BF is instanatiated with a FileWriter. The
     * code is wrapped in a try/catch to avoid errors on file.</p>
     * <p>
     * The for Loop will set the writing.
     * <p> For each entry of String & Integer
     * from the myMap entry set, bf will write
     * each key and value; line after line.
     * </p>
     * <p>
     * Then the stream is flushed, once the writing is done.
     * Finally, the stream is closed.
     *
     * @param map
     */

    public void WriteDatas(TreeMap<String, Integer> map) {

        //initializing map & declare bufferedWriter which is null
        this.myMap = map;
        BufferedWriter bf = null;

        //initializing bufferedwriter to write on this.file2
        try {
            bf = new BufferedWriter(new FileWriter(this.file2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //for values & keys in myMap, bf must write them as specified, line by line
        try {
            for (Map.Entry<String, Integer> entry : this.myMap.entrySet()) {
                bf.write(entry.getKey() + ": " + entry.getValue());
                bf.newLine();
            }

            //flush the stream and close the writer when done
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bf != null;
                bf.close();
            } catch (Exception e) {

            }
        }
    }
}