package main.java.app.controllers;

import com.jfoenix.controls.JFXTabPane;
import com.sun.org.apache.xml.internal.security.Init;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import com.jfoenix.controls.JFXTabPane;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import main.java.app.Var;

import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.ResourceBundle;

public class PointDistributionController implements Initializable {

        @FXML
        private JFXTabPane tabpane;

        @FXML
        private Tab pietab;

        @FXML
        private PieChart piec;

        @FXML
        private PieChart piec1;

        @FXML
        private Tab bartab;

        @FXML
        private BarChart<?, ?> barc;

        @FXML
        private BarChart<?, ?> barc1;

        @FXML
        private Label pointdistlabel;

        @FXML
        private Label habit2;

        @FXML
        private Label habit3;

        @FXML
        private Label habit4;

        @FXML
        private Label habit1;

        @FXML
        private Label habit5;

        @FXML
        private Label habit6;

        @FXML
        private Label habit2rat;

        @FXML
        private Label habit3rat;

        @FXML
        private Label habit4rat;

        @FXML
        private Label habit1rat;

        @FXML
        private Label habit5rat;

        @FXML
        private Label habit6rat;

        @FXML
        private Label keylabel;

        @FXML
        public void tabchange() throws SQLException {
            Connection con = DriverManager.getConnection(Var.URL, Var.DBU, Var.DBP);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from habits");

            if (pietab.isSelected()){
                ObservableList<PieChart.Data> pieChartData =
                        FXCollections.observableArrayList();
                ObservableList<PieChart.Data> pieChartData1 =
                        FXCollections.observableArrayList();
                int i = 0;
                while (rs.next()) {
                    switch (i) {
                        case 0:
                            habit1.setText(rs.getString("name"));
                            switch (rs.getString("freq")) {
                                case "Daily": habit1rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))));
                                break;
                                case "Weekly": habit1rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 7);
                                break;
                                case "Biweekly": habit1rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 14);
                                break;
                                case "Monthly": habit1rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 30);
                                break;
                                default:
                                    break;
                            }
                            break;
                        case 1:
                            habit2.setText(rs.getString("name"));
                            switch (rs.getString("freq")) {
                                case "Daily": habit2rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))));
                                    break;
                                case "Weekly": habit2rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 7);
                                    break;
                                case "Biweekly": habit2rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 14);
                                    break;
                                case "Monthly": habit2rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 30);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            habit3.setText(rs.getString("name"));
                            switch (rs.getString("freq")) {
                                case "Daily": habit3rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))));
                                    break;
                                case "Weekly": habit3rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 7);
                                    break;
                                case "Biweekly": habit3rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 14);
                                    break;
                                case "Monthly": habit3rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 30);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 3:
                            habit4.setText(rs.getString("name"));
                            switch (rs.getString("freq")) {
                                case "Daily": habit4rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))));
                                    break;
                                case "Weekly": habit4rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 7);
                                    break;
                                case "Biweekly": habit4rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 14);
                                    break;
                                case "Monthly": habit4rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 30);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 4:
                            habit5.setText(rs.getString("name"));
                            switch (rs.getString("freq")) {
                                case "Daily": habit5rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))));
                                    break;
                                case "Weekly": habit5rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 7);
                                    break;
                                case "Biweekly": habit5rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 14);
                                    break;
                                case "Monthly": habit5rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 30);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 5:
                            habit6.setText(rs.getString("name"));
                            switch (rs.getString("freq")) {
                                case "Daily": habit6rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))));
                                    break;
                                case "Weekly": habit6rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 7);
                                    break;
                                case "Biweekly": habit6rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 14);
                                    break;
                                case "Monthly": habit6rat.setText(rs.getString("streak") + "/" +
                                        (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 30);
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            break;
                    }

                    if (rs.getString("id").equals(Var.id)) {
                        //pieChartData.remove(i);
                        pieChartData.add(i, new PieChart.Data(rs.getString("name"), Integer.parseInt(rs.getString("streak"))));
                        if (rs.getString("freq").equals("Daily")) {
                            //pieChartData1.remove(i);
                            pieChartData1.add(i, new PieChart.Data(rs.getString("name"), (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number")))));
                        } else if (rs.getString("freq").equals("Weekly")) {
                            //pieChartData1.remove(i);
                            pieChartData1.add(i, new PieChart.Data(rs.getString("name"), (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 7));
                        } else if (rs.getString("freq").equals("Biweekly")) {
                            //pieChartData1.remove(i);
                            pieChartData1.add(i, new PieChart.Data(rs.getString("name"), (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 14));
                        } else if (rs.getString("freq").equals("Monthly")) {
                            //pieChartData1.remove(i);
                            pieChartData1.add(i, new PieChart.Data(rs.getString("name"), (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 30));
                        }

                        i++;
                    }
                }
                rs.close();
                piec.setAnimated(true);
                piec1.setAnimated(true);
                piec.setData(pieChartData);
                piec1.setData(pieChartData1);
                piec.setTitle("Your Points");
                piec1.setTitle("Projected Points");
            }
            else if(bartab.isSelected()){
                XYChart.Series bardata = new XYChart.Series<>();
                XYChart.Series bardata1 = new XYChart.Series<>();


                while (rs.next()) {

                    if (rs.getString("id").equals(Var.id)) {
                        //pieChartData.remove(i);
                        bardata.getData().add(new XYChart.Data(rs.getString("name"), Integer.parseInt(rs.getString("streak"))));
                        if (rs.getString("freq").equals("Daily")) {
                            bardata1.getData().add(new XYChart.Data(rs.getString("name"),
                                    (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number")))));
                        } else if (rs.getString("freq").equals("Weekly")) {
                            bardata1.getData().add(new XYChart.Data(rs.getString("name"),
                                    (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 7));
                        } else if (rs.getString("freq").equals("Biweekly")) {
                            bardata1.getData().add(new XYChart.Data(rs.getString("name"),
                                    (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 14));
                        } else if (rs.getString("freq").equals("Monthly")) {
                            bardata1.getData().add(new XYChart.Data(rs.getString("name"),
                                    (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - Integer.parseInt(rs.getString("number"))) / 30));
                        }
                    }
                }

                barc.getData().setAll(bardata);
                barc1.getData().setAll(bardata1);
                /*barc.setLegendVisible(false);
                barc1.setLegendVisible(false);*/
                barc.setTitle("Your Points");
                barc1.setTitle("Projected Points");
            }
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tabchange();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
