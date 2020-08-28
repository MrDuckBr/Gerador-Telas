import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GridPane1 extends GridPane{
	GridPane1(){
		Button botaoGridPane1 = new Button("BotaoGridPane");
		
		getChildren().add(botaoGridPane1);
		
		botaoGridPane1.setOnMouseClicked(e->{
			System.out.println("Hello Wordl");
		});
	}
}
