package com.cabomaldade.calculaimc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static java.lang.String.format;

public class Main extends Application {

    @Override
    public void start(Stage telaEmBranco) {

        // Painel principal
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(15);
        root.setPadding(new Insets(5));

        // Controles visuais da aplicação
        Label lblPeso = new Label("Peso:");
        Label lblAltura = new Label("Altura:");
        Label lblMensagem = new Label("Seu IMC é: ");

        TextField txtPeso = new TextField();
        TextField txtAltura = new TextField();

        Button btnCalcular = new Button("Calcular");

        root.add(lblPeso, 0, 0);
        root.add(txtPeso, 1, 0);

        root.add(lblAltura, 0, 2);
        root.add(txtAltura, 1, 2);

        root.add(btnCalcular, 1, 4);
        root.add(lblMensagem, 1,6);

        // Capturando evento do botão
        btnCalcular.setOnAction(actionEvent -> {
            double peso;
            double altura;
            double resultado;

            peso = Double.parseDouble(txtPeso.getText());

            altura = Double.parseDouble(txtAltura.getText());

            resultado = peso / (altura * altura);
            lblMensagem.setText(format("Seu IMC é %.2f", resultado));
        });

        // TELA - SCENE
        Scene cena = new Scene(root, 300, 320);

        // Jogando itens na tela
        telaEmBranco.setTitle("Cálculo do IMC");
        telaEmBranco.setScene(cena);
        telaEmBranco.sizeToScene();
        telaEmBranco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
