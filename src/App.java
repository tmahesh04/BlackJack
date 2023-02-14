import java.io.*;
import java.util.Hashtable;

public class App {
    /**
     * Method to parse and describe the hit and stay naive blackjack method. 
     * @param inFile - the csv that we want to read and determine hit or stay - absolute path
     * @param outFile - the new csv file that we want - absolute path
     * @throws IOException -File Error
     * @throws NullPointerException - Line unable to be parsed
     */
    public static void bjCalc(File inFile, File outFile) throws IOException, NullPointerException{
        //init the reader and writer
        BufferedReader br = null;
        BufferedWriter bw = null;

        Hashtable<String, String[]> hardVals = new Hashtable<>();
        Hashtable<String, String[]> softVals = new Hashtable<>();
        Hashtable<String, String> doubleVals = new Hashtable<>();

        hardVals.put("21A", new String[]{"STAY", "STAY"});
        hardVals.put("212", new String[]{"STAY", "STAY"});
        hardVals.put("213", new String[]{"STAY", "STAY"});
        hardVals.put("214", new String[]{"STAY", "STAY"});
        hardVals.put("215", new String[]{"STAY", "STAY"});
        hardVals.put("216", new String[]{"STAY", "STAY"});
        hardVals.put("217", new String[]{"STAY", "STAY"});
        hardVals.put("218", new String[]{"STAY", "STAY"});
        hardVals.put("219", new String[]{"STAY", "STAY"});
        hardVals.put("2110", new String[]{"STAY", "STAY"});
        hardVals.put("20A", new String[]{"STAY", "STAY"});
        hardVals.put("202", new String[]{"STAY", "STAY"});
        hardVals.put("203", new String[]{"STAY", "STAY"});
        hardVals.put("204", new String[]{"STAY", "STAY"});
        hardVals.put("205", new String[]{"STAY", "STAY"});
        hardVals.put("206", new String[]{"STAY", "STAY"});
        hardVals.put("207", new String[]{"STAY", "STAY"});
        hardVals.put("208", new String[]{"STAY", "STAY"});
        hardVals.put("209", new String[]{"STAY", "STAY"});
        hardVals.put("2010", new String[]{"STAY", "STAY"});
        hardVals.put("19A", new String[]{"STAY", "STAY"});
        hardVals.put("192", new String[]{"STAY", "STAY"});
        hardVals.put("193", new String[]{"STAY", "STAY"});
        hardVals.put("194", new String[]{"STAY", "STAY"});
        hardVals.put("195", new String[]{"STAY", "STAY"});
        hardVals.put("196", new String[]{"STAY", "STAY"});
        hardVals.put("197", new String[]{"STAY", "STAY"});
        hardVals.put("198", new String[]{"STAY", "STAY"});
        hardVals.put("199", new String[]{"STAY", "STAY"});
        hardVals.put("1910", new String[]{"STAY", "STAY"});
        hardVals.put("18A", new String[]{"STAY", "STAY"});
        hardVals.put("182", new String[]{"STAY", "STAY"});
        hardVals.put("183", new String[]{"STAY", "STAY"});
        hardVals.put("184", new String[]{"STAY", "STAY"});
        hardVals.put("185", new String[]{"STAY", "STAY"});
        hardVals.put("186", new String[]{"STAY", "STAY"});
        hardVals.put("187", new String[]{"STAY", "STAY"});
        hardVals.put("188", new String[]{"STAY", "STAY"});
        hardVals.put("189", new String[]{"STAY", "STAY"});
        hardVals.put("1810", new String[]{"STAY", "STAY"});
        hardVals.put("17A", new String[]{"SURRENDER", "STAY"});
        hardVals.put("172", new String[]{"STAY", "STAY"});
        hardVals.put("173", new String[]{"STAY", "STAY"});
        hardVals.put("174", new String[]{"STAY", "STAY"});
        hardVals.put("175", new String[]{"STAY", "STAY"});
        hardVals.put("176", new String[]{"STAY", "STAY"});
        hardVals.put("177", new String[]{"STAY", "STAY"});
        hardVals.put("178", new String[]{"STAY", "STAY"});
        hardVals.put("179", new String[]{"STAY", "STAY"});
        hardVals.put("1710", new String[]{"STAY", "STAY"});
        hardVals.put("17K", new String[]{"STAY", "STAY"});
        hardVals.put("16A", new String[]{"SURRENDER", "HIT"});
        hardVals.put("162", new String[]{"STAY", "STAY"});
        hardVals.put("163", new String[]{"STAY", "STAY"});
        hardVals.put("164", new String[]{"STAY", "STAY"});
        hardVals.put("165", new String[]{"STAY", "STAY"});
        hardVals.put("166", new String[]{"STAY", "STAY"});
        hardVals.put("167", new String[]{"HIT", "HIT"});
        hardVals.put("168", new String[]{"HIT", "HIT"});
        hardVals.put("169", new String[]{"SURRENDER", "HIT"});
        hardVals.put("1610", new String[]{"SURRENDER", "HIT"});
        hardVals.put("15A", new String[]{"SURRENDER", "HIT"});
        hardVals.put("152", new String[]{"STAY", "STAY"});
        hardVals.put("153", new String[]{"STAY", "STAY"});
        hardVals.put("154", new String[]{"STAY", "STAY"});
        hardVals.put("155", new String[]{"STAY", "STAY"});
        hardVals.put("156", new String[]{"STAY", "STAY"});
        hardVals.put("157", new String[]{"HIT", "HIT"});
        hardVals.put("158", new String[]{"HIT", "HIT"});
        hardVals.put("159", new String[]{"HIT", "HIT"});
        hardVals.put("1510", new String[]{"SURRENDER", "HIT"});
        hardVals.put("14A", new String[]{"HIT", "HIT"});
        hardVals.put("142", new String[]{"STAY", "STAY"});
        hardVals.put("143", new String[]{"STAY", "STAY"});
        hardVals.put("144", new String[]{"STAY", "STAY"});
        hardVals.put("145", new String[]{"STAY", "STAY"});
        hardVals.put("146", new String[]{"STAY", "STAY"});
        hardVals.put("147", new String[]{"HIT", "HIT"});
        hardVals.put("148", new String[]{"HIT", "HIT"});
        hardVals.put("149", new String[]{"HIT", "HIT"});
        hardVals.put("1410", new String[]{"HIT", "HIT"});
        hardVals.put("13A", new String[]{"HIT", "HIT"});
        hardVals.put("132", new String[]{"STAY", "STAY"});
        hardVals.put("133", new String[]{"STAY", "STAY"});
        hardVals.put("134", new String[]{"STAY", "STAY"});
        hardVals.put("135", new String[]{"STAY", "STAY"});
        hardVals.put("136", new String[]{"STAY", "STAY"});
        hardVals.put("137", new String[]{"HIT", "HIT"});
        hardVals.put("138", new String[]{"HIT", "HIT"});
        hardVals.put("139", new String[]{"HIT", "HIT"});
        hardVals.put("1310", new String[]{"HIT", "HIT"});
        hardVals.put("12A", new String[]{"HIT", "HIT"});
        hardVals.put("122", new String[]{"HIT", "HIT"});
        hardVals.put("123", new String[]{"HIT", "HIT"});
        hardVals.put("124", new String[]{"STAY", "STAY"});
        hardVals.put("125", new String[]{"STAY", "STAY"});
        hardVals.put("126", new String[]{"STAY", "STAY"});
        hardVals.put("127", new String[]{"HIT", "HIT"});
        hardVals.put("128", new String[]{"HIT", "HIT"});
        hardVals.put("129", new String[]{"HIT", "HIT"});
        hardVals.put("1210", new String[]{"HIT", "HIT"});
        hardVals.put("11A", new String[]{"DOUBLE", "HIT"});
        hardVals.put("112", new String[]{"DOUBLE", "HIT"});
        hardVals.put("113", new String[]{"DOUBLE", "HIT"});
        hardVals.put("114", new String[]{"DOUBLE", "HIT"});
        hardVals.put("115", new String[]{"DOUBLE", "HIT"});
        hardVals.put("116", new String[]{"DOUBLE", "HIT"});
        hardVals.put("117", new String[]{"DOUBLE", "HIT"});
        hardVals.put("118", new String[]{"DOUBLE", "HIT"});
        hardVals.put("119", new String[]{"DOUBLE", "HIT"});
        hardVals.put("1110", new String[]{"DOUBLE", "HIT"});
        hardVals.put("10A", new String[]{"HIT", "HIT"});
        hardVals.put("102", new String[]{"DOUBLE", "HIT"});
        hardVals.put("103", new String[]{"DOUBLE", "HIT"});
        hardVals.put("104", new String[]{"DOUBLE", "HIT"});
        hardVals.put("105", new String[]{"DOUBLE", "HIT"});
        hardVals.put("106", new String[]{"DOUBLE", "HIT"});
        hardVals.put("107", new String[]{"DOUBLE", "HIT"});
        hardVals.put("108", new String[]{"DOUBLE", "HIT"});
        hardVals.put("109", new String[]{"DOUBLE", "HIT"});
        hardVals.put("1010", new String[]{"HIT", "HIT"});
        hardVals.put("9A", new String[]{"HIT", "HIT"});
        hardVals.put("92", new String[]{"HIT", "HIT"});
        hardVals.put("93", new String[]{"DOUBLE", "HIT"});
        hardVals.put("94", new String[]{"DOUBLE", "HIT"});
        hardVals.put("95", new String[]{"DOUBLE", "HIT"});
        hardVals.put("96", new String[]{"DOUBLE", "HIT"});
        hardVals.put("97", new String[]{"HIT", "HIT"});
        hardVals.put("98", new String[]{"HIT", "HIT"});
        hardVals.put("99", new String[]{"HIT", "HIT"});
        hardVals.put("910", new String[]{"HIT", "HIT"});
        hardVals.put("8A", new String[]{"HIT", "HIT"});
        hardVals.put("82", new String[]{"HIT", "HIT"});
        hardVals.put("83", new String[]{"HIT", "HIT"});
        hardVals.put("84", new String[]{"HIT", "HIT"});
        hardVals.put("85", new String[]{"HIT", "HIT"});
        hardVals.put("86", new String[]{"HIT", "HIT"});
        hardVals.put("87", new String[]{"HIT", "HIT"});
        hardVals.put("88", new String[]{"HIT", "HIT"});
        hardVals.put("89", new String[]{"HIT", "HIT"});
        hardVals.put("810", new String[]{"HIT", "HIT"});
        hardVals.put("7A", new String[]{"HIT", "HIT"});
        hardVals.put("72", new String[]{"HIT", "HIT"});
        hardVals.put("73", new String[]{"HIT", "HIT"});
        hardVals.put("74", new String[]{"HIT", "HIT"});
        hardVals.put("75", new String[]{"HIT", "HIT"});
        hardVals.put("76", new String[]{"HIT", "HIT"});
        hardVals.put("77", new String[]{"HIT", "HIT"});
        hardVals.put("78", new String[]{"HIT", "HIT"});
        hardVals.put("79", new String[]{"HIT", "HIT"});
        hardVals.put("710", new String[]{"HIT", "HIT"});
        hardVals.put("6A", new String[]{"HIT", "HIT"});
        hardVals.put("62", new String[]{"HIT", "HIT"});
        hardVals.put("63", new String[]{"HIT", "HIT"});
        hardVals.put("64", new String[]{"HIT", "HIT"});
        hardVals.put("65", new String[]{"HIT", "HIT"});
        hardVals.put("66", new String[]{"HIT", "HIT"});
        hardVals.put("67", new String[]{"HIT", "HIT"});
        hardVals.put("68", new String[]{"HIT", "HIT"});
        hardVals.put("69", new String[]{"HIT", "HIT"});
        hardVals.put("610", new String[]{"HIT", "HIT"});
        hardVals.put("5A", new String[]{"HIT", "HIT"});
        hardVals.put("52", new String[]{"HIT", "HIT"});
        hardVals.put("53", new String[]{"HIT", "HIT"});
        hardVals.put("54", new String[]{"HIT", "HIT"});
        hardVals.put("55", new String[]{"HIT", "HIT"});
        hardVals.put("56", new String[]{"HIT", "HIT"});
        hardVals.put("57", new String[]{"HIT", "HIT"});
        hardVals.put("58", new String[]{"HIT", "HIT"});
        hardVals.put("59", new String[]{"HIT", "HIT"});
        hardVals.put("510", new String[]{"HIT", "HIT"});

        softVals.put("20A", new String[]{"STAY", "STAY"});
        softVals.put("202", new String[]{"STAY", "STAY"});
        softVals.put("203", new String[]{"STAY", "STAY"});
        softVals.put("204", new String[]{"STAY", "STAY"});
        softVals.put("205", new String[]{"STAY", "STAY"});
        softVals.put("206", new String[]{"STAY", "STAY"});
        softVals.put("207", new String[]{"STAY", "STAY"});
        softVals.put("208", new String[]{"STAY", "STAY"});
        softVals.put("209", new String[]{"STAY", "STAY"});
        softVals.put("2010", new String[]{"STAY", "STAY"});
        softVals.put("19A", new String[]{"STAY", "STAY"});
        softVals.put("192", new String[]{"STAY", "STAY"});
        softVals.put("193", new String[]{"STAY", "STAY"});
        softVals.put("194", new String[]{"STAY", "STAY"});
        softVals.put("195", new String[]{"STAY", "STAY"});
        softVals.put("196", new String[]{"DOUBLE", "HIT"});
        softVals.put("197", new String[]{"STAY", "STAY"});
        softVals.put("198", new String[]{"STAY", "STAY"});
        softVals.put("199", new String[]{"STAY", "STAY"});
        softVals.put("1910", new String[]{"STAY", "STAY"});
        softVals.put("18A", new String[]{"HIT", "HIT"});
        softVals.put("182", new String[]{"DOUBLE", "STAY"});
        softVals.put("183", new String[]{"DOUBLE", "STAY"});
        softVals.put("184", new String[]{"DOUBLE", "STAY"});
        softVals.put("185", new String[]{"DOUBLE", "STAY"});
        softVals.put("186", new String[]{"DOUBLE", "STAY"});
        softVals.put("187", new String[]{"STAY", "STAY"});
        softVals.put("188", new String[]{"STAY", "STAY"});
        softVals.put("189", new String[]{"HIT", "HIT"});
        softVals.put("1810", new String[]{"HIT", "HIT"});
        softVals.put("17A", new String[]{"HIT", "HIT"});
        softVals.put("172", new String[]{"HIT", "HIT"});
        softVals.put("173", new String[]{"DOUBLE", "HIT"});
        softVals.put("174", new String[]{"DOUBLE", "HIT"});
        softVals.put("175", new String[]{"DOUBLE", "HIT"});
        softVals.put("176", new String[]{"DOUBLE", "HIT"});
        softVals.put("177", new String[]{"HIT", "HIT"});
        softVals.put("178", new String[]{"HIT", "HIT"});
        softVals.put("179", new String[]{"HIT", "HIT"});
        softVals.put("1710", new String[]{"HIT", "HIT"});
        softVals.put("16A", new String[]{"HIT", "HIT"});
        softVals.put("162", new String[]{"HIT", "HIT"});
        softVals.put("163", new String[]{"HIT", "HIT"});
        softVals.put("164", new String[]{"DOUBLE", "HIT"});
        softVals.put("165", new String[]{"DOUBLE", "HIT"});
        softVals.put("166", new String[]{"DOUBLE", "HIT"});
        softVals.put("167", new String[]{"HIT", "HIT"});
        softVals.put("168", new String[]{"HIT", "HIT"});
        softVals.put("169", new String[]{"HIT", "HIT"});
        softVals.put("1610", new String[]{"HIT", "HIT"});
        softVals.put("15A", new String[]{"HIT", "HIT"});
        softVals.put("152", new String[]{"HIT", "HIT"});
        softVals.put("153", new String[]{"HIT", "HIT"});
        softVals.put("154", new String[]{"DOUBLE", "HIT"});
        softVals.put("155", new String[]{"DOUBLE", "HIT"});
        softVals.put("156", new String[]{"DOUBLE", "HIT"});
        softVals.put("157", new String[]{"HIT", "HIT"});
        softVals.put("158", new String[]{"HIT", "HIT"});
        softVals.put("159", new String[]{"HIT", "HIT"});
        softVals.put("1510", new String[]{"HIT", "HIT"});
        softVals.put("14A", new String[]{"HIT", "HIT"});
        softVals.put("142", new String[]{"HIT", "HIT"});
        softVals.put("143", new String[]{"HIT", "HIT"});
        softVals.put("144", new String[]{"HIT", "HIT"});
        softVals.put("145", new String[]{"DOUBLE", "HIT"});
        softVals.put("146", new String[]{"DOUBLE", "HIT"});
        softVals.put("147", new String[]{"HIT", "HIT"});
        softVals.put("148", new String[]{"HIT", "HIT"});
        softVals.put("149", new String[]{"HIT", "HIT"});
        softVals.put("1410", new String[]{"HIT", "HIT"});
        softVals.put("13A", new String[]{"HIT", "HIT"});
        softVals.put("132", new String[]{"HIT", "HIT"});
        softVals.put("133", new String[]{"HIT", "HIT"});
        softVals.put("134", new String[]{"HIT", "HIT"});
        softVals.put("135", new String[]{"DOUBLE", "HIT"});
        softVals.put("136", new String[]{"DOUBLE", "HIT"});
        softVals.put("137", new String[]{"HIT", "HIT"});
        softVals.put("138", new String[]{"HIT", "HIT"});
        softVals.put("139", new String[]{"HIT", "HIT"});
        softVals.put("1310", new String[]{"HIT", "HIT"});

        doubleVals.put("AA", "SPLIT");
        doubleVals.put("A2", "SPLIT");
        doubleVals.put("A3", "SPLIT");
        doubleVals.put("A4", "SPLIT");
        doubleVals.put("A5", "SPLIT");
        doubleVals.put("A6", "SPLIT");
        doubleVals.put("A7", "SPLIT");
        doubleVals.put("A8", "SPLIT");
        doubleVals.put("A9", "SPLIT");
        doubleVals.put("A10", "SPLIT");
        doubleVals.put("10A", "STAY");
        doubleVals.put("102", "STAY");
        doubleVals.put("103", "STAY");
        doubleVals.put("104", "STAY");
        doubleVals.put("105", "STAY");
        doubleVals.put("106", "STAY");
        doubleVals.put("107", "STAY");
        doubleVals.put("108", "STAY");
        doubleVals.put("109", "STAY");
        doubleVals.put("1010", "STAY");
        doubleVals.put("JA", "STAY");
        doubleVals.put("J2", "STAY");
        doubleVals.put("J3", "STAY");
        doubleVals.put("J4", "STAY");
        doubleVals.put("J5", "STAY");
        doubleVals.put("J6", "STAY");
        doubleVals.put("J7", "STAY");
        doubleVals.put("J8", "STAY");
        doubleVals.put("J9", "STAY");
        doubleVals.put("J10", "STAY");
        doubleVals.put("QA", "STAY");
        doubleVals.put("Q2", "STAY");
        doubleVals.put("Q3", "STAY");
        doubleVals.put("Q4", "STAY");
        doubleVals.put("Q5", "STAY");
        doubleVals.put("Q6", "STAY");
        doubleVals.put("Q7", "STAY");
        doubleVals.put("Q8", "STAY");
        doubleVals.put("Q9", "STAY");
        doubleVals.put("Q10", "STAY");
        doubleVals.put("KA", "STAY");
        doubleVals.put("K2", "STAY");
        doubleVals.put("K3", "STAY");
        doubleVals.put("K4", "STAY");
        doubleVals.put("K5", "STAY");
        doubleVals.put("K6", "STAY");
        doubleVals.put("K7", "STAY");
        doubleVals.put("K8", "STAY");
        doubleVals.put("K9", "STAY");
        doubleVals.put("K10", "STAY");
        doubleVals.put("9A", "STAY");
        doubleVals.put("92", "SPLIT");
        doubleVals.put("93", "SPLIT");
        doubleVals.put("94", "SPLIT");
        doubleVals.put("95", "SPLIT");
        doubleVals.put("96", "SPLIT");
        doubleVals.put("97", "STAY");
        doubleVals.put("98", "SPLIT");
        doubleVals.put("99", "SPLIT");
        doubleVals.put("910", "STAY");
        doubleVals.put("8A", "SURRENDER");
        doubleVals.put("82", "SPLIT");
        doubleVals.put("83", "SPLIT");
        doubleVals.put("84", "SPLIT");
        doubleVals.put("85", "SPLIT");
        doubleVals.put("86", "SPLIT");
        doubleVals.put("87", "SPLIT");
        doubleVals.put("88", "SPLIT");
        doubleVals.put("89", "SPLIT");
        doubleVals.put("810", "SPLIT");
        doubleVals.put("7A", "HIT");
        doubleVals.put("72", "SPLIT");
        doubleVals.put("73", "SPLIT");
        doubleVals.put("74", "SPLIT");
        doubleVals.put("75", "SPLIT");
        doubleVals.put("76", "SPLIT");
        doubleVals.put("77", "SPLIT");
        doubleVals.put("78", "HIT");
        doubleVals.put("79", "HIT");
        doubleVals.put("710", "HIT");
        doubleVals.put("6A", "HIT");
        doubleVals.put("62", "SPLIT");
        doubleVals.put("63", "SPLIT");
        doubleVals.put("64", "SPLIT");
        doubleVals.put("65", "SPLIT");
        doubleVals.put("66", "SPLIT");
        doubleVals.put("67", "HIT");
        doubleVals.put("68", "HIT");
        doubleVals.put("69", "HIT");
        doubleVals.put("610", "HIT");
        doubleVals.put("5A", "HIT");
        doubleVals.put("52", "DOUBLE");
        doubleVals.put("53", "DOUBLE");
        doubleVals.put("54", "DOUBLE");
        doubleVals.put("55", "DOUBLE");
        doubleVals.put("56", "DOUBLE");
        doubleVals.put("57", "DOUBLE");
        doubleVals.put("58", "DOUBLE");
        doubleVals.put("59", "DOUBLE");
        doubleVals.put("510", "HIT");
        doubleVals.put("4A", "HIT");
        doubleVals.put("42", "HIT");
        doubleVals.put("43", "HIT");
        doubleVals.put("44", "HIT");
        doubleVals.put("45", "SPLIT");
        doubleVals.put("46", "SPLIT");
        doubleVals.put("47", "HIT");
        doubleVals.put("48", "HIT");
        doubleVals.put("49", "HIT");
        doubleVals.put("410", "HIT");
        doubleVals.put("3A", "HIT");
        doubleVals.put("32", "SPLIT");
        doubleVals.put("33", "SPLIT");
        doubleVals.put("34", "SPLIT");
        doubleVals.put("35", "SPLIT");
        doubleVals.put("36", "SPLIT");
        doubleVals.put("37", "SPLIT");
        doubleVals.put("38", "HIT");
        doubleVals.put("39", "HIT");
        doubleVals.put("310", "HIT");
        doubleVals.put("2A", "HIT");
        doubleVals.put("22", "SPLIT");
        doubleVals.put("23", "SPLIT");
        doubleVals.put("24", "SPLIT");
        doubleVals.put("25", "SPLIT");
        doubleVals.put("26", "SPLIT");
        doubleVals.put("27", "SPLIT");
        doubleVals.put("28", "HIT");
        doubleVals.put("29", "HIT");
        doubleVals.put("210", "HIT");

        try {
            br = new BufferedReader(new FileReader(inFile));
            bw = new BufferedWriter(new FileWriter(outFile));

            String line;
            //iterate through all lines in csv
            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                int softHandTotalVal = 0;
                int hardHandTotalVal = 0;
                int handNumCount = 0;
                String pairVal = "";
                String dealerCard = "";
                //split columns for output
                String[] columns = line.split(",");
                //Check if we can parse the string
                if(line.charAt(0) == ',') {
                    //            System.out.println(line);
                    dealerCard = line.substring(5, 6);

                    int ourStart = 0;
                    int finishSearch = 0;
                    //identify the starting index of our cards
                    while (ourStart < line.length() && finishSearch < 8) {
                        if (line.charAt(ourStart) == ',') {
                            ourStart++;
                            finishSearch++;
                        } else if (line.charAt(ourStart) == '1') {
                            ourStart += 6;
                            finishSearch++;
                        }
                        // System.out.println(line.charAt(ourStart));
                        // System.out.println(ourStart + " " + finishSearch);
                    }
                    // System.out.println(line.length());
                    String ourCard = line.substring(ourStart);
                    //delete ending 2 commas if there are any
                    while (ourCard.charAt(ourCard.length() - 1) == ',') {
                        if (ourCard.charAt(ourCard.length() - 1) == ',') {
                            ourCard = ourCard.substring(0, ourCard.length() - 1);
                        }
                    }

                    //                String dealerSuit = String.valueOf(dealerCard.charAt(3));
                    //                String ourSuit = "";

                    //                String dealerVal = String.valueOf(dealerCard.charAt(4));
                    String ourVal = "";
                    //get the values from the hexcode of our cards
                    int adjust = 0;
                    boolean canAdd = true;
                    for (int chr = 0; chr < ourCard.length(); chr++) {
                        if (ourCard.charAt(chr) == ',') {
                            adjust += 1;
                            canAdd = true;
                        }
                        if (canAdd) {
                            //                        ourSuit += ourCard.charAt(adjust * 6 + 3);
//                            System.out.println(ourCard.charAt(adjust * 6 + 4));
                            ourVal += ourCard.charAt(adjust * 6 + 4);
                            canAdd = false;
                        }
                    }

                    handNumCount = ourVal.length();

                    //Check if our current hand is a pair and get the value
                    if (handNumCount == 2) {
                        if (ourVal.charAt(0) == ourVal.charAt(1)){
                            if (ourVal.charAt(0) == 'a') {
                                pairVal += "10";
                            }
                            else if (ourVal.charAt(0) == 'b') {
                                pairVal += "J";
                            }
                            else if (ourVal.charAt(0) == 'd') {
                                pairVal += "Q";
                            }
                            else if (ourVal.charAt(0) == 'e') {
                                pairVal += "K";
                            }
                            else if (ourVal.charAt(0) == '1') {
                                pairVal += "A";
                            }
                            else {
                                pairVal += ourVal.charAt(0);
                            }

                        }
                    }

                    //parse and make unumeric understandings of the card that we have for hard and soft hand total
                    boolean aceCounted = false;
                    for (int j = 0; j < ourVal.length(); j++) {
                        if (ourVal.charAt(j) == '1') {
                            hardHandTotalVal += 1;
                            if (!aceCounted) {
                                softHandTotalVal += 11;
                                aceCounted = true;
                            } else {
                                softHandTotalVal += 1;
                            }
                        } else if (ourVal.charAt(j) == 'A' || ourVal.charAt(j) == 'B'
                            || ourVal.charAt(j) == 'D'
                            || ourVal.charAt(j) == 'E' || ourVal.charAt(j) == 'b'
                            || ourVal.charAt(j) == 'a'
                            || ourVal.charAt(j) == 'd'
                            || ourVal.charAt(j) == 'e') {
                            hardHandTotalVal += 10;
                            softHandTotalVal += 10;
                        } else {
                            hardHandTotalVal +=
                                Integer.parseInt(String.valueOf(ourVal.charAt(j)));
                            softHandTotalVal +=
                                Integer.parseInt(String.valueOf(ourVal.charAt(j)));
                        }
                    }
//                                System.out.println("hard:" + hardHandTotalVal + " soft: " + softHandTotalVal);
                }

                System.out.println(hardHandTotalVal + "," + softHandTotalVal);
                System.out.println(dealerCard);
                System.out.println(pairVal);



                //naive algorithm for hitting or staying
                if (hardHandTotalVal == 0){
                    columns[0] = "";
                }
                else if (softHandTotalVal == 21 || hardHandTotalVal == 21) {
                    columns[0] = "STAY";
                }
                else if (!pairVal.equals("")) {
                    System.out.println("hi");
                    String keyVal = "";
                    if (dealerCard.equals("a") || dealerCard.equals("b") || dealerCard.equals("d") || dealerCard.equals("e")) {
                        keyVal = String.valueOf(pairVal) + "10";
                    }
                    else if (dealerCard.equals("1")) {
                        keyVal = (String.valueOf(pairVal) + "A");
                    }
                    else {
                        keyVal = (String.valueOf(pairVal) + dealerCard);
                    }
                    System.out.println(keyVal);
                    columns[0] = doubleVals.get(keyVal);
                }
                else if (softHandTotalVal != hardHandTotalVal && softHandTotalVal > 10 && softHandTotalVal <= 20) {
                    String keyVal = "";
                    if (dealerCard.equals("a") || dealerCard.equals("b") || dealerCard.equals("d") || dealerCard.equals("e")) {
                        keyVal = String.valueOf(softHandTotalVal) + "10";
                    }
                    else if (dealerCard.equals("1")) {
                        keyVal = String.valueOf(softHandTotalVal) + "A";
                    } else {
                        keyVal = (String.valueOf(softHandTotalVal) + dealerCard);
                    }
//                    System.out.println(keyVal);

                    if (handNumCount == 2) {
                        columns[0] = softVals.get(keyVal)[0];
                    } else {
                        columns[0] = softVals.get(keyVal)[1];
                    }
                } else {
                    String keyVal = "";
                    if (dealerCard.equals("a") || dealerCard.equals("b") || dealerCard.equals("d") || dealerCard.equals("e")) {
                        keyVal = String.valueOf(hardHandTotalVal) + "10";
                    }
                    else if (dealerCard.equals("1")) {
                        keyVal = String.valueOf(hardHandTotalVal) + "A";
                    } else {
                        keyVal = (String.valueOf(hardHandTotalVal) + dealerCard).toUpperCase();
                    }
                    if (handNumCount == 2){
                        columns[0] = hardVals.get(keyVal)[0];
                    } else {
                        columns[0] = hardVals.get(keyVal)[1];
                    }
                }
                //write to the new csv
                bw.write(String.join(",", columns));
                bw.newLine();

            }
        //catch possible exceptions
        } catch(IOException e){
            System.out.println("Error opening or writing to file: " + e);
        } catch(NullPointerException n){
            System.out.println("Null Pointer Exception: " + n);
        }

        br.close();
        bw.close();

    }

    public static void main(String[] args) throws Exception {
        //Define in and out file absolute paths
        File inFile = new File(
            "/Users/roymontemayor/Desktop/Rice/Spring 2023/COMP 380/BlackJack Software/BlackJack/HW2/table-samples-70000.csv");
        File outFile = new File(
            "/Users/roymontemayor/Desktop/Rice/Spring 2023/COMP 380/BlackJack Software/COMP_380_HW_2_Output.csv");

        bjCalc(inFile, outFile);

    }
}
