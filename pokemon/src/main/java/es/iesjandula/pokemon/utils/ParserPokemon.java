package es.iesjandula.pokemon.utils;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ParserPokemon {
    public static List<Pokemon> parseCsv() {
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        List<Pokemon> pokemon = new ArrayList<Pokemon>();
        int iteracion=0;
        try {
            fileInputStream = new FileInputStream("pokemon.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            reader = new BufferedReader(inputStreamReader);

            String line= reader.readLine();
         
            boolean stop=false;
            while ((line  != null)&& !stop) {
                String[] parts = line.split(",");
                
                if (parts.length >= 13) { // Asegúrate de que haya al menos 13 valores en cada fila
                	
                    String name = parts[1];
                    String type1 = parts[2];
                    String type2 = parts[3];
                    int total = Integer.parseInt(parts[4]);
                    int hp = Integer.parseInt(parts[5]);
                    int attack = Integer.parseInt(parts[6]);
                    int defense = Integer.parseInt(parts[7]);
                    int speed = Integer.parseInt(parts[8]);
                    int specialAttack = Integer.parseInt(parts[9]);
                    int specialDefense = Integer.parseInt(parts[10]);
                    int generation = Integer.parseInt(parts[11]);
                    boolean isLegendary = Boolean.parseBoolean(parts[12]);
                    pokemon.add(new Pokemon(name,type1,type2,total,hp,attack,defense,speed,specialAttack,specialDefense,generation,isLegendary))  ;	
                    iteracion++;
                    
                    line= reader.readLine();
                    if(iteracion>30)
                    {
                		stop=true;
                    }
                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (reader != null)
                {
                	reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return pokemon;
    }
    public static void savePokemon(List<Pokemon> listPokemon) 
    {
    	
    	
    		FileOutputStream fileOutputStream=null;
    		ObjectOutputStream objectOutputStream =null;
			try {
				fileOutputStream = new FileOutputStream("datos.txt");
				objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(listPokemon);
		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
	            try {
	                if (objectOutputStream != null) {
	                	objectOutputStream.close();
	                }
	                if (fileOutputStream != null)
	                {
	                	fileOutputStream.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
			
			
    }
    public static List<Pokemon> readSelectedPokemonFromFile(String filePath) 
    {
    	List<Pokemon> selectedPokemon = null;
    	FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(filePath);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			selectedPokemon = (List<Pokemon>) objectInputStream.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return selectedPokemon;
    	
    	
    }
    
    
  
}
