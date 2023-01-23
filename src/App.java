import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:/Users/thush/Desktop/College/Senior/s2/comp380/NaiveBlackJack/src/COMP_380_HW_1_Example_CSV.csv"));


        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        //    String line = ",1F0C8,,,,,,,1F0B5,1F0D3,1F0D2";
           String dealerCard = line.substring(1, 6);
           int ourStart = 0;
           int finishSearch = 0;
           while(ourStart < line.length() && finishSearch <8){
                if(line.charAt(ourStart) == ','){
                    ourStart ++;
                    finishSearch ++;
                } else if(line.charAt(ourStart) == '1'){
                    ourStart += 6;
                    finishSearch ++;
                }
                // System.out.println(line.charAt(ourStart));
                // System.out.println(ourStart + " " + finishSearch);
           }
           String ourCard = line.substring(ourStart);
           while(ourCard.charAt(ourCard.length() - 1) == ','){
                if(ourCard.charAt(ourCard.length() - 1) == ','){
                    ourCard = ourCard.substring(0, ourCard.length() - 1);
                }
           }

        //    ourCard = "," + ourCard;
           System.out.println(ourCard);
           String dealerSuit = String.valueOf(dealerCard.charAt(3));
           String ourSuit = "";
    
           String dealerVal = String.valueOf(dealerCard.charAt(4));
           String ourVal = "";

           int adjust = 0; 
           boolean canAdd = true;
           for(int chr = 0; chr < ourCard.length(); chr++){
            if(ourCard.charAt(chr) == ','){
                adjust += 1;
                canAdd = true;
            }
            if(canAdd == true){
                ourSuit += ourCard.charAt(adjust * 6 + 3);
                ourVal += ourCard.charAt(adjust * 6 + 4);
                canAdd = false;
            }
           }

           int softHandTotalVal = 0;
           int hardHandTotalVal = 0;
           for(int j = 0; j < ourVal.length(); j++){
            if(ourVal.charAt(j) == '1'){
                hardHandTotalVal += 1;
                softHandTotalVal += 11;
            }
            else if(ourVal.charAt(j) == 'J' || ourVal.charAt(j) == 'D' || ourVal.charAt(j) == 'E' || ourVal.charAt(j) == 'K'){
                hardHandTotalVal += 10;
                softHandTotalVal += 10;   
            }
            else{
                hardHandTotalVal += Integer.parseInt(String.valueOf(ourVal.charAt(j)));
                softHandTotalVal += Integer.parseInt(String.valueOf(ourVal.charAt(j)));
            }
           }
           System.out.println("hard:" + hardHandTotalVal + " soft: " +softHandTotalVal);
           if(hardHandTotalVal > 11){
            // System.out.println("STAY");
           } 
           else{
            if(softHandTotalVal > 17){
                // System.out.println("STAY");
            }
            else{
                // System.out.println("HIT");
            }
           }
        }
    }
}
// }
