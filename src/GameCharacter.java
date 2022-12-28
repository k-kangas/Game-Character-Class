/*
 * Kurt Kangas
 * CIS 2212 Java Software Development I
 * Game Character Class - User 1 and 2 will pick a character which has unique abilities.
 * ~Purpose of program is to practice using constructors and classes.~
 */

import java.util.concurrent.ThreadLocalRandom;

public class GameCharacter {
	// Attributes (instance variables)
	private String Name;

	private String Role;
	private String Skill;

	private int Health;
	private int Shield;
	private String Weapon;

	private int Damage;
	private int Healing;

	private boolean Evade;

	int int_random = ThreadLocalRandom.current().nextInt();
	// Constructors
	public GameCharacter(String characterName, String characterRole, String characterWeapon, int characterHealth, int characterShield, int characterDamage, int characterHealing, boolean characterEvade) {
		Name = characterName;
		Role = characterRole;
		Weapon = characterWeapon;
		Health = characterHealth;
		Shield = characterShield;
		Damage = characterDamage;
		Healing = characterHealing;
		Evade = characterEvade;
	}

	// Behaviors (methods)
	public int Attack(int characterHealth, String characterWeapon) {
		int random_int = 0;
		int max = Health / 2 + 1;
		int min = 1;
		if (characterWeapon.equals("sword"))
		{
			random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
			random_int = random_int * 2;
			return random_int;
		}
		else if (characterWeapon.equals("magic"))
		{
			random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
			return random_int;
		}
		else if (characterWeapon.equals("dagger"))
		{
			random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
			return random_int;
		}
		else
		{
			return random_int;
		}
	}
	public void Defend(int characterDamage, int characterHealth, int characterShield) {	
		if (Shield > 0)
		{
			if (characterDamage > Shield)
			{
				characterDamage -= Shield;
				Health = Health - characterDamage;
			}else {
				Shield -= characterDamage;
			}
		}
		else
		{
			Health = Health - characterDamage;
		}
	}
	public String toString(int characterHealth, int characterShield) {
		return ("'s health: " + characterHealth + " armor: " + characterShield);
	}
	public String getName() {
		return Name;
	}
	public void setName(String characterName) {
		Name = characterName;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String characterRole) {
		Role = characterRole;
	}
	public String getSkill() {
		return Skill;
	}
	public void setSkill(String characterSkill) {
		Skill = characterSkill;
	}
	public int getHealth() {
		return Health;
	}
	public void setHealth(int characterHealth) {
		Health = characterHealth;
	}
	public void giveHealth(int characterDamage) {
		Health += characterDamage;
	}
	public int getShield() {
		return Shield;
	}
	public void setShield(int characterShield) {
		Shield = characterShield;
	}
	public String getWeapon() {
		return Weapon;
	}
	public void setWeapon(String characterWeapon) {
		Weapon = characterWeapon;
	}
	public int getDamage() {
		return Damage;
	}
	public void setDamage(int characterDamage, int characterHealth, int characterShield) {
		if (characterShield > 0)
		{
			if (characterDamage > characterShield)
			{
				characterDamage -= characterShield;
				characterHealth = characterHealth - characterDamage;
			}else {
				characterShield -= characterDamage;
			}
		}
		else
		{
			characterHealth = characterHealth - characterDamage;
		}
		Damage = characterDamage;
	}
	public int getHealing() {
		return Healing;
	}
	public void setHealing(int characterHealing, int characterHealth, int characterShield) {
		if (characterHealth >= 100)
		{
			characterShield += characterHealing;
		}
		else if ((characterHealth + characterHealing) > 100)
		{
			int Extra = 0;
			Extra = (characterHealth + characterHealing) - 100;
			characterShield += Extra;
			characterHealth = 100;
		}
		else {
			characterHealth += characterHealing;
		}
		Healing = characterHealing;
	}
	public boolean getEvade() {
		return Evade;
	}
	public void setEvade(boolean characterEvade) {
		Evade = characterEvade;
	}
}
