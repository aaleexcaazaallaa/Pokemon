package es.iesjandula.pokemon.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParserCsv {
    public static List<Pokemon> parsePokemon() {
        FileInputStream fileInputStream = null;
        List<Pokemon> pokemon = new ArrayList<Pokemon>();
        int iteracion=0;
        try {
            fileInputStream = new FileInputStream("pokemon.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

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
                    if(iteracion>=30)
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return pokemon;
    }
}
