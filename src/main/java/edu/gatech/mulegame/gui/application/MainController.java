package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


public class MainController implements Initializable {

    // @FXML // ResourceBundle that was given to the FXMLLoader
    // private ResourceBundle resources;
    //
    // @FXML // URL location of the FXML file that was given to the FXMLLoader
    // private URL location;

    @FXML // fx:id="loginButton"
    private Button startButton; // Value injected by FXMLLoader

    @FXML // fx:id="newUserButton"
    private Button easyMode; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button hardMode; // Value injected by FXMLLoader

    @FXML // fx:id="newUserButton"
    private Button mediumMode; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button mountainButton; // Value injected by FXMLLoader

    @FXML // fx:id="newUserButton"
    private Button riverButton; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button flatlandButton; // Value injected by FXMLLoader

    @FXML // fx:id="newUserButton"
    private Button flapperButton; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button leggiteButton; // Value injected by FXMLLoader

    @FXML // fx:id="newUserButton"
    private Button humanoidButton; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button mechtronButton; // Value injected by FXMLLoader

    @FXML // fx:id="newUserButton"
    private Button gollumerButton; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button packerButton; // Value injected by FXMLLoader

    @FXML // fx:id="newUserButton"
    private Button bonzoidButton; // Value injected by FXMLLoader

    @FXML // fx:id="loginButton"
    private Button spheroidButton; // Value injected by FXMLLoader

    @FXML
    private Slider playerCount;

    @FXML
    private Label currentPlayer;

    @FXML
    private GridPane startPane;
    @FXML
    private GridPane diffPane;
    @FXML
    private GridPane tilePane;
    @FXML
    private GridPane playerConfig;
    @FXML
    private TextField currentPlayerName;
    @FXML
    private Label dialog;


    int[] settings;
    int[] playerRace;
    String[] playerName;
    int count = 1;

    @FXML
    private void openPane2(ActionEvent e) {
        settings[0] = (int) playerCount.getValue();
        startPane.setVisible(false);
        diffPane.setVisible(true);
    }
    @FXML
    private void openPane3(ActionEvent e) {
        if (e.getSource().toString().equals("Button[id=easyMode, styleClass=button]'Easy'")) {
            settings[1] = 1;
        }
        if (e.getSource().toString().equals("Button[id=mediumMode, styleClass=button]'Medium'")) {
            settings[1] = 2;
        }
        if (e.getSource().toString().equals("Button[id=hardMode, styleClass=button]'Hard'")) {
            settings[1] = 3;
        }
        diffPane.setVisible(false);
        tilePane.setVisible(true);
    }

    @FXML
    private void openPane4(ActionEvent e) {
        if (e.getSource().toString().equals("Button[id=flatlandButton, styleClass=button]'Flatland'")) {
            settings[2] = 1;
        }
        if (e.getSource().toString().equals("Button[id=riverButton, styleClass=button]'River'")) {
            settings[2] = 2;
        }
        if (e.getSource().toString().equals("Button[id=mountainButton, styleClass=button]'Mountain'")) {
            settings[2] = 3;
        }
        tilePane.setVisible(false);
        playerConfig.setVisible(true);
        currentPlayer.setText("Player" + count++);
    }
    @FXML
    private void playerDone(ActionEvent e) {
        if (count < 4 + 1) {
            if (e.getSource().toString().equals("Button[id=mechtronButton, styleClass=button]'MECHTRON'")) {
                String someNameHolder = currentPlayerName.getText();
                currentPlayerName.clear();
                int raceSettingHolder = 0;
                dialog.setText("Player " + (count - 1) + "chose MECHTRON!\n Player"  + count + " is choosing now!");
                currentPlayer.setText("Player" + count++);
            }
            if (e.getSource().toString().equals("Button[id=gollumerButton, styleClass=button]'GOLLUMER'")) {
                String someNameHolder = currentPlayerName.getText();
                currentPlayerName.clear();
                int raceSettingHolder = 1;
                dialog.setText("Player " + (count - 1) + "chose GOLLUMER!\n Player"+ count + " is choosing now!");
                currentPlayer.setText("Player" + count++);
            }
            if (e.getSource().toString().equals("Button[id=packerButton, styleClass=button]'PACKER'")) {
                String someNameHolder = currentPlayerName.getText();
                currentPlayerName.clear();
                int raceSettingHolder = 2;
                dialog.setText("Player " + (count - 1) + "chose PACKER!\n Player"+ count + " is choosing now!");
                currentPlayer.setText("Player" + count++);
            }
            if (e.getSource().toString().equals("Button[id=bonzoidButton, styleClass=button]'BONZOID'")) {
                String someNameHolder = currentPlayerName.getText();
                currentPlayerName.clear();
                int raceSettingHolder = 3;
                dialog.setText("Player " + (count - 1) + "chose BONZOID!\n Player"+ count + " is choosing now!");
                currentPlayer.setText("Player" + count++);
            }
            if (e.getSource().toString().equals("Button[id=spheroidButton, styleClass=button]'SPHEROID'")) {
                String someNameHolder = currentPlayerName.getText();
                currentPlayerName.clear();
                int raceSettingHolder = 4;
                dialog.setText("Player " + (count - 1) + "chose SPHEROID!\n Player"+ count + " is choosing now!");
                currentPlayer.setText("Player" + count++);
            }
            if (e.getSource().toString().equals("Button[id=flapperButton, styleClass=button]'FLAPPER'")) {
                String someNameHolder = currentPlayerName.getText();
                currentPlayerName.clear();
                int raceSettingHolder = 5;
                dialog.setText("Player " + (count - 1) + "chose FLAPPER!\n Player"+ count + " is choosing now!");
                currentPlayer.setText("Player" + count++);
            }
            if (e.getSource().toString().equals("Button[id=leggiteButton, styleClass=button]'LEGGITE'")) {
                String someNameHolder = currentPlayerName.getText();
                currentPlayerName.clear();
                int raceSettingHolder = 6;
                dialog.setText("Player " + (count - 1) + "chose LEGGITE!\n Player"+ count + " is choosing now!");
                currentPlayer.setText("Player" + count++);
            }
            if (e.getSource().toString().equals("Button[id=humanoidButton, styleClass=button]'HUMANOID'")) {
                String someNameHolder = currentPlayerName.getText();
                currentPlayerName.clear();
                int raceSettingHolder = 7;
                dialog.setText("Player " + (count - 1) + "chose HUMANOID!\n Player"+ count + " is choosing now!");
                currentPlayer.setText("Player" + count++);
            }
        } else {

            playerConfig.setVisible(false);
            startPane.setVisible(true);
            count = 1;
        }

    }

    public void initialize(URL location, ResourceBundle resources) {
        assert startButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert easyMode != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert hardMode != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert mediumMode != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert riverButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert flatlandButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert flapperButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert leggiteButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert humanoidButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert mechtronButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert gollumerButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert packerButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert bonzoidButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert spheroidButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert currentPlayer != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert startPane != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert diffPane != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert tilePane != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";
        assert playerConfig != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

        startPane.setVisible(true);
        diffPane.setVisible(false);
        tilePane.setVisible(false);
        playerConfig.setVisible(false);

        settings = new int[10];





        // //The button event for the login button
        // loginButton.setOnAction(new EventHandler<ActionEvent>() {
        //
        //     public void handle(ActionEvent e)   {
        //         System.out.println("This button works");
        //     }
        // });
        }
    }
