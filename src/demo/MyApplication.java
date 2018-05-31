/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author namde
 */
public class MyApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
//        //Tạo ra group or layout để đưa các comment con vào
//        Group group = new Group();
//        //tạo ra một component kiểu botton.
//        Button btn1 = new Button("My Button");
//        //bắt sự kiện cho nút
//        btn1.setOnAction((event) -> {
//       //     System.out.println("Hello World");
//            btn1.setText("Hello World");
//        });
//        //đưa vào group.
//        group.getChildren().add(btn1);
//        //Ném group vào scene.
//        Scene scene = new Scene(group, 500, 350);
//        //Đưa scene vào stage.
//        stage.setScene(scene);
//        stage.setTitle("Hello FX");
//        stage.show();
//Tạo layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        //set hang doc
        gridPane.setVgap(4);
        //set hàng ngang
        gridPane.setHgap(8);

        //tạo ra các component
        Label lblUsername = new Label("Username");
        Label lblEmail = new Label("Email");
        Label lblPassword = new Label("Password");
        TextField txtUsername = new TextField();
        TextField txtEmail = new TextField();
        PasswordField txtPassword = new PasswordField();
        Button btnSubmit = new Button();
        Button btnReset = new Button();

        //Dưa các component vào layout
        GridPane.setConstraints(lblUsername, 2, 2);
        GridPane.setConstraints(lblEmail, 2, 3);
        GridPane.setConstraints(lblPassword, 2, 4);
        GridPane.setConstraints(txtUsername, 3, 2);
        GridPane.setConstraints(txtEmail, 3, 3);
        GridPane.setConstraints(txtPassword, 3, 4);

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(btnSubmit, btnReset);
        GridPane.setConstraints(hbox, 3, 5);

        gridPane.getChildren().addAll(
                lblEmail,
                lblPassword,
                lblUsername,
                txtEmail,
                txtPassword,
                txtUsername,
                hbox
        );

    }
}
