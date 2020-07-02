package para.calc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.stage.*;
import javafx.scene.*;
import javafx.geometry.Pos;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

import static javafx.scene.input.KeyCode.EQUALS;
import static javafx.scene.input.KeyEvent.CHAR_UNDEFINED;

/**
 * JavaFX 電卓アプリケーションのメインクラス
 */
public class Calculator extends Application{
  Label input;
  Label output;
  StringBuilder buff;
  Executor ex;
  public Calculator(){
    input = new Label();
    output = new Label();
    buff = new StringBuilder();
    ex = new Executor1();
  }
  String[] buttonname = {"9","8","7","+",
                         "6","5","4","-",
                         "3","2","1","*",
                         "0",".",",","/"};

  public void start(Stage stage){
    VBox root = new VBox();
    root.setAlignment(Pos.TOP_CENTER);
    GridPane grid = new GridPane();
    Scene scene = new Scene(root, 200,200);
    Button[] buttons = new Button[16];
    Button buttoncal = new Button("=");
    double tmph = buttoncal.getHeight();
    buttoncal.setPrefHeight(56);
    Button buttondel = new Button("<");
    buttondel.setPrefHeight(56);
    StackPane stack = new StackPane();
    stack.getChildren().add(new Rectangle(140,30,Color.WHITE));
    stack.getChildren().add(input);
    root.getChildren().addAll(stack, output);
    root.getChildren().add(grid);
    grid.setAlignment(Pos.CENTER);
    for(int i=0;i<16;i++){
      buttons[i] = new Button(buttonname[i]);
      buttons[i].setPrefHeight(26);
      grid.add(buttons[i],i%4,i/4);
    }
    grid.add(buttondel,4,0,1,2);
    grid.add(buttoncal,4,2,1,2);


    for(int i=0;i<16;i++){
      buttons[i].setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          for(int i=0;i<16;i++){
            if(event.getSource() == buttons[i]) {
              buff.append(buttonname[i]);
              input.setText(new String(buff));
              break;
            }
          }
        }
      });
    }

    buttoncal.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        output.setText(ex.operation(buff.toString()));
      }
    });

    buttondel.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        buff.deleteCharAt(buff.length()-1);
        input.setText(new String(buff));
      }
    });

    scene.setOnKeyTyped(e ->{
      if(e.getCharacter().equals("=")) {
        output.setText(ex.operation(buff.toString()));
        buttoncal.requestFocus();

      }else if(e.getCharacter().equals("\b")){
        if(buff.length() > 0){
          buff.deleteCharAt(buff.length()-1);
        }
        input.setText(new String(buff));
        buttondel.requestFocus();
      }else{
        for(int i=0;i < 16;i++){
          if(e.getCharacter().equals(buttonname[i])){
            buff.append(buttonname[i]);
            input.setText(new String(buff));
            buttons[i].requestFocus();
            break;
          }
        }
        //buff.append(e.getCharacter());
        //input.setText(new String(buff));
      }
    });
    
















    













    


    







    
    stage.setScene(scene);
    stage.setTitle("JavaFX Calc");
    stage.show();
  }
}
