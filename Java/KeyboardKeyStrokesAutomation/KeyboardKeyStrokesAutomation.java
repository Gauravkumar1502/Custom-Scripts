package Java.KeyboardKeyStrokesAutomation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class KeyboardKeyStrokesAutomation {
    public static void main(String[] args) throws AWTException {
        if (args.length != 1) {
            System.out.println("Usage: java KeyboardKeyStrokesAutomation <file>");
            System.exit(1);
        }
        // print characters if it is not defined in KeyEvent
        String input = readTxtFile(args[0]);
        // wait for 3 second for user to place cursor in the right program and right
        // place before starting typing using robot
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            CustomRobot robot = new CustomRobot();
            robot.setAutoDelay(5);
            typeTextWithRobot(robot, input);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static String readTxtFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void typeTextWithRobot(CustomRobot robot, String text) {
        for (char c : text.toCharArray())
            robot.typeChar(c);
    }

}