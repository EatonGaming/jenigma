package enigma.components;

import java.util.Set;

public interface Keyboard
{
    Set<Character> getPermittedCharacters();

    char pressKey(char character);
}
