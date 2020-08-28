

import java.util.*;

import org.json.JSONException;

import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;



public class TilePane1  extends TilePane{
	JsonHash hash;
	HashMapFunction hashmap;
	
	
	TilePane1(ArrayList<String> jsonHBotoes,ArrayList<String> jsonHFuncoes, JsonHash hash) throws JSONException{
		this.hash = hash;
		for(int i = 0; i < hash.tamLista() ; i++) {
			Button botao = new Button((String) jsonHBotoes.get(i));
			
			botao.setOnMouseClicked(e->{
				hashmap.ChangeScene((String)jsonHFuncoes.get(0));
			});
			jsonHFuncoes.remove(0);
			
			getChildren().add(botao);
		}
	}
	
	
		
	

	
	
	
	
}

