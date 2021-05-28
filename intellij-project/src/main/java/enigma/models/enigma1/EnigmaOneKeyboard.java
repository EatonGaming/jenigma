package enigma.models.enigma1;

import enigma.components.Keyboard;
import enigma.metadata.permittedcharacters.PermittedCharacters;
import enigma.models.ModelType;

public class EnigmaOneKeyboard implements Keyboard
{
    private final PermittedCharacters permittedCharacters;

    public static EnigmaOneKeyboard modelOneKeyboard()
    {
        return new EnigmaOneKeyboard(ModelType.ENIGMA_ONE.permittedCharacters);
    }

    private EnigmaOneKeyboard(PermittedCharacters permittedCharacters)
    {
        this.permittedCharacters = permittedCharacters;
    }

    @Override
    public char pressKey(char character) {
        if (permittedCharacters.characterIsPermitted(character)){
            return character;
        }
        else
        {
            throw new IllegalArgumentException("The character provided is not permitted for this model of enigma.");
        }
    }
}
