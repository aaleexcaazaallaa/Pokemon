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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.iesjandula.pokemon.exceptions.PokemonException;

public class ParserPokemon {
    public static List<Pokemon> parseCsv() throws PokemonException
    {
    	final Logger logger = LogManager.getLogger();
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
        	String error = "Error en la lectura del fichero";
			logger.error(error, e);
			throw new PokemonException (error, e);
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
            	String error = "Error en la lectura del fichero";
    			logger.error(error, e);
    			throw new PokemonException (error, e);
            }
        }
        
        return pokemon;
    }
    public static void savePokemon(List<Pokemon> listPokemon) throws PokemonException
    {
    	final Logger logger = LogManager.getLogger();
		FileOutputStream fileOutputStream=null;
		ObjectOutputStream objectOutputStream =null;
		try {
			fileOutputStream = new FileOutputStream("datos.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(listPokemon);
	
		} catch (FileNotFoundException e) {
			String error = "No se ha encontrado el fichero";
			logger.error(error, e);
			throw new PokemonException (error, e);
		} catch (IOException e) {
			String error = "Error en la lectura del fichero";
			logger.error(error, e);
			throw new PokemonException (error, e);
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
            	String error = "Error en la lectura del fichero";
    			logger.error(error, e);
    			throw new PokemonException (error, e);
            }
        }
			
			
    }
    public static List<Pokemon> readSelectedPokemonFromFile(String filePath) throws PokemonException 
    {
    	final Logger logger = LogManager.getLogger();
    	List<Pokemon> selectedPokemon = null;
    	FileInputStream fileInputStream=null;
    	ObjectInputStream objectInputStream =null;
		try {
			fileInputStream = new FileInputStream(filePath);
			objectInputStream = new ObjectInputStream(fileInputStream);
			selectedPokemon = (List<Pokemon>) objectInputStream.readObject();
			
		} catch (FileNotFoundException e) {
			String error = "No se ha encontrado el fichero";
			logger.error(error, e);
			throw new PokemonException (error, e);
		} catch (IOException e) {
			String error = "Error en la lectura del fichero";
			logger.error(error, e);
			throw new PokemonException (error, e);
		} catch (ClassNotFoundException e) {
			String error = "no se ha encontrado la clase";
			logger.error(error, e);
			throw new PokemonException (error, e);
		}finally {
            try {
                if (objectInputStream != null) {
                	objectInputStream.close();
                }
                if (fileInputStream != null)
                {
                	fileInputStream.close();
                }
            } catch (IOException e) {
            	String error = "Error en la lectura del fichero";
    			logger.error(error, e);
    			throw new PokemonException(error, e);
            }
        }
    	
		return selectedPokemon;
    	
    	
    }
    
    
  
}
