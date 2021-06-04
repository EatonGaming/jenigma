package enigma.metadata.permittedcharacters;

import java.util.List;
import java.util.Set;

public class PermittedCharacterSet implements PermittedCharacters {
    private final List<Character> permittedCharacters;

    public PermittedCharacterSet(List<Character> permittedCharacters) {
        this.permittedCharacters = permittedCharacters;
    }

    @Override
    public boolean characterIsPermitted(char character)
    {
        if (permittedCharacters == null || permittedCharacters.isEmpty())
        {
            return false;
        }
        else
        {
            return permittedCharacters.contains(character);
        }
    }

    @SuppressWarnings("UnnecessaryUnboxing")
    @Override
    public char[] getRawPermittedCharacters() {
        int numberOfCharacters = permittedCharacters.size();
        Character[] permittedCharactersAsArray = permittedCharacters.toArray(Character[]::new);
        char[] rawPermittedCharacters = new char[numberOfCharacters];

        for (int i = 0; i < numberOfCharacters; i++) {
            rawPermittedCharacters[i] = permittedCharactersAsArray[i].charValue();
        }

        return rawPermittedCharacters;
    }
}
