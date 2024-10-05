package com.example.demo;

import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlunoControl {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionar(Aluno a) {
        alunos.add(a);
    }

    public Aluno pesquisarPorNome(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome().contains(nome)) {
                return a;
            }
        }
        return null;
    }

    public Node tabela() {
        TableView<Aluno> tabela = new TableView<>();

        TableColumn<Aluno, Long> colunaID = new TableColumn<>("Id");
        colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Aluno, String> colunaRa = new TableColumn<>("RA");
        colunaRa.setCellValueFactory(new PropertyValueFactory<>("ra"));

        TableColumn<Aluno, String> colunaNome = new TableColumn<>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Aluno, LocalDate> colunaNas = new TableColumn<>("Nascimento");
        colunaNas.setCellValueFactory(new PropertyValueFactory<>("nascimento"));

        tabela.getColumns().addAll(colunaID, colunaRa, colunaNome, colunaNas);

        tabela.getItems().addAll(alunos);
        return tabela;
    }
}
