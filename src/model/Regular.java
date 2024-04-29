package model;

public class Regular extends User {

    public Regular(String id, String name, String nickname) {
        super(id, name, nickname);
        
    }
    

    @Override
    public String toString() {
        return "USUARIO REGULAR:" + "\n Cedula del usuario:" + getId() + "\n Nombre:" + getName()
        + "\n Nickname:" + getNickname() + ".";
    }


   

    
    
    

}

