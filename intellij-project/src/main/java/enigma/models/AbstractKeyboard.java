package enigma.models;

import enigma.components.Keyboard;

import java.util.Set;

public abstract class AbstractKeyboard implements Keyboard {
    protected final ModelType modelType;

    protected AbstractKeyboard(ModelType modelType) {
        this.modelType = modelType;
    }

    @Override
    public Set<Character> getPermittedCharacters() {
        return modelType.permittedCharacters;
    }

    protected boolean characterIsPermitted(char character)
    {
        Set<Character> permittedCharacters = getPermittedCharacters();

        return permittedCharacters.contains(character);
    }
}
