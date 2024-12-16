package dam.pmdm.videoclase2;

/**
 *La clase CharacterData representa al objeto personaje, constituido por los atributos imagen,
 * nombre, descripción y habilidades
 */

public class CharacterData {

    private final int image;
    private final int name;
    private final int description;
    private final int skills;

    public CharacterData(int image, int name, int description, int skills) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.skills = skills;
    }

    public int getImage() {
        return image;
    }

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public int getSkills() {
        return skills;
    }
}

