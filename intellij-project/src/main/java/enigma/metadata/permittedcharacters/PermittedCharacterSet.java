package enigma.metadata.permittedcharacters;

import java.util.Set;

public class PermittedCharacterSet implements PermittedCharacters {
    private final Set<Character> permittedCharacters;

    public PermittedCharacterSet(Set<Character> permittedCharacters) {
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
}
