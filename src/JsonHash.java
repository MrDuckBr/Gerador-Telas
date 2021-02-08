import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.TilePane;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;

import java.util.*;


public class JsonHash {
	//criar as telas e depois mandar inserir no hash map la na main
	private JSONObject json;

	private JSONParser parser = new JSONParser();
	private ArrayList<String> bottoms;
	private ArrayList<String> commands;
	private ArrayList<String> telas;
	private Map<String,Scene> mapScenes;
	TelaJavaFX main;

	private String title;


	public JsonHash(TelaJavaFX main ) throws ParseException {
		this.main = main;
		mapScenes = new HashMap<>();

		bottoms = new ArrayList<>();
		telas = new ArrayList<>();
		commands = new ArrayList<>();

		try {
			json = (JSONObject) parser.parse(new FileReader("src/teste.json"));
			//System.out.println(json);

		} catch (IOException e) {
			e.printStackTrace();
		}


		readJson();


	}
	
	
	public void setTitle(String title)  {
		this.title = title;
	}

	public String getTitle(){
		return title;
	}
	
	public void readJson() throws ParseException {
		JSONArray jsonArray = (JSONArray) json.get("creator");
		for (Object o : jsonArray) {
			JSONObject arrayScene = (JSONObject) parser.parse(o.toString());
			setTitle(arrayScene.get("Scene").toString());
			System.out.println(getTitle());
			telas.add(arrayScene.get("Scene").toString());
			createScene(arrayScene);
		}

		//#verificacoes começam aqui
		//Verificar se tem todas as telas
		//#adicionar funcoes dos botoes
	}

	public Scene teste(){
		return mapScenes.get("Principal");
	}


	public void createScene(JSONObject arrayScene) throws ParseException {
		JSONArray objectsArray = (JSONArray) parser.parse(arrayScene.get("objects").toString());
		System.out.println(objectsArray.size());
		for (Object a : objectsArray) { // Pega as cenas , objetos
			JSONObject sceneObject = (JSONObject) parser.parse(a.toString());
			//if (teste.get("type").equals("Cena")) {
				bottoms.add((String) sceneObject.get("text"));
				commands.add((String) sceneObject.get("command"));
				//ADICIONAR A FUNCAO DO BOTAO NESTE PONTO AQUI
			//}
		}
	insertSceneMap(getTitle(), new TilePane1(bottoms, commands ,this));
	}








	public void insertSceneMap(String screen_name , TilePane tile) { //Insere a nova cena no Hash Map
		System.out.println("Nome da tela " + screen_name);
		mapScenes.put(screen_name, new Scene(tile));

	}

	public void mudarCena(String cena){
		if(existeCena(cena)) {
			if (mapScenes.get(cena) != null) {
				main.mudarCena(mapScenes.get(cena), cena);

			}
		}else{
			Alert AlertaMudarCena = new Alert(Alert.AlertType.ERROR);
			AlertaMudarCena.setContentText("A cena "+ cena + " não existe");
			AlertaMudarCena.show();
		}
	}

	public boolean existeCena(String cena){
		for(String t : telas){
			if(t.equals(cena)){
				return true;
			}
		}
		return false;
	}






}
