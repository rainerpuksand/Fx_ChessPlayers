package com.example.fx_chessplayers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button prev,next,first,last;

    @FXML
    ImageView imgV;

    @FXML
    Label name,elo,years;

    int indexNow=0;
    int indexLast=3;
    List<ChessPlayer> chessPlayerList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ChessPlayer p1 = new ChessPlayer("Carlson",2882, "2013-present","carlsen.jpg");
        ChessPlayer p2 = new ChessPlayer("Kasparov",2851, "1985-2000","kasprov.jpg");
        ChessPlayer p3 = new ChessPlayer("V.Anand",2817, "2007-2013","anand.png");
        ChessPlayer p4 = new ChessPlayer("Kramnik",2817, "2000-2006","kramnik.jpg");

        chessPlayerList = new ArrayList<>();
        chessPlayerList.add(p1);                // objektid pannakse listi
        chessPlayerList.add(p2);
        chessPlayerList.add(p3);
        chessPlayerList.add(p4);

        display(indexNow);
    }

    private void display(int indexNum) {
        ChessPlayer temp = chessPlayerList.get(indexNum);

        name.setText(temp.getName());
        elo.setText("ELO: " + temp.getElo());
        years.setText(temp.getYears());

        Image img = new Image(getClass().getResourceAsStream("/img/"+temp.getImgURL() ));
        imgV.setImage(img);

    }

    @FXML
    public void firstClick(ActionEvent e){
        indexNow = 0;
        display(indexNow);
    }

    @FXML
    public void lastClick(ActionEvent e){
        indexNow = indexLast;
        display(indexNow);
    }
    @FXML
    public void nextClick(ActionEvent e){

        if(indexNow==3){
            indexNow=0;
        }
        else{
            indexNow++;
        }

        display(indexNow);

    }
    @FXML
    public void prevClick(ActionEvent e){

        if(indexNow==0){
            indexNow=3;
        }
        else{
            indexNow--;
        }

        display(indexNow);
    }


}
