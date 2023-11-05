package es.iesjandula.pokemon.utils;

public class PokemonUtils
{
    // Método para determinar el ganador entre dos Pokémon
    public static Pokemon determineWinner(Pokemon pokemon1, Pokemon pokemon2)
    {
        // Compara los tipos de los Pokémon
        if (isSuperEffectiveAgainst(pokemon1, pokemon2))
        {
            return pokemon1;
        }
        else if (isSuperEffectiveAgainst(pokemon2, pokemon1))
        {
            return pokemon2;
        }
        else
        {
            // Si los tipos no tienen ventajas ni desventajas, compara las estadísticas totales
            if (pokemon1.getTotal() > pokemon2.getTotal())
            {
                return pokemon1;
            }
            else if (pokemon1.getTotal() < pokemon2.getTotal())
            {
                return pokemon2;
            }
            else
            {
                // Si las estadísticas totales son iguales, el resultado es un empate
                return null;
            }
        }
    }
    
 // Método para determinar el perdedor entre dos Pokémon
    public static Pokemon determineLoser(Pokemon pokemon1, Pokemon pokemon2)
    {
        // Compara los tipos de los Pokémon
        if (isSuperEffectiveAgainst(pokemon1, pokemon2))
        {
            return pokemon2;
        }
        else if (isSuperEffectiveAgainst(pokemon2, pokemon1))
        {
            return pokemon1;
        }
        else
        {
            // Si los tipos no tienen ventajas ni desventajas, compara las estadísticas totales
            if (pokemon1.getTotal() > pokemon2.getTotal())
            {
                return pokemon2;
            }
            else if (pokemon1.getTotal() < pokemon2.getTotal())
            {
                return pokemon1;
            }
            else
            {
                // Si las estadísticas totales son iguales, el resultado es un empate
                return null;
            }
        }
    }

    // Método para verificar si un tipo es super efectivo contra otro
    private static boolean isSuperEffectiveAgainst(Pokemon attacker, Pokemon defender)
    {
        String type1 = attacker.getType1();
        String type2 = attacker.getType2();

        
        if (type1.equals("Grass") && (defender.getType1().equals("Water") || defender.getType2().equals("Water")))
        {
            return true;
        }
        else if (type1.equals("Fire") && (defender.getType1().equals("Grass") || defender.getType2().equals("Grass")))
        {
            return true;
        }
        else if (type1.equals("Water") && (defender.getType1().equals("Fire") || defender.getType2().equals("Fire")))
        {
            return true;
        }
        else if (type1.equals("Electric") && (defender.getType1().equals("Water") || defender.getType2().equals("Water")))
        {
            return true;
        }
        // Agrega más relaciones de tipo
        else if (type1.equals("Grass") && (defender.getType1().equals("Electric") || defender.getType2().equals("Electric")))
        {
            return true;
        }
        else if (type1.equals("Water") && (defender.getType1().equals("Electric") || defender.getType2().equals("Electric")))
        {
            return true;
        }
        else if (type1.equals("Electric") && (defender.getType1().equals("Fire") || defender.getType2().equals("Fire")))
        {
            return true;
        }
       
        return false;

        
    }
    
}
