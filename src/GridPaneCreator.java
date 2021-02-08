import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class GridPaneCreator extends GridPane{
	JsonHash hash;

	GridPaneCreator(ArrayList<String> jsonHBotoes, ArrayList<String> commands, JsonHash hash) {
		this.hash = hash;
		for(int i = 0; i < jsonHBotoes.size(); i++) {
				Button button = new Button((String) jsonHBotoes.get(i));
				int finalI = i;
				button.setOnMouseClicked(e->{
				hash.mudarCena(commands.get(finalI));
				});
			getChildren().add(button);
		}
	}




	public Scene construtor(){

		Button button1 = new Button("Button 1");
		Button button2 = new Button("Button 2");
		Button button3 = new Button("Button 3");
		Button button4 = new Button("Button 4");
		Button button5 = new Button("Button 5");
		Button button6 = new Button("Button 6");

		GridPane gridPane = new GridPane();

		gridPane.add(button1, 0, 0, 1, 1);
		gridPane.add(button2, 1, 0, 1, 1);
		gridPane.add(button3, 2, 0, 1, 1);
		gridPane.add(button4, 0, 1, 1, 1);
		gridPane.add(button5, 1, 1, 1, 1);
		gridPane.add(button6, 2, 1, 1, 1);

		Scene cenaGrid = new Scene(gridPane);
		return cenaGrid;

	}
}

//	insertSceneMap(getTitle(), new TilePane1(bottoms, commands ,this));
//		}
//

