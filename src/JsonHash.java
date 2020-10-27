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
	private ArrayList<String> functions;
	HashMapFunction hash;

	private String title;


	/*Abrir arquivo no proprio codigo */
	
	//TA ERRADISSIMO , NAO TA FUNCIONANDO NO ARQUIVO JSON
	public JsonHash(HashMapFunction hash ) throws ParseException {
		this.hash = hash;

		bottoms = new ArrayList<>();
		functions = new ArrayList<>();
		try {
			json = (JSONObject) parser.parse(new FileReader("src/teste.json"));
			//System.out.println(json);

		} catch (IOException e) {
			e.printStackTrace();
		}


		insertBottomList();
		insertFunctionList();
		setScene();
	}
	
	
	public void setTitle(String title)  {
		this.title = title;
	}

	public String getTitle(){
		return title;
	}
	
	public void insertBottomList() throws ParseException {// DA PRA COLOCAR ARRAY , MAS AINDA NAO TESTEI ESSA MODIFICACAO
		JSONArray jsonArray = (JSONArray) json.get("creator");
		for (Object o : jsonArray) { // Tenho o array de objetos do "creator" , eu tenho meu array quebrado
			//System.out.println(o.toString());
			//System.out.println("-------------------");
			JSONObject arrayScene = (JSONObject) parser.parse(o.toString()); // nesse parse eu transformo em JSOn
			setTitle(arrayScene.get("Scene").toString());
			createScene(arrayScene);
		}
	}


	public void createScene(JSONObject arrayScene) throws ParseException {
		JSONArray objectsArray = (JSONArray) parser.parse(arrayScene.get("objects").toString());
		for (Object a : objectsArray) { // Pega as cenas , objetos
			JSONObject teste = (JSONObject) parser.parse(a.toString());
			if (teste.get("type").equals("Cena")) {
				bottoms.add((String) teste.get("text"));
				//System.out.println(teste.get("text") + " Impressao do text");
			}
			//	System.out.println(teste.get("text"));
		}

	}


	public void insertFunctionList(){ // metodo que pega a funcao dos botoes;
		JSONArray jsonArray = (JSONArray) json.get("function");
		for (Object o : jsonArray) {
			//System.out.println(o);
			functions.add((String) o);
		}
		//System.out.println(functions);
	}
	
	

	

	
	public void setScene()  {
		System.out.println(bottoms);
		System.out.println(functions);
		hash.setInsertionHash(getTitle() , new TilePane1(bottoms,this,hash));
		
	}
	
	
	
}
