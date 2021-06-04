package enigma.metadata.permittedcharacters;

import java.util.Set;

public interface PermittedCharacters {
    boolean characterIsPermitted(char character);
    char[] getRawPermittedCharacters();
}
