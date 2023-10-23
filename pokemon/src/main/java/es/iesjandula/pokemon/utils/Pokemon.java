package es.iesjandula.pokemon.utils;
/**
 * @author Alejandro Cazalla Perez
 * 
 * Pokemon class with all the pokemon attributes
 */
public class Pokemon
{
	/**Pokemon Name*/
	private String name;
	
	/**Pokemon First Type*/
	private String type1;
	
	/**Pokemon Second Type*/
	private String type2;
	
	/**Pokemon Total Points*/
	private int total;
	
	/**Pokemon Health Points*/
	private int hp;
	
	/**Pokemon Attack Points*/
	private int attack;
	
	/**Pokemon Defense Points*/
	private int defense;
	
	/**Pokemon Speed Attack Points*/
	private int spAttack;
	
	/**Pokemon Speed Defense Points*/
	private int spDefense;
	
	/**Pokemon Speed Points*/
	private int speed;
	
	/**Pokemon Generation Number*/
	private int generation;
	
	/**Pokemon Legendary*/
	private boolean legendary;
	
	/**
	 * Pokemon Class Constructor
	 * 
	 * @param name
	 * @param type1
	 * @param type2
	 * @param total
	 * @param hp
	 * @param attack
	 * @param defense
	 * @param spAttack
	 * @param spDefense
	 * @param speed
	 * @param generation
	 * @param legendary
	 */
	public Pokemon(String name, String type1, String type2, int total, int hp, int attack, int defense, int spAttack,
			int spDefense, int speed, int generation, boolean legendary)
	{
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.total = total;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.speed = speed;
		this.generation = generation;
		this.legendary = legendary;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the type1
	 */
	public String getType1()
	{
		return this.type1;
	}

	/**
	 * @param type1 the type1 to set
	 */
	public void setType1(String type1)
	{
		this.type1 = type1;
	}

	/**
	 * @return the type2
	 */
	public String getType2()
	{
		return this.type2;
	}

	/**
	 * @param type2 the type2 to set
	 */
	public void setType2(String type2)
	{
		this.type2 = type2;
	}

	/**
	 * @return the total
	 */
	public int getTotal()
	{
		return this.total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total)
	{
		this.total = total;
	}

	/**
	 * @return the hp
	 */
	public int getHp()
	{
		return this.hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp)
	{
		this.hp = hp;
	}

	/**
	 * @return the attack
	 */
	public int getAttack()
	{
		return this.attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack)
	{
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
	public int getDefense()
	{
		return this.defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense)
	{
		this.defense = defense;
	}

	/**
	 * @return the spAttack
	 */
	public int getSpAttack()
	{
		return this.spAttack;
	}

	/**
	 * @param spAttack the spAttack to set
	 */
	public void setSpAttack(int spAttack)
	{
		this.spAttack = spAttack;
	}

	/**
	 * @return the spDefense
	 */
	public int getSpDefense()
	{
		return this.spDefense;
	}

	/**
	 * @param spDefense the spDefense to set
	 */
	public void setSpDefense(int spDefense)
	{
		this.spDefense = spDefense;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed()
	{
		return this.speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}

	/**
	 * @return the generation
	 */
	public int getGeneration()
	{
		return this.generation;
	}

	/**
	 * @param generation the generation to set
	 */
	public void setGeneration(int generation)
	{
		this.generation = generation;
	}

	/**
	 * @return the legendary
	 */
	public boolean isLegendary()
	{
		return this.legendary;
	}

	/**
	 * @param legendary the legendary to set
	 */
	public void setLegendary(boolean legendary)
	{
		this.legendary = legendary;
	}

	/**
	 * toString with a string builder with all the pokemon fields
	 */
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(Constants.POK_NAME);
		builder.append(name + Constants.POK_NEXT_LINE);
		builder.append(Constants.POK_TYPE_1);
		builder.append(type1 + Constants.POK_NEXT_LINE);
		builder.append(Constants.POK_TYPE_2);
		builder.append(type2 + Constants.POK_NEXT_LINE);
		builder.append(Constants.POK_TOTAL);
		builder.append(total + Constants.POK_NEXT_LINE);
		builder.append(Constants.POK_HP);
		builder.append(hp + Constants.POK_NEXT_LINE);
		builder.append(Constants.POK_ATTACK);
		builder.append(attack + Constants.POK_NEXT_LINE);
		builder.append(Constants.POK_DEFENSE);
		builder.append(defense + Constants.POK_NEXT_LINE);
		builder.append(Constants.POK_SP_ATK);
		builder.append(spAttack + Constants.POK_NEXT_LINE);
		builder.append(Constants.POK_SP_DEF);
		builder.append(spDefense + Constants.POK_NEXT_LINE);
		builder.append(Constants.POK_SPEED);
		builder.append(speed + Constants.POK_NEXT_LINE);
		builder.append(Constants.POK_GENERATION);
		builder.append(generation + Constants.POK_NEXT_LINE);
		builder.append(Constants.POK_LEGENDARY);
		builder.append(legendary + Constants.POK_NEXT_LINE);
		return builder.toString();
	}
	
	
	
}
