/* Created By Rifqihz */

public class Translator {

    private String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String inputUser;
    private byte option;
    private boolean decodeAll = false;
    private int shift = 0;

    
    // SET    
    // Set User Option
    public void SetOption(byte input) {
        if (input == 1 || input == 2) {
            option = input;
        }
    }
    // Set Shift
    public void setShift(int shift){
        this.shift = shift;
    }    
    // Set Decode All possibilities or not
    public void setDecodeoption(String input){
        decodeAll = input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES");
    }
     
    // Set user input
    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    //set Key if wanted
    public void setNewKey(String key) {
        this.key = key.toUpperCase();
    }
    
    // GET
    // Get key length
    public int getKeyLength(){
        return key.length();
    }
    
    // Boolean    
    // Check if user input shift is right
    public boolean checkUserShiftFormat(int shift){
        return shift >= 0 && shift <= key.length();
    }
    
    // Check User Choice format
    public boolean checkUserChoiceFormat(byte userChoice) {
        return userChoice == 1 || userChoice == 2;
    }    
    
    // Check if the input format is correct
    public boolean checkYesOrNoFormat(String input){
        return input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES") || input.equalsIgnoreCase("N") || input.equalsIgnoreCase("NO");
    }
    
    // Check if user ask to decode all possiblities or not
    public boolean decodeAllPos(String input){
        return input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES");
    }
    
    // Check if user want to use default key or not
    public boolean useDefaultKey(String input){
        return input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES");
    }           
    
    
    
    // Print Option list
    public void printOptionList() {
        System.out.println("|| Choice || ");
        System.out.println("1. Encode");
        System.out.println("2. Decode");
    }        
    
    // Print Default Key
    public void printDefaultKey(){
        System.out.println("Our default key is : " + key);
    }        
    
    // Print result in UpperCase
    public void printResult() {
        System.out.println("=== Result ===");
        if(option == 1){
            System.out.println("Your plain text  : " + inputUser.toUpperCase());
            System.out.println("Your cipher text : " + Encode().toUpperCase());
        }else if(option == 2){
            if(decodeAll){
                System.out.println("Your cipher text : " + inputUser.toUpperCase());
                System.out.println("Your plain text : ");
                for (int i = 0; i < key.length(); i++) {
                    shift = i;
                    System.out.println("Shift : " + i + " -> " + Decode().toUpperCase());
                }
            }else{
                System.out.println("Your cipher text : " + inputUser.toUpperCase());
                System.out.println("Your plain text : " + Decode().toUpperCase());
            }
        }
    }

    
    // Encode the plain text
    private String Encode() {
        String outputEncode = "";
        int saveShift = shift;
        for (int j = 0; j < inputUser.length(); j++) {
            boolean getShift = false;
            // Check the char get shift or not
            for (int k = 0; k < key.length(); k++) {
                if (inputUser.toUpperCase().charAt(j) == key.charAt(k)) {
                    getShift = true;
                    shift = k + shift;
                    break;
                }
            }
            if (getShift) {
                if (shift >= key.length()) {
                    outputEncode += key.charAt(shift - key.length());
                } else {
                    outputEncode += key.charAt(shift);
                }
            } else {
                outputEncode += inputUser.charAt(j);
            }
            shift = saveShift;
        }
        return outputEncode;
    }

    
    // Decode the plain text
    private String Decode() {
        String outputDecode = "";
        int saveShift = shift;
        for (int j = 0; j < inputUser.length(); j++) {
            boolean getShift = false;            
            // Check the char get shift or not
            for (int k = 0; k < key.length(); k++) {
                if (inputUser.toUpperCase().charAt(j) == key.charAt(k)) {
                    getShift = true;
                    shift = k - shift;
                    break;
                }
            }
            if (getShift) {
                if (shift < 0) {
                    outputDecode += key.charAt(key.length() + shift);
                } else {
                    outputDecode += key.charAt(shift);
                }
            } else {
                outputDecode += inputUser.charAt(j);
            }
            shift = saveShift;
        }
        return outputDecode;
    }

}
