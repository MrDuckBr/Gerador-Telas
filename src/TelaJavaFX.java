import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.MutableAttributeSet;


//extend => HERANCA  -> descendencia de um individuo/ancestral
public class TelaJavaFX extends Application{
	Stage primaryStage;
	Scene cena;
	Scene cenaPrincipal;
	HashMapFunction hs ;
	JsonHash jsonH;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		hs = new HashMapFunction(this); // criei o hash map
		jsonH = new JsonHash(hs); // adicionei as cenas criadas aqui no hash map
		// adicionar tratamento de excecao para todos os casos
		hs.setInsertionHash("cenaPrincipal",new PrincipalLayout(hs));
		MudarCena(hs.getHashScene("qualquercoisa"));

	
		primaryStage.setResizable(true);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}


	
	//funcoes para o hash map sendo feitas a partir daqui
	public void MudarCena(Scene tela) {
		primaryStage.setScene(tela);
	}
	
	public void MudarNomeCena(String nomeCena) { // usar para que ?
		primaryStage.setTitle(nomeCena);
	}
	
	
}