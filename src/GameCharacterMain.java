/*
 * Kurt Kangas
 * CIS 2212 Java Software Development I
 * Game Character Class - User 1 and 2 will pick a character which has unique abilities.
 * ~Purpose of program is to practice using constructors and classes.~
 */

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameCharacterMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String Role1 = "Warrior";
		String Role2 = "Ritualist";
		String Role3 = "Assassin";

		System.out.println("This program is a game that you will pick two characters to face off against one another!\n");
		System.out.println("\tRules: \n- Each character will have a role that you will pick.\n- Every role is unique in that they have their own unique skills and attributes");
		System.out.println("\n\tThe roles are...\n- "+Role1+"\n- "+Role2+"\n- "+Role3+"\n");

		System.out.print("\nPick a name for the first character: ");
		String FirstCharacterName = input.nextLine();
		System.out.print("Pick a role for the first character: ");
		String FirstCharacterRole = input.nextLine();
		GameCharacter gc1 = new GameCharacter(FirstCharacterName, FirstCharacterRole, "", 100, 25, 0, 0, false);

		if (FirstCharacterRole.equalsIgnoreCase(Role1)) {
			gc1 = new GameCharacter(FirstCharacterName, FirstCharacterRole, "sword", 100, 25, 0, 0, false);
			gc1.setSkill("The " + Role1 + " is the master of a melee combat with increased armor and " + gc1.getWeapon() + "s which deals the highest damage of any weapon.");
		}
		else if (FirstCharacterRole.equalsIgnoreCase(Role2)) {
			gc1 = new GameCharacter(FirstCharacterName, FirstCharacterRole, "magic", 100, 25, 0, 0, false);
			gc1.setSkill("The " + Role2 + " is the master of " + gc1.getWeapon() + ", the " + Role2 + " can spawn allies from the spirit realm to help him fight and use spells to regenerate his health");
		}
		else if (FirstCharacterRole.equalsIgnoreCase(Role3)) {
			gc1 = new GameCharacter(FirstCharacterName, FirstCharacterRole, "dagger", 100, 0, 0, 0, true);
			gc1.setEvade(true);
			gc1.setSkill("The " + Role3 + " is the master of " + gc1.getWeapon() + "s and evading death. The " + Role3 + " can chain together attacks to hit an opponent multiple times and evade fatal attacks");
		}
		else {
			System.out.println("The role " + FirstCharacterRole + " for " + FirstCharacterName + " is invalid. Please type in a correct role. ex.Warrior");
			FirstCharacterRole = input.nextLine();
			gc1 = new GameCharacter(FirstCharacterName, FirstCharacterRole, "sword", 100, 25, 0, 0, false);
		}

		System.out.println();
		System.out.print("Pick a name for the second character: ");
		String SecondCharacterName = input.nextLine();
		System.out.print("Pick a role for the second character: ");
		String SecondCharacterRole = input.nextLine();
		GameCharacter gc2 = new GameCharacter(SecondCharacterName, SecondCharacterRole, "", 100, 25, 0, 0, false);

		if (SecondCharacterRole.equalsIgnoreCase(Role1)) {
			gc2 = new GameCharacter(SecondCharacterName, SecondCharacterRole, "sword", 100, 25, 0, 0, false);
			gc2.setSkill("The " + Role1 + " is the master of a melee combat with increased armor and " + gc2.getWeapon() + "s which deals the highest damage of any weapon.");
		}
		else if (SecondCharacterRole.equalsIgnoreCase(Role2)) {
			gc2 = new GameCharacter(SecondCharacterName, SecondCharacterRole, "magic", 100, 25, 0, 0, false);
			gc2.setSkill("The " + Role2 + " is the master of " + gc2.getWeapon() + ", the " + Role2 + " can use spells to regenerate their health.");
		}
		else if (SecondCharacterRole.equalsIgnoreCase(Role3)) {
			gc2 = new GameCharacter(SecondCharacterName, SecondCharacterRole, "dagger", 100, 0, 0, 0, true);
			gc2.setEvade(true);
			gc2.setSkill("The " + Role3 + " is the master of " + gc2.getWeapon() + "s and evading death. The " + Role3 + " can evade attacks and a chance to chain attacks.");
		}
		else {
			System.out.println("The role " + SecondCharacterRole + " for " + SecondCharacterName + " is invalid. Please type in a correct role. ex.Warrior");
			SecondCharacterRole = input.nextLine();
			gc2 = new GameCharacter(SecondCharacterName, SecondCharacterRole, "sword", 100, 25, 0, 0, false);
		}

		System.out.println();
		System.out.println(gc1.getName() + " is a " + gc1.getRole());
		System.out.println(gc1.getSkill());
		System.out.println();
		System.out.println(gc2.getName() + " is a " + gc2.getRole());
		System.out.println(gc2.getSkill());

		System.out.println("\n\tGame starts: ");
		do {		
			System.out.println("\t\t" + gc1.getName() + gc1.toString(gc1.getHealth(), gc1.getShield()));
			System.out.println("\t\t" + gc2.getName() + gc2.toString(gc2.getHealth(), gc2.getShield())+ "\n");

			boolean boolean_rand = ThreadLocalRandom.current().nextBoolean();
			boolean HeadOrTails = ThreadLocalRandom.current().nextBoolean();

			if (boolean_rand == true)
			{
				gc1.setDamage(gc1.Attack(gc1.getHealth(),gc1.getWeapon()), gc1.getHealth(), gc1.getShield());
				System.out.println(gc1.getName() + " did an attack with a " + gc1.getWeapon() + " for " + gc1.getDamage() + " damage.");
				gc2.Defend(gc1.getDamage(),gc2.getHealth(),gc2.getShield());
				if (gc2.getEvade() == true)
				{
					if (HeadOrTails == true)
					{
						gc2.giveHealth(gc1.getDamage());
						System.out.println(gc2.getName() + " evaded the attack taking no damage.");
						gc2.setDamage(gc2.Attack(gc2.getHealth(),gc2.getWeapon()), gc2.getHealth(), gc2.getShield());
						System.out.println(gc2.getName() + " immediately attacks " + gc1.getName() + " for " + gc2.getDamage() + " damage.");
						gc1.Defend(gc2.getDamage(),gc1.getHealth(),gc1.getShield());
					}
				}
				gc1.setDamage(0, gc1.getHealth(), gc1.getShield());
			}
			else
			{
				gc2.setDamage(gc2.Attack(gc2.getHealth(),gc2.getWeapon()), gc2.getHealth(), gc2.getShield());
				System.out.println(gc2.getName() + " did an attack with a " + gc2.getWeapon() + " for " + gc2.getDamage() + " damage.");
				gc1.Defend(gc2.getDamage(),gc1.getHealth(),gc1.getShield());
				if (gc1.getEvade() == true)
				{
					if (HeadOrTails == true)
					{
						gc1.giveHealth(gc2.getDamage());
						System.out.println(gc1.getName() + " evaded the attack taking no damage.");
						gc1.setDamage(gc1.Attack(gc1.getHealth(),gc1.getWeapon()), gc1.getHealth(), gc1.getShield());
						System.out.println(gc1.getName() + " immediately attacks " + gc2.getName() + " for " + gc1.getDamage() + " damage.");
						gc2.Defend(gc1.getDamage(),gc2.getHealth(),gc2.getShield());
					}
				}
				gc2.setDamage(0, gc2.getHealth(), gc2.getShield());
			}	
		}while((gc1.getHealth() > 0) && (gc2.getHealth() > 0));

		if (gc1.getHealth() > 0)
		{
			System.out.println(gc1.getName() + " wins!");
		}
		else
		{
			System.out.println(gc2.getName() + " wins!");
		}	
	}
}
