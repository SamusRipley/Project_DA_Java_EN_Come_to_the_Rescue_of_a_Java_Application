package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

class ReadSymptomOnFile implements CanReadable {

    /**
     * The file variable named file.
     * <p>It can only be accessed from within this class.</p>
     */
    //Declare & initialize file, path, TreeMap and constructor for this.file
    private File file;

    /**
     * The TreeMap named myMap.
     * <p>For more informations on TreeMap,
     * check documentation.</p>
     */

    private TreeMap<String, Integer> myMap;

    /**
     * This is the parameterized constructor for file.
     * <p>It constructs the value when the object is created.</p>
     * @param file
     *
     * <p>The this keyword is a reference to the file object.
     * It is an explicit constructor invocation that will allow
     * use of the file object in another method.</p>
     */

    public ReadSymptomOnFile(File file){
        this.file = file;
    }

    /**
     * The method readDatas() initializes a scanner and an instance of TreeMap.
     * <p>The Scanner will read the file linked to the TreeMap myMap.
     * The Scanner is wrapped in try/catch to avoid errors about the file.
     * TreeMap will sort out and count words in the file.</p>
     *
     * Then it starts a while loop.
     * <p>As long as the scanner has a line to read,
     * it keeps doing the following actions:</p>
     * <ul>
     *<li>Read the next line which is named m.</li>
     * <li>Split the line each time a designated
     * punctuation is met.</li>
     * </ul>
     *
     * With a for loop:
     * <p> As long as there is input, we increase the value.
     * The key which is a String, will be returned in upper cases</p>
     *
     * The if statement indicates:
     * <p>That if its length is 0, then set the key to 1.
     * If its length is 1 or above, then the key gets +1 value.</p>
     *
     * Then print the results of the TreeMap.
     * <p>The keySet() gives a view on all keys of the file.</p>
     * <p>The print method prints the entries and the keys.</p>
     */

    public void readDatas() {
        //call scanner set to null; create new instance of scanner & catch exception if needs

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //create new instance of TreeMap using the class instance of this.myMap
        this.myMap = new TreeMap<>();

        //as long as the scanner has a line to read, which is m, we read & split each line
        while (sc.hasNext()) {
            String m = sc.nextLine();
            String[] input = m.split("[\n\t\r,.;:!?(){}]");

            //depending on the length of the input; return string keys as uppercases
            for (int f = 0; f < input.length; f++) {
                String key = input[f].toUpperCase();

                //if input is seen more than once, add 1 to key value, if key value is 0 then set it to 1
                if (input[f].length() > 1) {
                    if (this.myMap.get(key) == null) {
                        this.myMap.put(key, 1);
                    } else {
                        this.myMap.put(key, (this.myMap.get(key)) + 1);
                    }
                }
            }
        }

        //about the results, print them in the console as "Symptom : Count"
        for (String entry : this.myMap.keySet()) {
            System.out.println(entry + " : " + this.myMap.get(entry));
        }
    }

    /**
     * The data of the variable myMap is returned,
     * so it can be used in another class.
     * @see WriteSymptomToFile
     * @return
     */

    //return the data in variable myMap so it can be used in another class
    public TreeMap<String, Integer> getMyMap() {
        return myMap;
    }
}