package home;

import home.annotation.FeatureOpt;
import home.processor.ProductLineProcessor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        final VBox root = FXMLLoader.load(getClass().getResource("/layout/main.fxml"));

        setFileChooser(primaryStage, (Button) root.lookup("#archChooser"), (TextField) root.lookup("#archTextField"));
        setDirectoryChooser(primaryStage, (Button) root.lookup("#srcChooser"), (TextField) root.lookup("#srcTextField"));
        setDirectoryChooser(primaryStage, (Button) root.lookup("#dstChooser"), (TextField) root.lookup("#dstTextField"));

        root.lookup("#botCB").setUserData(FeatureOpt.BOT);
        root.lookup("#gameCB").setUserData(FeatureOpt.GAME);
        root.lookup("#templateCB").setUserData(FeatureOpt.TEMPLATE);
        root.lookup("#chatHistCB").setUserData(FeatureOpt.CHAT_HISTORY);
        root.lookup("#fileShareCB").setUserData(FeatureOpt.FILE_SHARING);
        root.lookup("#imgShareCB").setUserData(FeatureOpt.IMAGE_SHARING);

        ((Button) root.lookup("#processBtn")).setOnAction(new EventHandler<ActionEvent>() {
           @Override public void handle(ActionEvent actionEvent) {
               List<FeatureOpt> featureList = new LinkedList<>();

               for (Node node : ((GridPane) root.lookup("#features")).getChildren()) {
                   if (node instanceof CheckBox) {
                       if (!((CheckBox) node).isSelected()) {
                           featureList.add((FeatureOpt) node.getUserData());
                       }
                   }
               }

               File archFile = new File(((TextField) root.lookup("#archTextField")).getText());
               File srcDir = new File(((TextField) root.lookup("#srcTextField")).getText());
               File dstDir = new File(((TextField) root.lookup("#dstTextField")).getText());

               ProductLineProcessor plProcessor = new ProductLineProcessor(srcDir, archFile, dstDir);
               plProcessor.pruneFeatures(featureList.toArray(new FeatureOpt[featureList.size()]));

               try {
                   Desktop.getDesktop().open(dstDir);
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        });

        primaryStage.setResizable(false);
        primaryStage.setTitle("Feature Selection");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void setDirectoryChooser(final Stage primaryStage, final Button chooser, final TextField choiceText) {
        final DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select a folder");

        chooser.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                File dir = directoryChooser.showDialog(primaryStage);

                if (dir != null) {
                    choiceText.setText(dir.getPath());
                }
            }
        });
    }

    private void setFileChooser(final Stage primaryStage, final Button chooser, final TextField choiceText) {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a file");

        chooser.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                File file = fileChooser.showOpenDialog(primaryStage);

                if (file != null) {
                    choiceText.setText(file.getPath());
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
