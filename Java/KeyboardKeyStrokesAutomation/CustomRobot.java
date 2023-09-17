package Java.KeyboardKeyStrokesAutomation;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CustomRobot extends Robot {

    public CustomRobot() throws AWTException {
        super();
    }

    private void typeKeyEvent(int... keyEvents) {
        keyPress(keyEvents[0]);
        for (int i = 1; i < keyEvents.length; i++) {
            typeChar(keyEvents[i]);
        }
        keyRelease(keyEvents[0]);
    }

    public void typeChar(char c) {
        // use newer switch statement
        switch (c) {
            case '{' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD3);
            case '}' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD5);
            case '(' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUMPAD0);
            case ')' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUMPAD1);
            case ':' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD5, KeyEvent.VK_NUMPAD8);
            case '!' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD3);
            case '&' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD8);
            case '|' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD4);
            case '<' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD0);
            case '>' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD2);
            case '+' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUMPAD3);
            case '~' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD6);
            case '@' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD4);
            case '#' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD5);
            case '$' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD6);
            case '%' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD7);
            case '^' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD9, KeyEvent.VK_NUMPAD4);
            case '*' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUMPAD2);
            case '`' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD9, KeyEvent.VK_NUMPAD6);
            case '_' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD9, KeyEvent.VK_NUMPAD5);
            case '"' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD4);
            case '?' -> typeKeyEvent(KeyEvent.VK_ALT, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD3);
            default -> {
                // Convert the character to its corresponding key code and type it
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                if (keyCode != KeyEvent.VK_UNDEFINED) {
                    if (Character.isUpperCase(c)) {
                        keyPress(KeyEvent.VK_SHIFT);
                    }
                    typeChar(keyCode);
                    if (Character.isUpperCase(c)) {
                        keyRelease(KeyEvent.VK_SHIFT);
                    }
                }
            }
        }
    }

    public void typeChar(int keyEvents) {
        keyPress(keyEvents);
        keyRelease(keyEvents);
    }
}
