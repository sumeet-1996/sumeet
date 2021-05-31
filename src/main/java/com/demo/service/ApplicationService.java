package com.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.demo.beans.Board;
import com.demo.beans.Word;

public class ApplicationService {
	private static List<Word> words = new ArrayList<>();
	private static Board board;

	public void updateWord(String gameState, String currentTeam, int index) {
		board.setGameState(gameState);
		board.setCurrentTeam(currentTeam);
		words.get(index).setStatus("revealed");
	}

	public Board startNewGame() {
		board = new Board();
		board.setGameState("game-started");
		board.setCurrentTeam("red");
		words = new ArrayList<>();
		ApplicationService.fetchWordsFromFile();
		board.setWords(words);
		return board;
	}

	public Board fetchBoard() {
		if (board == null) {
			board = new Board();
			board.setGameState("game-started");
			board.setCurrentTeam("red");
			ApplicationService.fetchWordsFromFile();
			board.setWords(words);
		}		
		return board;
	}

	public static void fetchWordsFromFile() {
		String data = "AFRICA,AGENT,AIR,ALIEN,ALPS,AMAZON,AMBULANCE,AMERICA,ANGEL,ANTARCTICA,APPLE,ARM,ATLANTIS,AUSTRALIA,AZTEC,BACK,BALL,BAND,BANK,BAR,BARK,BAT,BATTERY,BEACH,BEAR,BEAT,BED,BEIJING,BELL,BELT,BERLIN,BERMUDA,BERRY,BILL,BLOCK,BOARD,BOLT,BOMB,BOND,BOOM,BOOT,BOTTLE,BOW,BOX,BRIDGE,BRUSH,BUCK,BUFFALO,BUG,BUGLE,BUTTON,CALF,CANADA,CAP,CAPITAL,CAR,CARD,CARROT,CASINO,CAST,CAT,CELL,CENTAUR,CENTER,CHAIR,CHANGE,CHARGE,CHECK,CHEST,CHICK,CHINA,CHOCOLATE,CHURCH,CIRCLE,CLIFF,CLOAK,CLUB,CODE,COLD,COMIC,COMPOUND,CONCERT,CONDUCTOR,CONTRACT,COOK,COPPER,COTTON,COURT,COVER,CRANE,CRASH,CRICKET,CROSS,CROWN,CYCLE,CZECH,DANCE,DATE,DAY,DEATH,DECK,DEGREE,DIAMOND,DICE,DINOSAUR,DISEASE,DOCTOR,DOG,DRAFT,DRAGON,DRESS,DRILL,DROP,DUCK,DWARF,EAGLE,EGYPT,EMBASSY,ENGINE,ENGLAND,EUROPE,EYE,FACE,FAIR,FALL,FAN,FENCE,FIELD,FIGHTER,FIGURE,FILE,FILM,FIRE,FISH,FLUTE,FLY,FOOT,FORCE,FOREST,FORK,FRANCE,GAME,GAS,GENIUS,GERMANY,GHOST,GIANT,GLASS,GLOVE,GOLD,GRACE,GRASS,GREECE,GREEN,GROUND,HAM,HAND,HAWK,HEAD,HEART,HELICOPTER,HIMALAYAS,HOLE,HOLLYWOOD,HONEY,HOOD,HOOK,HORN,HORSE,HORSESHOE,HOSPITAL,HOTEL,ICE,ICE CREAM,INDIA,IRON,IVORY,JACK,JAM,JET,JUPITER,KANGAROO,KETCHUP,KEY,KID,KING,KIWI,KNIFE,KNIGHT,LAB,LAP,LASER,LAWYER,LEAD,LEMON,LEPRECHAUN,LIFE,LIGHT,LIMOUSINE,LINE,LINK,LION,LITTER,LOCH NESS,LOCK,LOG,LONDON,LUCK,MAIL,MAMMOTH,MAPLE,MARBLE,MARCH,MASS,MATCH,MERCURY,MEXICO,MICROSCOPE,MILLIONAIRE,MINE,MINT,MISSILE,MODEL,MOLE,MOON,MOSCOW,MOUNT,MOUSE,MOUTH,MUG,NAIL,NEEDLE,NET,NEW YORK,NIGHT,NINJA,NOTE,NOVEL,NURSE,NUT,OCTOPUS,OIL,OLIVE,OLYMPUS,OPERA,ORANGE,ORGAN,PALM,PAN,PANTS,PAPER,PARACHUTE,PARK,PART,PASS,PASTE,PENGUIN,PHOENIX,PIANO,PIE,PILOT,PIN,PIPE,PIRATE,PISTOL,PIT,PITCH,PLANE,PLASTIC,PLATE,PLATYPUS,PLAY,PLOT,POINT,POISON,POLE,POLICE,POOL,PORT,POST,POUND,PRESS,PRINCESS,PUMPKIN,PUPIL,PYRAMID,QUEEN,RABBIT,RACKET,RAY,REVOLUTION,RING,ROBIN,ROBOT,ROCK,ROME,ROOT,ROSE,ROULETTE,ROUND,ROW,RULER,SATELLITE,SATURN,SCALE,SCHOOL,SCIENTIST,SCORPION,SCREEN,SCUBA DIVER,SEAL,SERVER,SHADOW,SHAKESPEARE,SHARK,SHIP,SHOE,SHOP,SHOT,SINK,SKYSCRAPER,SLIP,SLUG,SMUGGLER,SNOW,SNOWMAN,SOCK,SOLDIER,SOUL,SOUND,SPACE,SPELL,SPIDER,SPIKE,SPINE,SPOT,SPRING,SPY,SQUARE,STADIUM,STAFF,STAR,STATE,STICK,STOCK,STRAW,STREAM,STRIKE,STRING,SUB,SUIT,SUPERHERO,SWING,SWITCH,TABLE,TABLET,TAG,TAIL,TAP,TEACHER,TELESCOPE,TEMPLE,THEATER,THIEF,THUMB,TICK,TIE,TIME,TOKYO,TOOTH,TORCH,TOWER,TRACK,TRAIN,TRIANGLE,TRIP,TRUNK,TUBE,TURKEY,UNDERTAKER,UNICORN,VACUUM,VAN,VET,WAKE,WALL,WAR,WASHER,WASHINGTON,WATCH,WATER,WAVE,WEB,WELL,WHALE,WHIP,WIND,WITCH,WORM,YARD";
		String[] wordsArr = data.split(",");
		if (wordsArr.length < 25) {
			System.out.println("Insufficient number of words");
		}

		String[] colours = { "blue", "red", "black", "neutral" };
		HashMap<String, Integer> coloursCount = new HashMap<>();
		coloursCount.put("blue", 8);
		coloursCount.put("red", 9);
		coloursCount.put("black", 1);
		coloursCount.put("neutral", 7);
		List<Integer> usedIndexes = new ArrayList<>();

		int count = 0;
		while (count < 25) {
			Random random = new Random();
			int index = random.nextInt(wordsArr.length);
			if (usedIndexes.contains(index)) {
			} else {
				boolean colourFound = false;
				while (!colourFound) {
					Random random1 = new Random();
					int colourIndex = random1.nextInt(colours.length);
					String colourName = colours[colourIndex];
					int colourCount = coloursCount.get(colourName);
					if (colourCount > 0) {
						Word word = new Word();
						word.setTitle(wordsArr[index]);
						word.setColour(colours[colourIndex]);
						word.setStatus("hidden-word");
						words.add(word);
						coloursCount.put(colourName, --colourCount);
						colourFound = true;
						count++;
						usedIndexes.add(index);
					}
				}
			}
		}
	}

}
