package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class MainController2 {

    private int[] actTurn = new int[4];
    private Player[] player;
    private int numOfPlayer;
    private int round;
    private Random rand;
    private int turn;
    private int time;
    private boolean installingMule;
    public MainController2(Random rand) {
        for (int i = 0; i < 4; i++) {
            actTurn[i] = i;
        }
        round = 0;
        turn = -1;
        installingMule = false;
        this.rand = rand;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }

    public void setPlayerNum(int numOfPlayer) {
        this.numOfPlayer = numOfPlayer;
    }


    public int nextTurn(int numOfPlayer) {
        turn++;
        if (turn >= numOfPlayer) {
            turn = turn % numOfPlayer;
            round++;
            if (round >= 2) {
                for (int i = 0; i < numOfPlayer; i++) {
                    player[i].produce();
                }
            }
            getPlayerTurns();
        }
        RandomEventHandler.eventHandler(rand, player[actTurn[turn]], actTurn[numOfPlayer - 1] == actTurn[turn]);
        return actTurn[turn];
        //System.out.println(player[actTurn[turn - 1]].getMoney());
    }

    public int getRound() {
        return round;
    }

    public int updateTime() {
        time--;
        return time;
    }

    public void onTilePress(Button[][] buttons, Tile[][] tiles, int i, int j, Label[] playerInfoDisplay, Label mapPaneDialog) {
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
            }
            if (buttons[i][j].getStyle().equals("") && player[actTurn[turn]].getMoney() >= 500) {
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



    public void townOptionEvent(int i, Label[] playerInfoDisplay, Label mapPaneDialog, Pane storePane, Pane townPane, Pane outfitPane, Pane mapPane) {
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

    public void storeOptionEvent(int i, Label storeDialog, Label[] playerInfoDisplay, Pane storePane, Pane townPane) {
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

    public void updatePlayerInfoDisplay(final int k, Label[] playerInfoDisplay) {
        javafx.application.Platform.runLater(new java.lang.Runnable() {
            @Override
            public void run() {
                playerInfoDisplay[k].setText(String.format("player %d has %d dollars resource1: %d resource2: %d resource3 %d", k + 1 , player[k].getMoney(), player[k].getResource(0), player[k].getResource(1), player[k].getResource(2)));
                //mapPaneDialog1.setText("" + time);
            }
        });
    }

    public int calcTime(int turn) {
        time = player[actTurn[turn]].getScore();
        return time;
    }
}
