package enigma.models.enigma1;

import enigma.models.AbstractKeyboard;
import enigma.models.ModelType;

public class EnigmaOneKeyboard extends AbstractKeyboard
{
    public static EnigmaOneKeyboard modelOneKeyboard()
    {
        return new EnigmaOneKeyboard(ModelType.ENIGMA_ONE);
    }

    private EnigmaOneKeyboard(ModelType modelType)
    {
        super(modelType);
    }

    @Override
    public char pressKey(char character) {
        if (characterIsPermitted(character)){
            return character;
        }
        else
        {
            throw new IllegalArgumentException("The character provided is not permitted for this model of enigma.");
        }
    }
}
