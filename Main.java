import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;

    public static void main(String[] args) {

        int rotationAngle;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите угол поворота 90, 180 или 270 градусов:");
            String inputRotationAngle = scanner.nextLine();
            try {
                rotationAngle = Integer.parseInt(inputRotationAngle);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введено не число.");
            }
        }

        int[][] colors = new int[SIZE][SIZE];

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }
        inputMatrix(colors);
        System.out.format("\nПоворот на %3d.\n\n", rotationAngle);
        switch (rotationAngle) {
            case 90: {
                inputMatrix(newMatrix(colors));
            }
            case 180: {
                for (int i = 0; i < 2; i++) {
                    colors = newMatrix(colors);
                }
                inputMatrix(colors);
            }
            case 270: {
                for (int i = 0; i < 3; i++) {
                    colors = newMatrix(colors);
                }
                inputMatrix(colors);
            }
        }
    }

    public static void inputMatrix(int[][] colors) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] newMatrix(int[][] colors) {
        int[][] newColors = new int[SIZE][SIZE];
        int len = SIZE - 1;

        for (int i = len; i >= 0; i--) {
            for (int j = 0; j < SIZE; j++) {
                newColors[j][len - i] = colors[i][j];
            }
        }
        return newColors;
    }
}