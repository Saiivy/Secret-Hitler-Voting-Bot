package hitler;


/**
 * 
 * @author gursimar singh hehar
 * This class represents a player object
 */
public class Player {

    private  String name;
    private static Type type;
    private  String phoneNumber;

    public Player(String name, Type type,String phoneNumber) {
        this.name = name;
        this.type = type;
        this.phoneNumber = phoneNumber;
    }

    public static Type getType() {
        return Player.type;
    }

    public  String getPhoneNumber() {
        return phoneNumber;
    }

    public  void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", name, type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getName() {
        return name;
    }

    public static void setType(Type type) {
        Player.type = type;
    }

    public enum Type {
        HITLER, FASCIST, LIBERAL;

    }

}
