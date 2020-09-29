import java.util.*;
import java.util.concurrent.BlockingDeque;

import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;




public class TilePane1  extends TilePane{
	JsonHash hash;
	HashMapFunction hashmap;
	
	
	TilePane1(ArrayList<String> jsonHBotoes,ArrayList<String> jsonHFuncoes, JsonHash hash,HashMapFunction hashMapFunction) {
		this.hash = hash;
		this.hashmap = hashMapFunction;
		for(int i = 0; i < jsonHBotoes.size() ; i++) {
			Button botao = new Button((String) jsonHBotoes.get(i));
			System.out.println("Funcoes" + (String)jsonHFuncoes.get(i));
			int finalI = i;
			botao.setOnMouseClicked(e->{
				hashmap.ChangeScene((String)jsonHFuncoes.get(finalI));

			});
			getChildren().add(botao);
		}

		Button but = new Button("valor");
		getChildren().add(but);
		but.setOnMouseClicked(e ->{
			hashmap.ChangeScene("cenaPrincipal");
		});

		but.getOnMouseClicked();
	}
	
	
		
	

	
	
	
	
}

