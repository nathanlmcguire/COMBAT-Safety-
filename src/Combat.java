import java.util.Scanner;
import java.util.Random;
	
public class Combat 
	{
	//Health and level variables.
	static int playerHitPoints, monsterHitPoints, godHealth, levelOfPlayer = 1;
	//Dice Roll variables.
	static int diceRollOne, diceRollTwo, diceRollThree, totalDice;
	//Difficulty variables.
	static int difficultyHealth, difficultyDamage, difficultyLevel;
	//Choice variables.
	static int playAgainChoice = 1, actionChoice;
	//Luck variables/
	static int lootNumber, findingLuck, playerLuck, dodgeAffect = 0; 
	//Bonus point variables.
	static int armorBonus = 0, weaponBonus = 0, fireballBonus = 0, healingSpellBonus = 0, dodgeBonus = 0, classWeaponBonus = 1, classFireballBonus = 1, classHealingBonus = 1, classDodgeBonus = 1;
	//Achievement variables.
	static int numberOfSlainEnemies;
	//Player identity variables.
	static String nameOfPlayer, jobOfPlayer, homeLand;
	//More achievement variables.
	static String pluralVariable;
	
	static String weaponName; 
	static int classDamage, classHealth;
	
	public static void main(String[] args) 
		{
		askName();
		startIntro();
		while (playAgainChoice == 1)
			{
			generatePlayerHitPoints();
			generateMonsterHitPoints();
			chooseAction();
			simulateCombat();
			}
		}

	public static String askName() //Asks the name of the player.
    	{
		System.out.println("Hello, and welcomd to COMBAT. What is your name?");
		Scanner userInput1 = new Scanner(System.in);        
	    nameOfPlayer = userInput1.nextLine();        
	    System.out.println("Nice to meet you " + nameOfPlayer + ".");
	    if ("TGM".equals(nameOfPlayer))
	    	{
	    	godHealth = 300;
	    	}
	    else
	    	{
	    	godHealth = 0;
	    	}	
	    System.out.println();
	    return nameOfPlayer;
    	}

	public static int startIntro() //Asks the player where he/she is from, what they want the difficulty level to be, and what they want their class to be.
	{
	System.out.println("Where are you from " + nameOfPlayer + "?"); 
	Scanner userInput1 = new Scanner(System.in);
	homeLand = userInput1.nextLine();
	System.out.println("So you are from " + homeLand + "?!  Interesting.");
	System.out.println(" ");
	System.out.println("Choose the difficulty level.");
	System.out.println(" ");
	System.out.println("1)Trainee, 2)Adept, 3)Journyman(Recommended), 4)Master, or 5)DEATH.");
	Scanner userInput2 = new Scanner(System.in);
	difficultyLevel = userInput2.nextInt();
		if (1 == difficultyLevel)
			{
			System.out.println("The easiest of the levels.  A novice player I see.");
			difficultyHealth = 20;
			difficultyDamage = 4;
			}
		if (2 == difficultyLevel)
			{
			System.out.println("The normal level. A smart choice " + nameOfPlayer + "." );
			difficultyHealth = 40;
			difficultyDamage = 6;
			}
		if (3 == difficultyLevel)
			{
			System.out.println("This level is difficult but not immposible.");
			System.out.println("Maybe soon you can try the Master level.");		
			difficultyHealth = 80;
			difficultyDamage = 8;
			}
		if (4 == difficultyLevel)
			{
			System.out.println("I bow in respect to a Master of COMBAT.");
			difficultyHealth = 100;
			difficultyDamage = 10;
			}
		if (5 == difficultyLevel)
			{
			System.out.println("I will attend your funeral.");
			difficultyHealth = 1000;
			difficultyDamage = 20;
			}
	System.out.println(" ");	
	System.out.println("Choose your class "
			+ "" + nameOfPlayer + " of " + homeLand + ".");	
	System.out.println(" ");
	System.out.println("You can be an Fighter, Healer, Thief or a Mage.");
	jobOfPlayer = userInput1.nextLine();
	System.out.println("An interesting choice.  Hail " + nameOfPlayer + " the "+ jobOfPlayer + "!");
	if ("Fighter".equals(jobOfPlayer))
		{
		System.out.println();
		System.out.println("I know that you will crush your enemies!");
		classWeaponBonus = 2;
		weaponName = "Sword";
		classDamage = 8;
		classHealth = 16;
		}
	if ("Mage".equals(jobOfPlayer))
		{
		System.out.println();
		System.out.println("I know that you will use your powers well!");
		classFireballBonus = 3;
		weaponName = "Staff";
		classDamage = 4;
		classHealth = 14;
		}
	if ("Healer".equals(jobOfPlayer))
		{
		System.out.println();
		System.out.println("I know that you will protect and heal with your skills.");
		classHealingBonus = 2;
		weaponName = "Mace";
		classDamage = 7;
		classHealth = 15;
		}
	if ("Thief".equals(jobOfPlayer))
		{
		System.out.println();
		System.out.println("I know you will be silent and deadly.");
		classDodgeBonus = 3;
		weaponName = "Dagger";
		classDamage = 5;
		classHealth = 14;
		}
	System.out.println();	
	System.out.println("You will awake soon " + nameOfPlayer + " of " + homeLand + ".");
	System.out.println(" ");
	System.out.println("Good luck.");
	System.out.println();	
	return difficultyLevel;	
	}
	
	public static int generatePlayerHitPoints()//Generates the monster's hit points and tell you what they are.
		{
	    Random randomNumber = new Random();
	    playerHitPoints = 5 + randomNumber.nextInt(godHealth + (levelOfPlayer * 10) + armorBonus + classHealth);
	    System.out.println("You awake in an areana with a vicious beast in front of you.");
		System.out.println();
	    return playerHitPoints;
	    }
	
	public static int generateMonsterHitPoints()//Generates the player's hit points and tell you what they are.
		{
		Random randomNumber = new Random(); 
		monsterHitPoints = (25 * levelOfPlayer) + randomNumber.nextInt(difficultyHealth);
		System.out.println("Enemy HP = " + monsterHitPoints + ".");
		System.out.println("Player HP = " + playerHitPoints + ".");
		System.out.println();
		return monsterHitPoints;
		}
	
	public static int chooseAction()//Lets the player choose their action.

		{
		System.out.println("Would you like to use a 1)" + weaponName + ", 2)Fireball Spell, 3)Healing Spell,");
		System.out.println("4) Lightning Blast?(do not try unless Level 20) or 5)to Dodge the next Atack."); 
		Scanner userInput1 = new Scanner(System.in);
		actionChoice = userInput1.nextInt();
		
		switch (actionChoice)
			{
			case 1:
				{
				dodgeAffect = 0;	
				playerAttackRoll();
				monsterHitPoints = (monsterHitPoints - totalDice);
				System.out.println("Enemy HP = " + monsterHitPoints + ".");
				System.out.println("Player HP = " + playerHitPoints + ".");
				System.out.println();
				break;
				}
				
			case 2:
				{
				dodgeAffect = 0;	
				Random randomNumber = new Random();
				diceRollOne = 1 + randomNumber.nextInt(3);
				diceRollTwo = 1 + randomNumber.nextInt(3);
				diceRollThree = 1 + randomNumber.nextInt(15);
				totalDice = (diceRollOne + diceRollTwo + diceRollThree + fireballBonus) * classFireballBonus;
				monsterHitPoints = (monsterHitPoints - totalDice);				
				System.out.println("You blast the enemy with flames and do " + totalDice + " damage!");
				System.out.println();
				System.out.println("Enemy HP = " + monsterHitPoints + ".");
				System.out.println("Player HP = " + playerHitPoints + ".");
				System.out.println();
				break;
				}
			case 3:	
				{
				dodgeAffect = 0;	
				Random randomNumber = new Random();
				diceRollOne = 1 + randomNumber.nextInt(4);
				diceRollTwo = 1 + randomNumber.nextInt(4);
				diceRollThree = 1 + randomNumber.nextInt(4);
				totalDice = diceRollOne + diceRollTwo + diceRollThree + healingSpellBonus;
				playerHitPoints = (playerHitPoints + (totalDice * classHealingBonus));
				System.out.println("You heal yourself " + totalDice * classHealingBonus + " points of health!");
				System.out.println();
				System.out.println("Enemy HP = " + monsterHitPoints + ".");
				System.out.println("Player HP = " + playerHitPoints + ".");
				System.out.println();
				break;	
				}
			case 4:
				{
				if("TGM".equals(nameOfPlayer))	
					{
					dodgeAffect = 0;
					Random randomNumber = new Random();
					diceRollOne = 50 + randomNumber.nextInt(100);
					diceRollTwo = 50 + randomNumber.nextInt(100);
					diceRollThree = 50 + randomNumber.nextInt(100);
					totalDice = diceRollOne + diceRollTwo + diceRollThree;
					monsterHitPoints = (monsterHitPoints - totalDice);
					System.out.println("Lightning archs towards the beast doing " + totalDice + " damage");
					System.out.println();
					System.out.println("Enemy HP = " + monsterHitPoints + ".");
					System.out.println("Player HP = " + playerHitPoints + ".");
					System.out.println();
					}
				if(levelOfPlayer >= 20)
					{
					dodgeAffect = 0;
					Random randomNumber = new Random();
					diceRollOne = 50 + randomNumber.nextInt(100);
					diceRollTwo = 50 + randomNumber.nextInt(100);
					diceRollThree = 50 + randomNumber.nextInt(100);
					totalDice = diceRollOne + diceRollTwo + diceRollThree;
					monsterHitPoints = (monsterHitPoints - totalDice);
					System.out.println("Lightning archs towards the beast doing " + totalDice + " damage");
					System.out.println();
					System.out.println("Enemy HP = " + monsterHitPoints + ".");
					System.out.println("Player HP = " + playerHitPoints + ".");
					System.out.println();
					}
				else
					{
					dodgeAffect = 0;
					Random randomNumber = new Random();
					diceRollOne = 1 + randomNumber.nextInt(2);
					diceRollTwo = 1 + randomNumber.nextInt(2);
					diceRollThree = 1 + randomNumber.nextInt(2);
					totalDice = diceRollOne + diceRollTwo + diceRollThree;
					playerHitPoints = (playerHitPoints - totalDice);
					System.out.println("The spell backfires doing " + totalDice + " damage to yourself.");
					System.out.println();
					System.out.println("Enemy HP = " + monsterHitPoints + ".");
					System.out.println("Player HP = " + playerHitPoints + ".");
					System.out.println();
					}
				break;
				}
			case 5:
				{
				dodgeAffect = 0;	
				Random randomNumber = new Random();
				diceRollOne = 1 + randomNumber.nextInt(10);
				dodgeAffect = diceRollOne * classDodgeBonus + dodgeBonus;
				System.out.println("You prepare to doge away from the enemie's next blow.");
				System.out.println();
				System.out.println("You will dodge " + dodgeAffect + " points of damage.");
				System.out.println();
				System.out.println("Enemy HP = " + monsterHitPoints + ".");
				System.out.println("Player HP = " + playerHitPoints + ".");
				System.out.println();
				break;
				}
			}
		return actionChoice;
		}
		
	public static int playerAttackRoll()//Rolls dice for the damage done by the player's sword.
	{
	Random randomNumber = new Random();
	diceRollOne = 2 + randomNumber.nextInt(classDamage);
	diceRollTwo = 2 + randomNumber.nextInt(classDamage);
	diceRollThree = 2 + randomNumber.nextInt(classDamage);
	totalDice = (diceRollOne + diceRollTwo + diceRollThree + weaponBonus) * classWeaponBonus;
	System.out.println("You swing your " + weaponName + " and do " + totalDice + " damage!");
	System.out.println();
	return totalDice;
	}

	public static int simulateCombat()//The whole combat packadge which makes it so that you fight until you or the beast is dead.
		{
		while(monsterHitPoints > 0)
			{
			monsterAttackRoll();
			if (playerHitPoints <= 0)
				{
				System.out.println("YOU DIED!");
				askPlayerIfTheyWantToPlayAgain();
				break;
				}
			else if (playerHitPoints != 0)
				{
				chooseAction();
				}
			}
		
		if (monsterHitPoints <= 0)
			{
			System.out.println("YOU HAVE SLAIN THE BEAST!");
			System.out.println();
			System.out.println("You find some treasure on the body of the beast.");
			System.out.println();
			numberOfSlainEnemies++;
			lootBeast();
			System.out.println();
			System.out.println("LEVEL UP!");
			levelOfPlayer++;
			System.out.println();
			System.out.println("You are now a Level " + levelOfPlayer + "!");
			askPlayerIfTheyWantToPlayAgain();
			}	
		return monsterHitPoints;
		}

	public static int monsterAttackRoll()//Rolls dice for the damage done by the monster's claws.
	{
		System.out.println("The creature growls at you and attacks!");
		System.out.println();
	Random randomNumber = new Random();
	diceRollOne = 1 + randomNumber.nextInt(difficultyDamage);
	diceRollTwo = 1 + randomNumber.nextInt(difficultyDamage);
	diceRollThree = 1 + randomNumber.nextInt(difficultyDamage);
	totalDice = diceRollOne + diceRollTwo + diceRollThree - dodgeAffect;
	System.out.println("The creature does " + totalDice + " damage!");
	System.out.println();
	playerHitPoints = (playerHitPoints - totalDice);
	System.out.println("Enemy HP = " + monsterHitPoints + ".");
	System.out.println("Player HP = " + playerHitPoints + ".");
	System.out.println();
	return totalDice;
	}
	
	public static int lootBeast()//Randomly generates loot from the dead beast.(Only if you killed it.)
		{
		generateNumber();
		System.out.println("You open the bag of loot at your feet.");
		System.out.println("");
		switch (lootNumber)
			{ 
			case 1:
			case 2:
			case 3:
				{
				System.out.println("You have found a Shield Scroll!");
				System.out.println();
				System.out.println("Level 2 Item.");
				System.out.println();
				armorBonus = armorBonus + 3;
				System.out.println("Your max HP has now been increased by 3.");
				break;
				}
			case 4:
			case 5:
			case 6:
			case 7:	
				{
				System.out.println("You have found some Iron Armor!");
				System.out.println();
				System.out.println("Level 1 Item.");
				System.out.println();
				armorBonus = armorBonus + 2;
				System.out.println("Your max HP has now been increased by 2.");
				break;
				}
			case 8:
			case 9:
			case 10:
				{
				System.out.println("You have found some Steel Armor!");
				System.out.println();
				System.out.println("Level 2 Item.");
				System.out.println();
				armorBonus = armorBonus + 5;
				System.out.println("Your max HP has now been increased by 5.");
				break;
				}
			case 11:
			case 12:
				{
				System.out.println("You have found some Titanium Armor!");
				System.out.println();
				System.out.println("Level 3 Item.");
				System.out.println();
				armorBonus = armorBonus + 10;
				System.out.println("Your max HP has now been increased by 10.");
				break;
				}
			case 13:
			case 14:
			case 15:
			case 16:
				{
				System.out.println("You have found an Iron " + weaponName + "!");
				System.out.println();
				System.out.println("Level 1 Item.");
				System.out.println();
				weaponBonus = weaponBonus + 2;
				System.out.println("You now do more damage with your " + weaponName + "!");
				break;
				}
			case 17:
			case 18:
			case 19:
				{
				System.out.println("You have found a Steel " + weaponName + "!");
				System.out.println();
				System.out.println("Level 2 Item.");
				System.out.println();
				weaponBonus = weaponBonus + 5;
				System.out.println("You now do more damage with your " + weaponName + "!");
				break;
				}
			case 20:
			case 21:
				{
				System.out.println("You have found a Titanium " + weaponName + "!");
				System.out.println();
				System.out.println("Level 3 Item.");
				System.out.println();
				weaponBonus = weaponBonus + 10;
				System.out.println("You now do more damage with your " + weaponName + "!");
				break;
				}
			case 22:
			case 23:
			case 24:
				{
				System.out.println("You have found a Fireball Scroll!");
				System.out.println();
				System.out.println("Level 2 Item.");
				System.out.println();
				fireballBonus = fireballBonus + 2;
				System.out.println("Your Fireball Spell does more damage now.");
				break;
				}
			case 25:
			case 26:
			case 27:
				{
				System.out.println("You have found a Healing Scroll!");
				System.out.println();
				System.out.println("Level 2 Item.");
				System.out.println();
				healingSpellBonus = healingSpellBonus + 3;
				System.out.println("Your Healing Spell heals you up more now.");
				break;
				}	
			case 28:
			case 29:
			case 30:
			case 31:
				{
				System.out.println("You have found Weak Boots of Dodging!");
				System.out.println();
				System.out.println("Level 1 Item.");
				System.out.println();
				dodgeBonus = dodgeBonus + 2;
				System.out.println("You dodge 2 more points of damage now!");
				break;
				}
			case 32:
			case 33:
			case 34:
				{
				System.out.println("You have found Average Boots of Dodging!");
				System.out.println();
				System.out.println("Level 2 Item.");
				System.out.println();
				dodgeBonus = dodgeBonus + 5;
				System.out.println("You dodge 5 more points of damage now!");
				break;
				}
			case 35:
			case 36:
				{
				System.out.println("You have found Legendary Boots of Dodging!");
				System.out.println();
				System.out.println("Level 3 Item.");
				System.out.println();
				dodgeBonus = dodgeBonus + 10;
				System.out.println("You dodge 10 more points of damage now!");
				break;
				}
			case 37:
				{
				System.out.println("You have found Excalibur!");
				System.out.println();
				System.out.println("Level 4 Item.");
				System.out.println();
				weaponBonus = weaponBonus + 15;
				System.out.println("You do 15 more points of damage with your sword now!");
				break;	
				}
			case 38:
				{
				System.out.println("You have found a Staff of Fire!");
				System.out.println();
				System.out.println("Level 4 Item.");
				System.out.println(); 
				fireballBonus = fireballBonus + 15;
				System.out.println("Your Fireball Spell now does 15 more points of damage.");
				break;	
				}
			case 39:
				{
				System.out.println("You have found a Ring of Healing!");	
				System.out.println();
				System.out.println("Level 4 Item.");
				System.out.println();
				healingSpellBonus = healingSpellBonus + 15;
				System.out.println("You heal yourself 15 more points now!");
				break;		
				}
			case 40:
				{
				System.out.println("You have found an Invisibility Cloak!");	
				System.out.println();
				System.out.println("Level 4 Item.");
				System.out.println();
				dodgeBonus = dodgeBonus + 15;
				System.out.println("You dodge 15 more points of damage now!");
				break;		
				}
			case 41:
				{
				System.out.println("YOu have found a suit of Dragon Scale Armor!");
				System.out.println();
				System.out.println("Level 4 Item.");
				System.out.println();
				armorBonus = armorBonus + 15;
				System.out.println("Your max health is 15 more points now!");
				}
			}
		return lootNumber;
		}
	
	public static int generateNumber()//Generates the random number for the lootBeast method.
	{
	Random randomNumber = new Random();
	lootNumber = 1 + randomNumber.nextInt(40);
	return lootNumber;
	}
	
	public static int askPlayerIfTheyWantToPlayAgain()//Asks the player if they want to play again or if they want to stop playing.
		{
		System.out.println();
		System.out.println("Would you like to play again " + nameOfPlayer + "?");
		System.out.println();
		System.out.println("Or does " + homeLand + " need you?");
		System.out.println();
		System.out.println("Press 1 to play again and press 2 to exit the game.");
		Scanner userInput1 = new Scanner(System.in);
		playAgainChoice = userInput1.nextInt();
		if (playAgainChoice == 2)
			{
			System.out.println("Farewell " + nameOfPlayer + " of " + homeLand + ".");
			System.out.println();
			if (numberOfSlainEnemies == 1)
				{
				pluralVariable = " 1 deadly beast.  Better one than none.";
				}
			else if (numberOfSlainEnemies == 0)
				{
				pluralVariable = "no deadly beasts.  You are a failure.";
				}
			else 
				{
				pluralVariable = "" + numberOfSlainEnemies + " deadly beasts.";
				if(numberOfSlainEnemies > 5)
					{
					System.out.println();
					System.out.println("You are a master at COMBAT.");
					}
				else if (numberOfSlainEnemies > 10)
					{
					System.out.println();
					System.out.println("You are a Legend of COMBAT.");
					}
				else if (numberOfSlainEnemies > 15)
					{
					System.out.println();
					System.out.println("You spend too much time on this game.");
					}
				}
			System.out.println("Let Everyone know that you were a Level " + levelOfPlayer + " " + jobOfPlayer + " and you fought "
					+ "valiantly, defeating " + pluralVariable + "");
			System.out.println();
			System.out.println("Best of luck to you.");
			System.exit(0);
			}
		return playAgainChoice;
		}
	}







