package model;

public class Premium extends User {

    private Category category;

   
    public Premium(String id, String name, String nickname, Category category) {
        super(id, name, nickname);
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public boolean setCategory(Category category) {
        this.category = category;
		return true;
    }

    @Override
    public String toString() {
        return "USUARIO PREMIUM \nCategoria:" + category + "\n Cedula del usuario:" + getId() + "\n Nombre:" + getName()
                + "\n Nickname:" + getNickname() + ".";
    }


    
}
