import java.util.*;


import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;




public class TilePane1  extends TilePane {
	JsonHash hash;

	TilePane1(ArrayList<String> jsonHBotoes, ArrayList<String> commands, JsonHash hash) {
		this.hash = hash;
		for (int i = 0; i < jsonHBotoes.size(); i++) {
			Button button = new Button((String) jsonHBotoes.get(i));
			int finalI = i;
			button.setOnMouseClicked(e->{
				hash.mudarCena(commands.get(finalI));


			});
			getChildren().add(button);
		}
	}
}
/*
		Button but = new Button("Home");
		getChildren().add(but);
		but.setOnMouseClicked(e ->{
			hashmap.ChangeScene("Principal");
		});

		but.getOnMouseClicked();
	}
	
	
		
	*/

	
	
	
	


