


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TelaJavaFXController extends TelaJavaFX{
	TelaJavaFX main;
	
	
	public void clicar() {
		System.out.println("Hello World");
		Alert alerta = new Alert(AlertType.CONFIRMATION);
		alerta.setContentText("Se eu nao me engano e esse");
		alerta.show();
		
		
	}
	
	public void botao2() {
		Alert alerta2 = new Alert(AlertType.ERROR);
		alerta2.setContentText("Botao 2 FXML");
		alerta2.show();
	}
	
	public void botao3() {
		
		System.out.println("Botao 3 FXML");
		//main.changeScene(2);
	}

}
