
import java.util.HashMap;
import java.util.Map;



import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.TilePane;

public class HashMapFunction {
	private TelaJavaFX telaJavaFX;
	private Map<String,Scene> hash; // alterar depois para private ,mudei para testes
	
	
	public HashMapFunction(TelaJavaFX main) {
		this.telaJavaFX = main;
		hash = new HashMap<>();
	}
	

	public void setInsertionHash(String Screen_name , TilePane tile) { // acredito que esteja certo
		hash.put(Screen_name, new Scene(tile));
		System.out.println(hash);
		System.out.println(Screen_name);
	}
	
	public Scene getHashScene(String name) {
		return hash.getOrDefault(name, null);
	}
	
	public void ChangeScene(String name) {
		if(getHashScene(name) != null){
			telaJavaFX.MudarCena(hash.get(name));
			telaJavaFX.MudarNomeCena(name);
			
		}else {
			Alert AlertaMudarCena = new Alert(AlertType.ERROR);
			AlertaMudarCena.setContentText(name);
			AlertaMudarCena.show();
		}
	}
	
}
	



