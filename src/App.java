import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;



public class App {
    public static void main(String[] args) throws Exception {
        File f = new File(
            "/Users/roymontemayor/Desktop/Rice/Spring 2023/COMP 380/Homework 1/BlackJack/src/COMP_380_HW_1_Example_CSV.csv");
        File newFile = new File("/Users/roymontemayor/Desktop/Rice/Spring 2023/COMP 380/Homework 1/COMP_380_HW_1_Solutions.csv");

        BufferedReader br = new BufferedReader(new FileReader(f));
        BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));

        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
            String[] columns = line.split(",");
            String dealerCard = line.substring(1, 6);
            int ourStart = 0;
            int finishSearch = 0;
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
            String ourCard = line.substring(ourStart);
            while (ourCard.charAt(ourCard.length() - 1) == ',') {
                if (ourCard.charAt(ourCard.length() - 1) == ',') {
                    ourCard = ourCard.substring(0, ourCard.length() - 1);
                }
            }

            //    ourCard = "," + ourCard;
            //           System.out.println(ourCard);
            String dealerSuit = String.valueOf(dealerCard.charAt(3));
            String ourSuit = "";

            String dealerVal = String.valueOf(dealerCard.charAt(4));
            String ourVal = "";

            int adjust = 0;
            boolean canAdd = true;
            for (int chr = 0; chr < ourCard.length(); chr++) {
                if (ourCard.charAt(chr) == ',') {
                    adjust += 1;
                    canAdd = true;
                }
                if (canAdd == true) {
                    ourSuit += ourCard.charAt(adjust * 6 + 3);
                    ourVal += ourCard.charAt(adjust * 6 + 4);
                    canAdd = false;
                }
            }

            int softHandTotalVal = 0;
            int hardHandTotalVal = 0;
            for (int j = 0; j < ourVal.length(); j++) {
                if (ourVal.charAt(j) == '1') {
                    hardHandTotalVal += 1;
                    softHandTotalVal += 11;
                } else if (ourVal.charAt(j) == 'A' || ourVal.charAt(j) == 'J' || ourVal.charAt(j) == 'D'
                    || ourVal.charAt(j) == 'E' || ourVal.charAt(j) == 'K') {
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

            if (hardHandTotalVal > 11) {
                System.out.println("STAY");
                columns[0] = "STAY";
            } else {
                if (softHandTotalVal > 17) {
                    System.out.println("STAY");
                    columns[0] = "STAY";
                } else {
                    System.out.println("HIT");
                    columns[0] = "HIT";
                }
            }

            bw.write(String.join(",", columns));
            bw.newLine();

        }

        br.close();
        bw.close();

    }
}
