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
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class MainController implements Initializable {

    // @FXML // ResourceBundle that was given to the FXMLLoader
    // private ResourceBundle resources;
    //
    // @FXML // URL location of the FXML file that was given to the FXMLLoader
    // private URL location;

    @FXML
    private Button startButton;

    @FXML
    private Button easyMode;

    @FXML
    private Button hardMode;

    @FXML
    private Button mediumMode;

    @FXML
    private Button mountainButton;

    @FXML
    private Button riverButton;

    @FXML
    private Button flatlandButton;

    @FXML
    private Button flapperButton;

    @FXML
    private Button leggiteButton;

    @FXML
    private Button humanoidButton;

    @FXML
    private Button mechtronButton;

    @FXML
    private Button gollumerButton;

    @FXML
    private Button packerButton;

    @FXML
    private Button bonzoidButton;

    @FXML
    private Button spheroidButton;

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
    @FXML
    private Label mapPaneDialog1;
    @FXML
    private GridPane outfitPane;
    @FXML
    private GridPane storePane;
    
    
    Timer timer = new Timer();
    int[] settings = new int[3];
    int count = 0;
    int numOfPlayer;
    Player[] player = new Player[4];
    Button[][] buttons = new Button[4][4];
    int turn = 0;
    int round = 0;
    Label[] playerInfoDisplay = new Label[4];
    int numOfPasses = 0;
    Button passButton = new Button();
    Button enterTownButton = new Button();
    Button[] townOptionButton = new Button[4];
    int time = 1000;
    int[] actTurn = new int[4];
    Random rand = new Random();
    Tile[][] tiles = new Tile[4][4];
    boolean installingMule = false;
    Button[][] outfitButton = new Button[2][2];
    Button[] storeOptionButton = new Button[8];
    Label storeDialog = new Label("Welcome to Store");

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
                currentPlayer.setText("Player" + (count + 1));
                player[count - 1].setName(currentPlayerName.getText());
                player[count - 1].setColor(colorPicker.getValue());
                currentPlayerName.clear();
                if (e.getSource().toString().equals("Button[id=mechtronButton, styleClass=button]'MECHTRON'")) {
                    player[count - 1].setRace(0);
                    dialog.setText("Player " + count + "chose MECHTRON!\n Player"  + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=gollumerButton, styleClass=button]'GOLLUMER'")) {
                    player[count - 1].setRace(1);
                    dialog.setText("Player " + count + "chose GOLLUMER!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=packerButton, styleClass=button]'PACKER'")) {
                    player[count - 1].setRace(2);
                    dialog.setText("Player " + count + "chose PACKER!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=bonzoidButton, styleClass=button]'BONZOID'")) {
                    player[count - 1].setRace(3);
                    dialog.setText("Player " + count + "chose BONZOID!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=spheroidButton, styleClass=button]'SPHEROID'")) {
                    player[count - 1].setRace(4);
                    dialog.setText("Player " + count + "chose SPHEROID!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=flapperButton, styleClass=button]'FLAPPER'")) {
                    player[count - 1].setRace(5);
                    dialog.setText("Player " + count + "chose FLAPPER!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=leggiteButton, styleClass=button]'LEGGITE'")) {
                    player[count - 1].setRace(6);
                    dialog.setText("Player " + count + "chose LEGGITE!\n Player" + (count + 1) + " is choosing now!");
                }
                if (e.getSource().toString().equals("Button[id=humanoidButton, styleClass=button]'HUMANOID'")) {
                    player[count - 1].setRace(7);
                    dialog.setText("Player " + count + "chose HUMANOID!\n Player" + (count + 1) + " is choosing now!");
                }
                if (count >= numOfPlayer) {
                    timer.scheduleAtFixedRate(new TimerTask() {
                        @Override
                        public void run() {
                            time--;
                            javafx.application.Platform.runLater(new java.lang.Runnable() {
                                @Override
                                public void run() {
                                    mapPaneDialog1.setText(String.format("player %d has %d time left", actTurn[turn] + 1, time));
                                    //mapPaneDialog1.setText("" + time);
                                }
                            });

                            if (time <= 0) {
                                turn++;
                                time = player[actTurn[turn]].getScore();
                                //System.out.println(player[actTurn[turn - 1]].getMoney());
                                if (turn >= numOfPlayer) {
                                    turn = turn % numOfPlayer;
                                    round++;
                                    if (round >= 2) {
                                        for (int i = 0; i < numOfPlayer; i++) {
                                            player[i].produce();
                                            final int k = i;
                                            javafx.application.Platform.runLater(new java.lang.Runnable() {
                                                @Override
                                                public void run() {
                                                    playerInfoDisplay[k].setText(String.format("player %d has %d dollars", k + 1 , player[k].getMoney()));
                                                    //mapPaneDialog1.setText("" + time);
                                                }
                                            });
                                        }
                                    }
                                    getPlayerTurns();
                                }
                            }
                        }
                    }, 0, 100);
                    playerConfig.setVisible(false);
                    mapPane.setVisible(true);
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            String s = "Map Tile";
                            int r = rand.nextInt();
                            r = (((r % 3) + 3) % 3) + 1;
                            if (r == 1) {
                                s = "Flattile";
                            } else if (r == 2) {
                                s = "River";
                            } else if (r == 3) {
                                s = "Mountain";
                            }
                            buttons[i][j] = new Button(s);
                            buttons[i][j].setMaxHeight(10000);
                            buttons[i][j].setMaxWidth(10000);
                            mapPane.add(buttons[i][j], i, j);
                            tiles[i][j] = new Tile();
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
                        playerInfoDisplay[i].setText(String.format("player %d has %d money", i + 1, player[i].getMoney()));
                        playerInfoDisplay[i].setMaxWidth(10000);
                        playerInfoDisplay[i].setMaxHeight(10);
                        mapPane.add(playerInfoDisplay[i], 5, i);
                    }
                }
            } else {
                System.out.println("something went wrong");
            }
        } else {
            dialog.setText("Invalid name");
        }
    }

    public void changeTileColor(int i, int j) {
        if (round < 2) {
            if (buttons[i][j].getStyle().equals("")) {
                buttons[i][j].setStyle(String.format("-fx-base: #%h", player[actTurn[turn]].getColor()));
                playerInfoDisplay[actTurn[turn]].setText(String.format("player %d has %d dollars", actTurn[turn] + 1 , player[actTurn[turn]].getMoney()));
                player[actTurn[turn]].claimLand(tiles[i][j]);
                time = 0;
            }
        } else {
            if (installingMule) {
                Player owner = tiles[i][j].getOwner();
                if (owner != player[actTurn[turn]]) {
                    player[actTurn[turn]].lostMule();
                } else {
                    owner.installMule(tiles[i][j]);
                    mapPaneDialog.setText("player successfully installed mule!");
                }
                installingMule = false;
                return;
            }
            if (buttons[i][j].getStyle().equals("") && player[actTurn[turn]].getMoney() >= 500) {
                numOfPasses = 0;
                mapPaneDialog.setText("");
                player[actTurn[turn]].changeMoney(-500);
                buttons[i][j].setStyle(String.format("-fx-base: #%h", player[actTurn[turn]].getColor()));
                playerInfoDisplay[actTurn[turn]].setText(String.format("player %d has %d dollars", actTurn[turn] + 1 , player[actTurn[turn]].getMoney()));
                player[actTurn[turn]].claimLand(tiles[i][j]);
                time = 0;
            } else if (player[actTurn[turn]].getMoney() < 500) {
                mapPaneDialog.setText("player doesn't have enough money");
            }
        }
    }

    public void getPlayerTurns() {
        for (int i = 0; i < numOfPlayer; i++) {
            int localMax = 0;
            int index = 0;
            for (int j = 0; j < numOfPlayer; j++) {
                int score = player[j].getScore();
                if (score > localMax) {
                    if (i > 0) {
                        if (player[actTurn[i-1]].getScore() >= score) {
                            boolean isItOk = true;
                            for (int k = 0; k < i; k++) {
                                if (actTurn[k] == j) {
                                    isItOk = false;
                                }
                            }
                            if (isItOk) {
                                localMax = score;
                                index = j;
                            }
                        }
                    } else {
                        localMax = score;
                        index = j;
                    }
                }
            }
            actTurn[i] = index;
        }
        /*for (int i = 0; i < numOfPlayer; i++) {
            System.out.print(" " + actTurn[i] + " ");
        }
        System.out.println()*/;
    }

    public void townOptionEvent(int i) {
        if (i == 0) {
            storePane.setVisible(true);
            townPane.setVisible(false);
        }
        if (i == 1) {
            if (player[actTurn[turn]].canBuyMule() && round >= 2) {
                if (round >= 2 && player[actTurn[turn]].getMoney() >= 500) {
                    player[actTurn[turn]].changeMoney(-500);
                    playerInfoDisplay[actTurn[turn]].setText(String.format("player %d has %d dollars", actTurn[turn] + 1 , player[actTurn[turn]].getMoney()));
                    outfitPane.setVisible(true);
                    townPane.setVisible(false);
                    mapPaneDialog.setText("installing Mule");
                    player[actTurn[turn]].obtainMule();
                    installingMule = true;
                }
            }
        }
        if (i == 2) {
            if (round >= 2) {
                player[actTurn[turn]].changeMoney(time);
                playerInfoDisplay[actTurn[turn]].setText(String.format("player %d has %d dollars", actTurn[turn] + 1 , player[actTurn[turn]].getMoney()));
                time = 0;
                mapPane.setVisible(true);
                townPane.setVisible(false);
            }
        }
        if (i == 3) {
            mapPane.setVisible(true);
            townPane.setVisible(false);
        }
    }

    public void storeOptionEvent(int i) {
        if (i < 3) {
            //buy
            if (player[actTurn[turn]].getMoney() >= 100) {
                player[actTurn[turn]].changeMoney(-100);
                player[actTurn[turn]].changeResource(i,1);
                if (i == 0) {
                    storeDialog.setText(String.format("player %d has %d food", actTurn[turn] + 1 , player[actTurn[turn]].getResource(i)));
                }
                if (i == 1) {
                    storeDialog.setText(String.format("player %d has %d energy", actTurn[turn] + 1 , player[actTurn[turn]].getResource(i)));
                }
                if (i == 2) {
                    storeDialog.setText(String.format("player %d has %d smithore", actTurn[turn] + 1 , player[actTurn[turn]].getResource(i)));
                }
            } else {
                storeDialog.setText(String.format("player %d doesn't have enough money", actTurn[turn] + 1));
            }
        }
        if (i > 2 && i < 6) {
            //sell
            if (player[actTurn[turn]].getResource(i - 3) >= 1) {
                player[actTurn[turn]].changeMoney(100);
                player[actTurn[turn]].changeResource(i - 3,-1);
                if (i == 3) {
                    storeDialog.setText(String.format("player %d has %d food", actTurn[turn] + 1 , player[actTurn[turn]].getResource(i-3)));
                }
                if (i == 4) {
                    storeDialog.setText(String.format("player %d has %d energy", actTurn[turn] + 1 , player[actTurn[turn]].getResource(i-3)));
                }
                if (i == 5) {
                    storeDialog.setText(String.format("player %d has %d smithore", actTurn[turn] + 1 , player[actTurn[turn]].getResource(i-3)));
                }
            } else {
                storeDialog.setText(String.format("player %d doesn't have enough resources", actTurn[turn] + 1));
            }
        }
        if (i == 6) {
            storePane.setVisible(false);
            townPane.setVisible(true);
        }
        playerInfoDisplay[actTurn[turn]].setText(String.format("player %d has %d dollars", actTurn[turn] + 1 , player[actTurn[turn]].getMoney()));
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
        assert mapPaneDialog1 != null : "fx identification failed.";
        assert outfitPane != null : "fx ident. failed";

        startPane.setVisible(true);
        diffPane.setVisible(false);
        tilePane.setVisible(false);
        playerConfig.setVisible(false);
        mapPane.setVisible(false);
        townPane.setVisible(false);
        outfitPane.setVisible(false);
        storePane.setVisible(false);
        for (int i = 0; i < 4; i++) {
            townOptionButton[i] = new Button(String.format("Town Option %d", i + 1));
            final int k = i;
            townOptionButton[i].setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    townOptionEvent(k);
                }
            });
            townPane.add(townOptionButton[i], i%2, i/2);
        }
        townOptionButton[0].setText("Resource Store");
        townOptionButton[1].setText("Buy Mule");
        townOptionButton[2].setText("Gamble");

        for (int i = 0; i < 7; i++) {
            storeOptionButton[i] = new Button(String.format("store Option %d", i + 1));
            final int k = i;
            storeOptionButton[i].setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    storeOptionEvent(k);
                }
            });
            storePane.add(storeOptionButton[i], i%2, i/2);
        }
        storeOptionButton[0].setText("Buy Food");
        storeOptionButton[1].setText("Buy Energy");
        storeOptionButton[2].setText("Buy Smithore");
        storeOptionButton[3].setText("Sell Food");
        storeOptionButton[4].setText("Sell Energy");
        storeOptionButton[5].setText("Sell Smithore");
        storeOptionButton[6].setText("Leave Store");
        storePane.add(storeDialog, 4, 4);



        passButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                mapPaneDialog.setText("");
                if (round >= 2) {
                    numOfPasses++;
                    time = 0;
                    if (numOfPasses >= numOfPlayer) {
                        round++;
                        getPlayerTurns();
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
        for (int i = 0; i < 4; i++) {
            actTurn[i] = i;
            player[i] = new Player();
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                outfitButton[i][j] = new Button(String.format("resource %d", i * 2 + j));
                final int r = i * 2 + j;
                outfitButton[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        player[actTurn[turn]].outfitMule(r, 10);
                        outfitPane.setVisible(false);
                        mapPane.setVisible(true);
                    }
                });
                outfitPane.add(outfitButton[i][j], i, j);
            }
        }
    }
}
