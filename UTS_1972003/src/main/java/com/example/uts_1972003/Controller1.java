/**
 * Ilman Nawali 1972003
 */
package com.example.uts_1972003;

import com.example.DAO.HutangDAO;
import com.example.DAO.PlayerDAO;
import com.example.entity.Hutang;
import com.example.entity.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller1 implements Initializable {
    public TableView<Player> tablePemain;
    public TableColumn<Player, String> col1;
    public TableColumn<Player, String> col2;
    public TableColumn<Player, String> col3;
    public TableColumn<Player, String> col4;
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public ComboBox<Player> cmbPeserta;
    public TextField txtPemberiUtang;
    public TextField txtJumlah;
    public TableView<Hutang> tableHutang;
    public TableColumn<Hutang, String> col5;
    public TableColumn<Hutang, String> col6;
    public TableColumn<Hutang, String> col7;
    public Button btn5;
    public Button btn4;
    private ObservableList<Player> players;
    private ObservableList<Hutang> hutangs;
    private Controller2 controller2;
    private Boolean updateOrDelete;
    public Boolean getUpdateOrDelete() {
        return updateOrDelete;
    }
    public TableView<Player> getTablePemain(){
        return tablePemain;
    }
    public void setController2 (Controller2 controller2){
        this.controller2 = controller2;
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn1.setDisable(false);
        btn2.setDisable(true);
        btn3.setDisable(true);
        btn4.setDisable(false);
        PlayerDAO playerDAO = new PlayerDAO();
        HutangDAO hutangDAO = new HutangDAO();
        players = (ObservableList<Player>) playerDAO.showData();
        tablePemain.setItems(players);
        col1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getId())));
        col2.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getNama())));
        col3.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getUmur())));
        col4.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getKehlian())));
        cmbPeserta.setItems(players);
        hutangs = (ObservableList<Hutang>) hutangDAO.showData();
        tableHutang.setItems(hutangs);
        col5.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getPlayer().getId())));
        col6.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getPengutang())));
        col7.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getJumlah())));
    }


    public void btnAddPemain(ActionEvent actionEvent) throws IOException {
        Stage new_stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ModalPage.fxml"));
        Parent root = fxmlLoader.load();
        Controller2 c2 = fxmlLoader.getController();
        c2.setController(this);

        Scene new_scene = new Scene(root);
        new_stage.setScene(new_scene);
        new_stage.initModality(Modality.WINDOW_MODAL);
        new_stage.setTitle("");
        new_stage.show();
    }

    public void btnHapusPemain(ActionEvent actionEvent) {
        Player selected;

        selected = (Player) tablePemain.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        PlayerDAO playerDAO = new PlayerDAO();
        int result = playerDAO.delData(selected);
        if (result != 0){
            System.out.println("Delete Berhasil");
        }
        players.clear();
        players.addAll(playerDAO.showData());
        tablePemain.refresh();
        btn1.setDisable(false);
        btn2.setDisable(true);
        btn3.setDisable(true);
    }

    public void btnEditPemain(ActionEvent actionEvent) {
    }

    public void btnTambahDataHutang(ActionEvent actionEvent) {
        HutangDAO hutangDao = new HutangDAO();
        if (txtJumlah.getText().trim().isEmpty() || txtPemberiUtang.getText().trim().isEmpty()
                || cmbPeserta.getSelectionModel().isEmpty()) {
            Alert alertInformation = new Alert(Alert.AlertType.ERROR);
            alertInformation.setContentText("Please fill in all the field");
            alertInformation.show();
        } else {
            try {
                Hutang hutang = new Hutang();
                hutang.setPengutang(txtPemberiUtang.getText());
                hutang.setJumlah(Double.valueOf(txtJumlah.getText()));
                hutang.setPlayer(cmbPeserta.getValue());
                hutangDao.addData(hutang);
                hutangs.clear();
                hutangs.addAll(hutangDao.showData());
                txtPemberiUtang.setText("");
                txtJumlah.setText("");
            } catch (NumberFormatException ex) {
                Alert alertInformation = new Alert(Alert.AlertType.ERROR);
                alertInformation.setContentText("Please only input number for Jumlah Hutang");
                alertInformation.show();
            }
        }
    }

    public void btnDeleteHutang(ActionEvent actionEvent) {
        Hutang hutang = (Hutang) tableHutang.getSelectionModel().getSelectedItem();
        HutangDAO hutangDao = new HutangDAO();
        int result = hutangDao.delData(hutang);
        if (result==0){
            System.out.println("Delete Gagal");
        } else {
            System.out.println("Delete Berhasil");
        }
        hutangs.clear();
        hutangs.addAll(hutangDao.showData());
    }

    public void itemPil(MouseEvent event) {
        Player player = tablePemain.getSelectionModel().getSelectedItem();
        btn1.setDisable(true);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
    }
}
