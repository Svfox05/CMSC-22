/**
 * 
 */
package gui;

/**
 * @author Users/SV-Admin
 *
 */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RockPaperScissorsLizardSpock extends Frame{
 private Label choiceLabel;
 private Label userScore;
 private Label computeruterScore;
 private CheckboxGroup choice;

 private TextArea textResults;
 private Button button;
 private Dialog message;
 private TextField textfieldUScore;
 private TextField textfieldCScore;
 
 private int userChoice;
 private int computerChoice;
 private int playerScore = 0;
 private int computerScore = 0;
 private String userInput;
 private String computerInput;
 
 
 public RPSLS() {
	 
  setLayout(new FlowLayout());
  
  choiceLabel = new Label("Your Choice");
  choice = new CheckboxGroup();
  
  
  textResults = new TextArea("Results: \n", 10, 25);
    
  message = new Dialog(this, "GAME OVER!", Dialog.ModalityType.DOCUMENT_MODAL);
  message.setSize(400, 175);
  
    message.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    
    Button forMessage1 = new Button("YES");
    Button forMessage2 = new Button("NO");
    final Label gameOver = new Label("GAME OVER", Label.CENTER);
    
    forMessage1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerScore = 0;
                computerScore = 0;
                message.setVisible(false);
            }
        });
    
    forMessage2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    message.setLayout(new FlowLayout());
    message.add(gameOver);
    message.add(new Label("Another Round??\n", Label.CENTER));
    message.add(forMessage1);
    message.add(forMessage2);
    
    button = new Button("Rock-Paper-Scissors-Lizard-Spock");
    button.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Checkbox select = choice.getSelectedCheckbox();
                  
                  userInput = select.getLabel();
                  
                  if(userInput.equals("Rock")){
                      userChoice = 1;
                  } else if(userInput.equals("Paper")){
                      userChoice = 2;
                  } else if(userInput.equals("Scissors")){
                      userChoice = 3;
                  } else if(userInput.equals("Lizard")){
                      userChoice = 4;
                  } else if(userInput.equals("Spock")){
                      userChoice = 5;
                  }
                  textResults.append(String.format("\nPlayer selected: " + userInput));
                  
                  Random rand = new Random();
                  computerChoice = rand.nextInt(5) + 1;
                  
                  if(computerChoice == 1){
                      computerInput = "Rock";
                  } else if(computerChoice == 2){
                      computerInput = "Paper";
                  } else if(computerChoice == 3){
                      computerInput = "Scissors";
                  } else if(computerChoice == 4){
                      computerInput = "Lizard";
                  } else if(computerChoice == 5){
                      computerInput = "Spock";
                  }
                  textResults.append(String.format("\ncomputeruter selected: " + computerInput + "\n"));
                  
                  if(userChoice == 1){
                      if(computerChoice == 3 || computerChoice == 5){
                          playerScore++;
                      }
                      else if(userChoice != computerChoice){
                          computerScore++;
                      }
                  } else if(userChoice == 2){
                      if(computerChoice == 1 || computerChoice == 5){
                          playerScore++;
                      } else if(userChoice != computerChoice){
                          computerScore++;
                      }
                  } else if(userChoice == 3){
                      if(computerChoice == 2 || computerChoice == 4){
                          playerScore++;
                      } else if(userChoice != computerChoice){
                          computerScore++;
                      }
                  } else if(userChoice == 4){
                      if(computerChoice == 2 || computerChoice == 5){
                          playerScore++;
                      } else if(userChoice != computerChoice){
                          computerScore++;
                      }
                  } else if(userChoice == 5){
                      if(computerChoice == 1 || computerChoice == 3){
                          playerScore++;
                      } else if(userChoice != computerChoice){
                          computerScore++;
                      }
                  }
                  
                  textfieldUScore.setText(String.valueOf(userScore));
                  textfieldCScore.setText(String.valueOf(computerScore));
                  
                  if(playerScore == 5){
                      textResults.append("\nYOU WIN THIS ROUND!");
                      gameOver.setText(String.format("Game over! PLAYER Won. Congratulations!\n"));
                      message.setVisible(true);
                  } else if(computerScore == 5){
                      textResults.append("\nCOMPUTER WINS THIS ROUND!");
                      gameOver.setText(String.format("Game over! computerUTER won. Man you suck at this!\n"));
                      message.setVisible(true);
                  }
                  textfieldUScore.setText(String.valueOf(userScore));
                  textfieldCScore.setText(String.valueOf(computerScore));
                  
              }
      });

            userScore = new Label("Player Score: ");
            computeruterScore = new Label("Computer Score: ");
            textfieldUScore = new TextField("", 4);
            textfieldCScore = new TextField("", 4);

                  
    add(new Checkbox("Rock", choice, true));
    add(new Checkbox("Paper", choice, false));
    add(new Checkbox("Scissors", choice, false));
    add(new Checkbox("Lizard", choice, false));
    add(new Checkbox("Spock", choice, false));
    add(textResults);
    add(button);
    add(userScore);
    add(textfieldUScore);
    add(computeruterScore);
    add(textfieldCScore);

          setTitle("ROCK PAPER SCISSORS LIZARD SPOCK ");
          setSize(555, 275);
          setVisible(true);

          // closes window
          addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent we) {
                  System.exit(0);
              }
          });
          
   }
 
   public static void main(String[] args) {
    //executes the code and simulates the game
    RPSLS play = new RPSLS();
   }
}
