package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlunoBoundary extends Application {
    private AlunoControl control = new AlunoControl();

    private TextField tfId = new TextField();
    private TextField tfRa = new TextField();
    private TextField tfNome = new TextField();
    private TextField tfNas = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane painel = new GridPane();
        Scene cena = new Scene(painel);

        painel.add(new Label("Id:"),0,0);
        painel.add(tfId,1,0);
        painel.add(new Label("RA:"),0,1);
        painel.add(tfRa,1,1);
        painel.add(new Label("Nome:"),0,2);
        painel.add(tfNome,1,2);
        painel.add(new Label("Nascimento:"),0,3);
        painel.add(tfNas,1,3);

        Button btAdicionar = new Button("Adicionar");
        Button btPesquisar = new Button("Pesquisar");

        btAdicionar.setOnAction(event -> {control.adicionar(boundaryToEntity());
                VBox vbox = new VBox(control.tabela());
                painel.add(vbox,2,6);
                primaryStage.setScene(cena);
        });
        btPesquisar.setOnAction(event -> entityToBoundary(control.pesquisarPorNome(tfNome.getText())));
        painel.add(btAdicionar,0,5);
        painel.add(btPesquisar,1,5);;
        VBox vbox = new VBox(control.tabela());
        painel.add(vbox,2,6);
        primaryStage.setScene(cena);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public void entityToBoundary(Aluno a){
        tfId.setText(String.valueOf(a.getId()));
        tfRa.setText(a.getRa());
        tfNome.setText(a.getNome());
        tfNas.setText(String.valueOf(a.getNascimento()));
    }
    public Aluno boundaryToEntity(){
        Aluno a = new Aluno();
        a.setId(Long.parseLong(tfId.getText()));
        a.setRa(tfRa.getText());
        a.setNome(tfNome.getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(tfNas.getText(),formatter);
        a.setNascimento(data);
        return a;
    }
}
