package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


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
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private GridPane mapPane;
    @FXML
    private GridPane townPane;
    @FXML
    private Label mapPaneDialog;


    int[] settings = new int[3];
    int[] playerRace = new int[4];
    String[] playerName = new String[4];
    int count = 0;
    int numOfPlayer;
    Color[] playerColor = new Color[4];
    Button[][] buttons = new Button[4][4];
    int turn = 0;
    int round = 0;
    Label[] playerInfoDisplay = new Label[4];
    int numOfPasses = 0;
    int[] playerMoney = new int[4];
    Button passButton = new Button();
    Button enterTownButton = new Button();
    Button[] townOptionButton = new Button[4];

    @FXML
    private void openPane2(ActionEvent e) {
        numOfPlayer = (int) playerCount.getValue();
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
        currentPlayer.setText("Player 1");
    }
    @FXML
    private void playerDone(ActionEvent e) {
        if (!currentPlayerName.getText().equals("ddd")) {
            if (count < numOfPlayer) {
                count++;
                currentPlayer.setText("Player" + count);
                playerName[count - 1] = currentPlayerName.getText();
                playerColor[count - 1] = colorPicker.getValue();
                currentPlayerName.clear();
                if (e.getSource().toString().equals("Button[id=mechtronButton, styleClass=button]'MECHTRON'")) {
                    playerRace[count - 1] = 0;
                    dialog.setText("Player " + count + "chose MECHTRON!\n Player"  + count + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=gollumerButton, styleClass=button]'GOLLUMER'")) {
                    playerRace[count - 1] = 1;
                    dialog.setText("Player " + count + "chose GOLLUMER!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=packerButton, styleClass=button]'PACKER'")) {
                    playerRace[count - 1] = 2;
                    dialog.setText("Player " + count + "chose PACKER!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=bonzoidButton, styleClass=button]'BONZOID'")) {
                    playerRace[count - 1] = 3;
                    dialog.setText("Player " + count + "chose BONZOID!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=spheroidButton, styleClass=button]'SPHEROID'")) {
                    playerRace[count - 1] = 4;
                    dialog.setText("Player " + count + "chose SPHEROID!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=flapperButton, styleClass=button]'FLAPPER'")) {
                    playerRace[count - 1] = 5;
                    dialog.setText("Player " + count + "chose FLAPPER!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=leggiteButton, styleClass=button]'LEGGITE'")) {
                    playerRace[count - 1] = 6;
                    dialog.setText("Player " + count + "chose LEGGITE!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=humanoidButton, styleClass=button]'HUMANOID'")) {
                    playerRace[count - 1] = 7;
                    dialog.setText("Player " + count + "chose HUMANOID!\n Player" + (count + 1) + " is choosing now!");
                }
                String s = "Map Tile";
                if (settings[2] == 1) {
                    s = "Flattile";
                } else if (settings[2] == 2) {
                    s = "River";
                } else if (settings[2] == 3) {
                    s = "Mountain";
                }
                if (count >= numOfPlayer) {
                    playerConfig.setVisible(false);
                    mapPane.setVisible(true);
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            buttons[i][j] = new Button(s);
                            buttons[i][j].setMaxHeight(10000);
                            buttons[i][j].setMaxWidth(10000);
                            mapPane.add(buttons[i][j], i, j);
                            final int k = i;
                            final int l = j;
                            buttons[k][l].setOnAction(new EventHandler<ActionEvent>() {
                                public void handle (ActionEvent e) {
                                    changeTileColor(k, l);
                                }
                            });
                        }
                    }
                    for (int i = 0; i < numOfPlayer; i++) {
                        playerInfoDisplay[i] = new Label();
                        playerInfoDisplay[i].setText(String.format("player %d has %d money", i + 1, playerMoney[i]));
                        playerInfoDisplay[i].setMaxWidth(10000);
                        playerInfoDisplay[i].setMaxHeight(10);
                        mapPane.add(playerInfoDisplay[i], 5, i);
                    }
                }
            } else {

                playerConfig.setVisible(false);
                mapPane.setVisible(true);
                for (int i = 0; i < numOfPlayer; i++) {
                    System.out.print(playerColor[i]);
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        buttons[i][j] = new Button("Map Tile");
                        buttons[i][j].setMaxHeight(10000);
                        buttons[i][j].setMaxWidth(10000);
                        mapPane.add(buttons[i][j], i, j);
                        final int k = i;
                        final int l = j;
                        buttons[k][l].setOnAction(new EventHandler<ActionEvent>() {
                            public void handle (ActionEvent e) {
                                changeTileColor(k, l);
                            }
                        });
                    }
                    playerInfoDisplay[i] = new Label();
                    playerInfoDisplay[i].setMaxWidth(10000);
                    playerInfoDisplay[i].setMaxHeight(10000);
                    mapPane.add(playerInfoDisplay[i], 5, i);
                }

            }
        } else {
            dialog.setText("Invalid name");
        }
    }

    public void changeTileColor(int i, int j) {
        if (round < 2) {
            if (buttons[i][j].getStyle().equals("")) {
                buttons[i][j].setStyle(String.format("-fx-base: #%h", playerColor[turn]));
                playerInfoDisplay[turn].setText(String.format("player %d has %d dollars", turn + 1 , playerMoney[turn]));
                turn++;
                if (turn >= numOfPlayer) {
                    turn = turn % numOfPlayer;
                    round++;
                }

            }
        } else {
            if (buttons[i][j].getStyle().equals("") && playerMoney[turn] >= 500) {
                numOfPasses = 0;
                mapPaneDialog.setText("");
                playerMoney[turn] -= 500;
                buttons[i][j].setStyle(String.format("-fx-base: #%h", playerColor[turn]));
                playerInfoDisplay[turn].setText(String.format("player %d has %d dollars", turn + 1 , playerMoney[turn]));
                turn++;
                if (turn >= numOfPlayer) {
                    turn = turn % numOfPlayer;
                }
            } else {
                mapPaneDialog.setText("player doesn't have enough money or it's already bought");
            }
        }
    }

    public void townOptionEvent(int i) {
        if (i == 2) {
            playerMoney[turn] += 100; //add money relative to timer remaining
            turn++;
            if (turn >= numOfPlayer) {
                turn = turn % numOfPlayer;
                round++;
            }
            mapPane.setVisible(true);
            townPane.setVisible(false);
        }
        if (i == 3) {
            mapPane.setVisible(true);
            townPane.setVisible(false);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {

        assert startButton != null : "fx identification failed.";
        assert easyMode != null : "fx identification failed.";
        assert hardMode != null : "fx identification failed.";
        assert mediumMode != null : "fx identification failed.";
        assert riverButton != null : "fx identification failed.";
        assert flatlandButton != null : "fx identification failed.";
        assert flapperButton != null : "fx identification failed.";
        assert leggiteButton != null : "fx identification failed.";
        assert humanoidButton != null : "fx identification failed.";
        assert mechtronButton != null : "fx identification failed.";
        assert gollumerButton != null : "fx identification failed.";
        assert packerButton != null : "fx identification failed.";
        assert bonzoidButton != null : "fx identification failed.";
        assert spheroidButton != null : "fx identification failed.";
        assert currentPlayer != null : "fx identification failed.";
        assert startPane != null : "fx identification failed.";
        assert diffPane != null : "fx identification failed.";
        assert tilePane != null : "fx identification failed.";
        assert playerConfig != null : "fx identification failed.";
        assert mapPane != null : "fx identification failed.";
        assert colorPicker != null : "fx identification failed.";

        startPane.setVisible(true);
        diffPane.setVisible(false);
        tilePane.setVisible(false);
        playerConfig.setVisible(false);
        mapPane.setVisible(false);
        townPane.setVisible(false);
        for (int i = 0; i < 4; i++) {
            playerMoney[i] = 1000;
            if (i != 2) {
                townOptionButton[i] = new Button(String.format("Town Option %d", i + 1));
            }
            if (i == 2) {
                townOptionButton[i] = new Button("Gamble");
            }
            final int k = i;
            townOptionButton[i].setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    townOptionEvent(k);
                }
            });
            townPane.add(townOptionButton[i], i%2, i/2);
        }





        passButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mapPaneDialog.setText("");
                if (round == 2) {
                    numOfPasses++;
                    if (numOfPasses >= numOfPlayer) {
                        round++;
                        mapPane.setVisible(false);
                    }
                }
            }
        });
        enterTownButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mapPaneDialog.setText("");
                mapPane.setVisible(false);
                townPane.setVisible(true);
            }
        });
        passButton.setText("Pass");
        enterTownButton.setText("enter Town");
        mapPane.add(passButton, 5, 3);
        mapPane.add(enterTownButton, 5, 4);


        // //The button event for the login button
        // loginButton.setOnAction(new EventHandler<ActionEvent>() {
        //
        //     public void handle(ActionEvent e)   {
        //         System.out.println("This button works");
        //     }
        // });
        }
    }
