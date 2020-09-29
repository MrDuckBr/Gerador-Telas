import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;


public class JsonHash {
	//criar as telas e depois mandar inserir no hash map la na main
	private JSONObject json;
	private JSONParser parser = new JSONParser();
	private ArrayList<String> bottoms;
	private ArrayList<String> functions;
	HashMapFunction hash;


	/*Abrir arquivo no proprio codigo */
	
	//TA ERRADISSIMO , NAO TA FUNCIONANDO NO ARQUIVO JSON
	public JsonHash(HashMapFunction hash) throws ParseException {
		this.hash = hash;
		bottoms = new ArrayList<>();
		functions = new ArrayList<>();
		try {
			json = (JSONObject) parser.parse(new FileReader("C:\\teste.json"));
			System.out.println(json);

		} catch (IOException e) {
			e.printStackTrace();
		}


		insertBottomList();
		insertFunctionList();
		setScene();
	}
	
	
	public String getTitle()  {

		return (String)json.get("title");

	}
	
	public void insertBottomList()  {// DA PRA COLOCAR ARRAY , MAS AINDA NAO TESTEI ESSA MODIFICACAO
		JSONArray jsonArray = (JSONArray) json.get("bottom");
		for (Object o : jsonArray) {
			System.out.println(o);
			bottoms.add((String) o);
		}
	System.out.println(bottoms);
	}


	public void insertFunctionList(){ // metodo que pega a funcao dos botoes;
		JSONArray jsonArray = (JSONArray) json.get("function");
		for (Object o : jsonArray) {
			System.out.println(o);
			functions.add((String) o);
		}
		System.out.println(functions);
	}
	
	

	

	
	public void setScene()  {

			hash.setInsertionHash(getTitle() , new TilePane1(bottoms,functions,this,hash));
		
	}
	
	
	
}
