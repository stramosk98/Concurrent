package exercise08;

import java.util.Random;

public class RandomPlate {
	private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final Random RANDOM = new Random();

    public static String generatePlate() {
        StringBuilder plate = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            plate.append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())));
        }

        plate.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
        plate.append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())));

        for (int i = 0; i < 2; i++) {
            plate.append(NUMBERS.charAt(RANDOM.nextInt(NUMBERS.length())));
        }

        return plate.toString();
    }
}
