/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author tcm5343
 */
public class Game {
    private String userInput;
    private String computerInput;
    private static final String[] OPTIONS 
            = new String[]{"Rock","Paper","Scissors"};
    
    // default constructor
    Game(){
        // a random number is generated, the string equivalent is found, it is 
        // then set to computerInput
        setComputerInput(getComputerInput(generateAnswer()));
    }
    
    // custom constructor
    Game(String user){
        // a random number is generated, the string equivalent is found, it is 
        // then set to computerInput
        setComputerInput(getComputerInput(generateAnswer()));
        userInput = user;
    }
    
    public int generateAnswer() {
        // generates random number between 0 and 2 inclusive
        int result = 0 + (int)(Math.random() * ((2 - 0) + 1));
        return result;
    }
    
    public String evaluate(){
        // tests if values are the same before entering the switch
       if (this.userInput.equals(this.computerInput)) {
                   return "You Tied";
               }
       
       // tests user input compared to computer input
        switch(this.userInput)
        {
              // user selects rock (0)
           case "Rock" :
               if ("Paper".equals(this.computerInput)) {
                   return "You Lost";
               }
               else{
                   return "You Won";
               }       

           case "Paper" :
               if ("Scissors".equals(this.computerInput)) {
                   return "You Lost";
               }
               else{
                   return "You Won";
               }  
               
           case "Scissors" :
               if ("Rock".equals(this.computerInput)) {
                   return "You Lost";
               }
               else{
                   return "You Won";
               }  
               
           default : 
              return "Could not decide winner, reality is broken";
        }
    }
    
    // accessor and mutator methods
    public String getUserInput() {
        return userInput;
    }
    
    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
    
    public String getComputerInput(int index) {
        return OPTIONS[index];
    }
    
    // this method is not able to be used anywhere else but this class because
    // the computerInput is set when the object is constructed
    private void setComputerInput(String computerInput) {
        this.computerInput = computerInput;
    }
    
}
