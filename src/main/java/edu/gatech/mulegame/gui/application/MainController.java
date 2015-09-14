package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
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
    private Label currentPlayer;

    @FXML
    private GridPane startPane;
    @FXML
    private GridPane diffPane;
    @FXML
    private GridPane tilePane;
    @FXML
    private GridPane playerConfig;


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





        // //The button event for the login button
        // loginButton.setOnAction(new EventHandler<ActionEvent>() {
        //
        //     public void handle(ActionEvent e)   {
        //         System.out.println("This button works");
        //     }
        // });
        }
    }
