import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Елементрарна программа відстеження натисків на клавіші.
 * Окремо відстежується комбінація Ctrl+Alt+Q
 */

public class Main extends Application {
    public void start(Stage stage) {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Label heading = new Label("Press Key");
        Label keyPressed = new Label();
        root.getChildren().addAll(heading, keyPressed);
        Scene scene = new Scene(root, 300, 200);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                keyPressed.setText("Key Pressed: " + ke.getCode());
                if(ke.getCode()==KeyCode.Q && ke.isControlDown() && ke.isAltDown()){
                    keyPressed.setText("натиснута Q");
                }
            }
        });

        stage.setTitle("Key pushing");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
} 