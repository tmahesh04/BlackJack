import java.io.*;

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

        try {
            br = new BufferedReader(new FileReader(inFile));
            bw = new BufferedWriter(new FileWriter(outFile));

            String line;
            //iterate through all lines in csv
            while ((line = br.readLine()) != null) {
                 System.out.println(line);
                int softHandTotalVal = 0;
                int hardHandTotalVal = 0;
                //split columns for output
                String[] columns = line.split(",");
                //Check if we can parse the string
                if(line.charAt(0) == ',') {
                    //            System.out.println(line);
                    //                String dealerCard = line.substring(1, 6);
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
                                System.out.println("hard:" + hardHandTotalVal + " soft: " + softHandTotalVal);
                }
                //naive algorithm for hitting or staying
                if (hardHandTotalVal == 0){
                    columns[0] = "";
                }
                else if (hardHandTotalVal > 11) {
                    columns[0] = "STAY";
                } else {
                    if (softHandTotalVal > 17) {
                        columns[0] = "STAY";
                    } else {
                        columns[0] = "HIT";
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
            "/Users/roymontemayor/Desktop/Rice/Spring 2023/COMP 380/Homework 1/COMP_380_HW1_Example.csv");
        File outFile = new File(
            "/Users/roymontemayor/Desktop/Rice/Spring 2023/COMP 380/Homework 1/COMP_380_HW_1_DoubleAce.csv");

        bjCalc(inFile, outFile);

    }
}
