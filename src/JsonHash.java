import org.json.simple.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/*
 * Nessa classe irei criar a tel com base nos valores do json passado a mim
 * 
 * Nome da tela;
 * NumBotoes
 * for dos botoes
 * 	botao = nome
 * 	botao = funcao
 *Lista com os botoes
 *
 *Descobrir como abrir arquivo json
 * 
 *
 *TRATAR ERROS DE MANEIRA CORRETA <-------------
 *
 */


public class JsonHash {
	//criar as telas e depois mandar inserir no hash map la na main
	private JSONObject json;
	private JSONParser parser = new JSONParser();
	private ArrayList<String> botoes;
	private ArrayList<String> funcoes;
	HashMapFunction hash;
	
	/*Abrir arquivo no proprio codigo */
	
	//TA ERRADISSIMO , NAO TA FUNCIONANDO NO ARQUIVO JSON
	public JsonHash(HashMapFunction hash) throws ParseException {
		this.hash = hash;
		botoes = new ArrayList<>();
		funcoes = new ArrayList<>();
		String a;
		String b;
		String c;
		
		try {
			json = (JSONObject) parser.parse(new FileReader("C:\\teste.json")); /// NAO TA FUNCIONANDO PQQQQQQQ
			a  = (String)json.get("nome");
			b = (String) json.get("valor");
			c = (String) json.get("tast");
			
			System.out.print(a + b + c);
			
			// PORQUE ESSE PARSER NAO FUNCIONA ????
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			//adicionar parada , sem sentido continuar
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		getTitle();
	}
	
	
	public void  getTitle()  {
		
		System.out.println((String)json.get("nomeCena"));
	}
	
	public void insereBotaoLista() throws JSONException {// DA PRA COLOCAR ARRAY , MAS AINDA NAO TESTEI ESSA MODIFICACAO
		for (int i = 0; i < (int)tamLista(); i++) {
			botoes.add(json.getString("botao"+new Integer(i).toString())); // ANALISAR DEPOIS
		}
		
		
		
	}
	public void insereFuncaoLista() throws JSONException{ // metodo que pega a funcao dos botoes;
		for (int i = 0; i < (int)tamLista(); i++) {
			funcoes.add(json.getString("funcao"+i));
		}
	}
	
	
	public int tamLista() throws JSONException {
		return  (int)json.getInt("NumeroBotoes");
	}  	
	

	
	public void setScene() throws JSONException {
			hash.setInsertionHash(getTitle() , new TilePane1(botoes,funcoes,this));
		
	}
	
	
	
}
