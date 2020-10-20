package hitler;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;
import hitler.Player.Type;
import static hitler.Player.Type.FASCIST;
import static hitler.Player.Type.HITLER;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Hitler {

    //Datafield for storing player types
    static String fasicst = "";
    static String liberal = "";
    static String hitler = "";

    //Datafields to store player names 
    static String name1 = "";
    static String name10 = "";
    static String name2 = "";
    static String name3 = "";
    static String name4 = "";
    static String name5 = "";
    static String name6 = "";
    static String name7 = "";
    static String name8 = "";
    static String name9 = "";
    static String fasicstPlayer = "";
    static String hitlerPlayer2 = "";
    static String fasicstPlayer2 = "";
    static String fasicstPlayer3 = "";
    static String liberalPlayer = "";
    static String hitlerPlayer = "";
    static String liberalPlayer1 = "";
    static String liberalPlayer2 = "";
    static String liberalPlayer3 = "";
    static String liberalPlayer4 = "";
    static String liberalPlayer5 = "";
    static String liberalPlayer6 = "";

    //Datafields for phoneNumber
    static String number0 = "";
    static String number1 = "";
    static String number2 = "";
    static String number3 = "";
    static String number4 = "";
    static String number5 = "";
    static String number6 = "";
    static String number7 = "";
    static String number8 = "";
    static String number9 = "";
    static String number10 = "";
    static String number11 = "";
    static String number12 = "";

    static List<String> liberalPlayersList = new ArrayList();
    static List<String> liberalPlayersPhoneList = new ArrayList();
    static List<String> facistPlayersPhoneList = new ArrayList();
    static List<String> hitlerPlayersPhoneList = new ArrayList();
    static List<String> hitlerPlayersList = new ArrayList();

    static List<String> facistPlayersList = new ArrayList();

    public static void main(String[] args) throws IOException, NexmoClientException, InterruptedException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number of Players");

        //For Five Players -->>
        int PlayerCount = input.nextInt();
        switch (PlayerCount) {
            case 5:

                //Calling method for input
                FivePlayerNameInput(input);

                //LinkedList to store player type for five players
                LinkedList<Type> shuffleTypeList = new LinkedList<Type>(Arrays.asList(Type.FASCIST, Type.LIBERAL,
                        Type.LIBERAL, Type.LIBERAL, Type.HITLER));
                Collections.shuffle(shuffleTypeList);

                //LinkedList to store player numbers for five players
                LinkedList<String> shuffleNumberList = new LinkedList(Arrays.asList(number1, number2, number3, number4, number5));

                //For Five Players -->>
                //List that stores player objects
                List<Player> players = Arrays.asList(
                        new Player(name1, Type.HITLER, number1),
                        new Player(name2, Type.FASCIST, number2),
                        new Player(name3, Type.LIBERAL, number3),
                        new Player(name4, Type.LIBERAL, number4),
                        new Player(name5, Type.HITLER, number5));

                //Setting randomly type to players..
                for (Player p : players) {
                    p.setType(shuffleTypeList.pop());
                    p.setPhoneNumber(shuffleNumberList.pop());

                    //Getting player name accroding to their card type.'
                    switch (p.getType()) {
                        case HITLER:
                            //Name and type of player   
                            hitler = String.valueOf(p.getType());
                            hitlerPlayer = String.valueOf(p.getName());
                            number5 = p.getPhoneNumber();
                            break;

                        case FASCIST:
                            fasicst = String.valueOf(p.getType());
                            fasicstPlayer = String.valueOf(p.getName());
                            number4 = p.getPhoneNumber();
                            break;

                        case LIBERAL:
                            number3 = p.getPhoneNumber();
                            liberal = String.valueOf(p.getType());
                            liberalPlayer = String.valueOf(p.getName());

                            //adding all liberals to list
                            liberalPlayersPhoneList.add(number3);
                            liberalPlayersList.add(liberalPlayer);
                            break;
                    }

                }
                //Getting three liberal players from list outside loop 
                System.out.println(liberalPlayersList);

                liberalPlayer1 = liberalPlayersList.get(0);
                liberalPlayer2 = liberalPlayersList.get(1);
                liberalPlayer3 = liberalPlayersList.get(2);

                number1 = liberalPlayersPhoneList.get(0);
                number2 = liberalPlayersPhoneList.get(1);
                number0 = liberalPlayersPhoneList.get(2);

                //calling the method now to send the sms
                sendMessageFivePlayers();

            //For Six Player-->>
            case 6:
                FivePlayerNameInput(input);
                System.out.println("Enter 6th player Name");
                name6 = input.next();
                System.out.println("Enter 6th player Phone Number");
                number0 = input.next();

                //LinkedList to store player type for six players
                LinkedList<Type> shuffleTypeList2 = new LinkedList<Type>(Arrays.asList(Type.FASCIST, Type.LIBERAL,
                        Type.LIBERAL, Type.LIBERAL, Type.HITLER, Type.LIBERAL));
                Collections.shuffle(shuffleTypeList2);

                //LinkedList to store player numbers for five players
                LinkedList<String> shuffleNumberList2 = new LinkedList(Arrays.asList(number1, number2, number3, number4,
                        number5, number0));

                //For Five Players -->>
                //List that stores player objects
                List<Player> players2 = Arrays.asList(
                        new Player(name1, Type.HITLER, number1),
                        new Player(name2, Type.FASCIST, number2),
                        new Player(name3, Type.LIBERAL, number3),
                        new Player(name4, Type.LIBERAL, number4),
                        new Player(name5, Type.HITLER, number5),
                        new Player(name6, Type.LIBERAL, number0));

                //Setting randomly type to players..
                for (Player p2 : players2) {
                    p2.setType(shuffleTypeList2.pop());
                    p2.setPhoneNumber(shuffleNumberList2.pop());

                    //Getting player name accroding to their card type.'
                    switch (p2.getType()) {
                        case HITLER:
                            //Name and type of player   
                            hitler = String.valueOf(p2.getType());
                            hitlerPlayer = String.valueOf(p2.getName());
                            number5 = p2.getPhoneNumber();
                            break;

                        case FASCIST:
                            fasicst = String.valueOf(p2.getType());
                            fasicstPlayer = String.valueOf(p2.getName());
                            number4 = p2.getPhoneNumber();
                            break;

                        case LIBERAL:
                            number3 = p2.getPhoneNumber();
                            liberal = String.valueOf(p2.getType());
                            liberalPlayer = String.valueOf(p2.getName());

                            //adding all liberals to list
                            liberalPlayersPhoneList.add(number3);
                            liberalPlayersList.add(liberalPlayer);
                            break;
                    }

                }
                //Getting three liberal players from list outside loop 
                System.out.println(liberalPlayersList);

                liberalPlayer1 = liberalPlayersList.get(0);
                liberalPlayer2 = liberalPlayersList.get(1);
                liberalPlayer3 = liberalPlayersList.get(2);
                liberalPlayer4 = liberalPlayersList.get(3);

                number1 = liberalPlayersPhoneList.get(0);
                number2 = liberalPlayersPhoneList.get(1);
                number0 = liberalPlayersPhoneList.get(2);
                number6 = liberalPlayersPhoneList.get(3);

                //calling the method now to send the sms
                sendMessageFivePlayers();
                //Sending Text's Now to remaining liberal
                sendMessage("13069861849", number6, "Hi " + liberalPlayer4 + " You are a " + liberal);
        }

        //For 7 players -->>
        if (PlayerCount == 7) {
            FivePlayerNameInput(input);
            System.out.println("Enter 6th player Name");
            name6 = input.next();
            System.out.println("Enter 6th player Phone Number");
            number0 = input.next();
            System.out.println("Enter 7th player Name");
            name7 = input.next();
            System.out.println("Enter 7th player Phone Number");
            number7 = input.next();

            //For 7 Players -->>
            //List that stores player objects
            //Setting randomly type to players..
            LinkedList<Type> shuffleTypeList2 = new LinkedList<Type>(Arrays.asList(Type.FASCIST, Type.LIBERAL,
                    Type.LIBERAL, Type.LIBERAL, Type.HITLER, Type.LIBERAL, Type.FASCIST));
            Collections.shuffle(shuffleTypeList2);

            //LinkedList to store player numbers for five players
            LinkedList<String> shuffleNumberList2 = new LinkedList(Arrays.asList(number1, number2, number3, number4,
                    number5, number0, number7));

            List<Player> players3 = Arrays.asList(
                    new Player(name1, Type.HITLER, number1),
                    new Player(name2, Type.FASCIST, number2),
                    new Player(name3, Type.LIBERAL, number3),
                    new Player(name4, Type.LIBERAL, number4),
                    new Player(name5, Type.LIBERAL, number5),
                    new Player(name6, Type.FASCIST, number0),
                    new Player(name7, Type.LIBERAL, number7));

            for (Player p2 : players3) {
                p2.setType(shuffleTypeList2.pop());
                p2.setPhoneNumber(shuffleNumberList2.pop());

                //Getting player name accroding to their card type.'
                switch (p2.getType()) {
                    case HITLER:
                        //Name and type of player   
                        hitler = String.valueOf(p2.getType());
                        hitlerPlayer = String.valueOf(p2.getName());
                        number5 = p2.getPhoneNumber();
                        break;

                    case FASCIST:
                        fasicst = String.valueOf(p2.getType());
                        fasicstPlayer = String.valueOf(p2.getName());
                        number4 = p2.getPhoneNumber();

                        facistPlayersList.add(fasicstPlayer);
                        facistPlayersPhoneList.add(number4);

                        break;

                    case LIBERAL:
                        number3 = p2.getPhoneNumber();
                        liberal = String.valueOf(p2.getType());
                        liberalPlayer = String.valueOf(p2.getName());

                        //adding all liberals to list
                        liberalPlayersPhoneList.add(number3);
                        liberalPlayersList.add(liberalPlayer);
                        break;
                }
            }
            fasicstPlayer = facistPlayersList.get(0);
            fasicstPlayer2 = facistPlayersList.get(1);
            number8 = facistPlayersPhoneList.get(0);
            number9 = facistPlayersPhoneList.get(1);

            liberalPlayer1 = liberalPlayersList.get(0);
            liberalPlayer2 = liberalPlayersList.get(1);
            liberalPlayer3 = liberalPlayersList.get(2);
            liberalPlayer4 = liberalPlayersList.get(3);

            number1 = liberalPlayersPhoneList.get(0);
            number2 = liberalPlayersPhoneList.get(1);
            number0 = liberalPlayersPhoneList.get(2);
            number6 = liberalPlayersPhoneList.get(3);

            MessageSevenPlayers();

        }

        //For 8 players -->>
        if (PlayerCount == 8) {
            FivePlayerNameInput(input);
            System.out.println("Enter 6th player Name");
            name6 = input.next();
            System.out.println("Enter 6th player Phone Number");
            number0 = input.next();
            System.out.println("Enter 7th player Name");
            name7 = input.next();
            System.out.println("Enter 7th player Phone Number");
            number7 = input.next();
            System.out.println("Enter 8th player Name");
            name8 = input.next();
            System.out.println("Enter 8th player Phone Number");
            number8 = input.next();

            //List that stores player objects
            //Setting randomly type to players..
            LinkedList<Type> shuffleTypeList4 = new LinkedList<Type>(Arrays.asList(Type.FASCIST, Type.LIBERAL,
                    Type.LIBERAL, Type.LIBERAL, Type.HITLER, Type.LIBERAL, Type.FASCIST, Type.LIBERAL));
            Collections.shuffle(shuffleTypeList4);

            //LinkedList to store player numbers for five players
            LinkedList<String> shuffleNumberList4 = new LinkedList(Arrays.asList(number1, number2, number3, number4,
                    number5, number0, number7));

            List<Player> players3 = Arrays.asList(
                    new Player(name1, Type.HITLER, number1),
                    new Player(name2, Type.FASCIST, number2),
                    new Player(name3, Type.LIBERAL, number3),
                    new Player(name4, Type.LIBERAL, number4),
                    new Player(name5, Type.LIBERAL, number5),
                    new Player(name6, Type.FASCIST, number0),
                    new Player(name7, Type.LIBERAL, number7),
                    new Player(name8, Type.FASCIST, number8));

            for (Player p2 : players3) {
                p2.setType(shuffleTypeList4.pop());
                p2.setPhoneNumber(shuffleNumberList4.pop());

                //Getting player name accroding to their card type.'
                switch (p2.getType()) {
                    case HITLER:
                        //Name and type of player   
                        hitler = String.valueOf(p2.getType());
                        hitlerPlayer = String.valueOf(p2.getName());
                        number5 = p2.getPhoneNumber();
                        break;

                    case FASCIST:
                        fasicst = String.valueOf(p2.getType());
                        fasicstPlayer = String.valueOf(p2.getName());
                        number4 = p2.getPhoneNumber();

                        facistPlayersList.add(fasicstPlayer);
                        facistPlayersPhoneList.add(number4);

                        break;

                    case LIBERAL:
                        number3 = p2.getPhoneNumber();
                        liberal = String.valueOf(p2.getType());
                        liberalPlayer = String.valueOf(p2.getName());

                        //adding all liberals to list
                        liberalPlayersPhoneList.add(number3);
                        liberalPlayersList.add(liberalPlayer);
                        break;
                }
            }
            fasicstPlayer = facistPlayersList.get(0);
            fasicstPlayer2 = facistPlayersList.get(1);
            number8 = facistPlayersPhoneList.get(0);
            number9 = facistPlayersPhoneList.get(1);

            liberalPlayer1 = liberalPlayersList.get(0);
            liberalPlayer2 = liberalPlayersList.get(1);
            liberalPlayer3 = liberalPlayersList.get(2);
            liberalPlayer4 = liberalPlayersList.get(3);
            liberalPlayer5 = liberalPlayersList.get(4);

            number1 = liberalPlayersPhoneList.get(0);
            number2 = liberalPlayersPhoneList.get(1);
            number0 = liberalPlayersPhoneList.get(2);
            number6 = liberalPlayersPhoneList.get(3);
            number10 = liberalPlayersPhoneList.get(4);

            MessageSevenPlayers();
            TimeUnit.SECONDS.sleep(3);

            sendMessage("13069861849", number10, "Hi " + liberalPlayer5 + " You are a " + liberal);

        }
        if (PlayerCount == 9) {
            //For 9 players -->>
            FivePlayerNameInput(input);
            System.out.println("Enter 6th player Name");
            name6 = input.next();
            System.out.println("Enter 6th player Phone Number");
            number0 = input.next();
            System.out.println("Enter 7th player Name");
            name7 = input.next();
            System.out.println("Enter 7th player Phone Number");
            number7 = input.next();
            System.out.println("Enter 8th player Name");
            name8 = input.next();
            System.out.println("Enter 8th player Phone Number");
            number8 = input.next();
            System.out.println("Enter 9th player Name");
            name9 = input.next();
            System.out.println("Enter 9th player Phone Number");
            number9 = input.next();

            //List that stores player objects
            //Setting randomly type to players..
            LinkedList<Type> shuffleTypeList4 = new LinkedList<Type>(Arrays.asList(Type.FASCIST, Type.LIBERAL,
                    Type.LIBERAL, Type.LIBERAL, Type.HITLER, Type.LIBERAL, Type.FASCIST, Type.LIBERAL, Type.FASCIST));
            Collections.shuffle(shuffleTypeList4);

            //LinkedList to store player numbers for five players
            LinkedList<String> shuffleNumberList4 = new LinkedList(Arrays.asList(number1, number2, number3, number4,
                    number5, number0, number7, number8, number9));

            List<Player> players3 = Arrays.asList(
                    new Player(name1, Type.HITLER, number1),
                    new Player(name2, Type.FASCIST, number2),
                    new Player(name3, Type.LIBERAL, number3),
                    new Player(name4, Type.LIBERAL, number4),
                    new Player(name5, Type.LIBERAL, number5),
                    new Player(name6, Type.FASCIST, number0),
                    new Player(name7, Type.LIBERAL, number7),
                    new Player(name8, Type.FASCIST, number8),
                    new Player(name9, Type.LIBERAL, number9));

            for (Player p2 : players3) {
                p2.setType(shuffleTypeList4.pop());
                p2.setPhoneNumber(shuffleNumberList4.pop());

                //Getting player name accroding to their card type.'
                switch (p2.getType()) {
                    case HITLER:
                        //Name and type of player   
                        hitler = String.valueOf(p2.getType());
                        hitlerPlayer = String.valueOf(p2.getName());
                        number5 = p2.getPhoneNumber();
                        break;

                    case FASCIST:
                        fasicst = String.valueOf(p2.getType());
                        fasicstPlayer = String.valueOf(p2.getName());
                        number4 = p2.getPhoneNumber();

                        facistPlayersList.add(fasicstPlayer);
                        facistPlayersPhoneList.add(number4);

                        break;

                    case LIBERAL:
                        number3 = p2.getPhoneNumber();
                        liberal = String.valueOf(p2.getType());
                        liberalPlayer = String.valueOf(p2.getName());

                        //adding all liberals to list
                        liberalPlayersPhoneList.add(number3);
                        liberalPlayersList.add(liberalPlayer);
                        break;
                }
            }
            fasicstPlayer = facistPlayersList.get(0);
            fasicstPlayer2 = facistPlayersList.get(1);
            fasicstPlayer3 = facistPlayersList.get(2);

            number8 = facistPlayersPhoneList.get(0);
            number9 = facistPlayersPhoneList.get(1);
            number11 = facistPlayersPhoneList.get(2);

            liberalPlayer1 = liberalPlayersList.get(0);
            liberalPlayer2 = liberalPlayersList.get(1);
            liberalPlayer3 = liberalPlayersList.get(2);
            liberalPlayer4 = liberalPlayersList.get(3);
            liberalPlayer5 = liberalPlayersList.get(4);

            number1 = liberalPlayersPhoneList.get(0);
            number2 = liberalPlayersPhoneList.get(1);
            number0 = liberalPlayersPhoneList.get(2);
            number6 = liberalPlayersPhoneList.get(3);
            number10 = liberalPlayersPhoneList.get(4);

            MessageSevenPlayers();
            TimeUnit.SECONDS.sleep(3);

            sendMessage("13069861849", number10, "Hi " + liberalPlayer5 + " You are a " + liberal);
            TimeUnit.SECONDS.sleep(3);
            sendMessage("13069861849", number11, "Hi " + fasicstPlayer3 + " You are a " + fasicst
                    + " Other Fasicsts Are: " + fasicstPlayer2 + " And " + fasicstPlayer3 + ", Hitler Is: " + hitlerPlayer);

        }

        if (PlayerCount == 10) {
            //For 9 players -->>
            FivePlayerNameInput(input);
            System.out.println("Enter 6th player Name");
            name6 = input.next();
            System.out.println("Enter 6th player Phone Number");
            number0 = input.next();
            System.out.println("Enter 7th player Name");
            name7 = input.next();
            System.out.println("Enter 7th player Phone Number");
            number7 = input.next();
            System.out.println("Enter 8th player Name");
            name8 = input.next();
            System.out.println("Enter 8th player Phone Number");
            number8 = input.next();
            System.out.println("Enter 9th player Name");
            name9 = input.next();
            System.out.println("Enter 9th player Phone Number");
            number9 = input.next();
            System.out.println("Enter 10th player Phone Number");

            name10 = input.next();
            System.out.println("Enter 9th player Phone Number");
            number10 = input.next();

            //List that stores player objects
            //Setting randomly type to players..
            LinkedList<Type> shuffleTypeList4 = new LinkedList<Type>(Arrays.asList(Type.FASCIST, Type.LIBERAL,
                    Type.LIBERAL, Type.LIBERAL, Type.HITLER, Type.LIBERAL, Type.FASCIST, Type.LIBERAL, Type.FASCIST, Type.FASCIST, Type.LIBERAL));
            Collections.shuffle(shuffleTypeList4);

            //LinkedList to store player numbers for five players
            LinkedList<String> shuffleNumberList4 = new LinkedList(Arrays.asList(number1, number2, number3, number4,
                    number5, number0, number7, number8, number9, number10));

            List<Player> players3 = Arrays.asList(
                    new Player(name1, Type.HITLER, number1),
                    new Player(name2, Type.FASCIST, number2),
                    new Player(name3, Type.LIBERAL, number3),
                    new Player(name4, Type.LIBERAL, number4),
                    new Player(name5, Type.LIBERAL, number5),
                    new Player(name6, Type.FASCIST, number0),
                    new Player(name7, Type.LIBERAL, number7),
                    new Player(name8, Type.FASCIST, number8),
                    new Player(name9, Type.LIBERAL, number9),
                    new Player(name10, Type.LIBERAL, number10));

            for (Player p2 : players3) {
                p2.setType(shuffleTypeList4.pop());
                p2.setPhoneNumber(shuffleNumberList4.pop());

                //Getting player name accroding to their card type.'
                switch (p2.getType()) {
                    case HITLER:
                        //Name and type of player   
                        hitler = String.valueOf(p2.getType());
                        hitlerPlayer = String.valueOf(p2.getName());
                        number5 = p2.getPhoneNumber();
                        break;

                    case FASCIST:
                        fasicst = String.valueOf(p2.getType());
                        fasicstPlayer = String.valueOf(p2.getName());
                        number4 = p2.getPhoneNumber();

                        facistPlayersList.add(fasicstPlayer);
                        facistPlayersPhoneList.add(number4);

                        break;

                    case LIBERAL:
                        number3 = p2.getPhoneNumber();
                        liberal = String.valueOf(p2.getType());
                        liberalPlayer = String.valueOf(p2.getName());

                        //adding all liberals to list
                        liberalPlayersPhoneList.add(number3);
                        liberalPlayersList.add(liberalPlayer);
                        break;
                }
            }
            fasicstPlayer = facistPlayersList.get(0);
            fasicstPlayer2 = facistPlayersList.get(1);
            fasicstPlayer3 = facistPlayersList.get(2);

            number8 = facistPlayersPhoneList.get(0);
            number9 = facistPlayersPhoneList.get(1);
            number11 = facistPlayersPhoneList.get(2);

            liberalPlayer1 = liberalPlayersList.get(0);
            liberalPlayer2 = liberalPlayersList.get(1);
            liberalPlayer3 = liberalPlayersList.get(2);
            liberalPlayer4 = liberalPlayersList.get(3);
            liberalPlayer5 = liberalPlayersList.get(4);
            liberalPlayer6 = liberalPlayersList.get(5);

            number1 = liberalPlayersPhoneList.get(0);
            number2 = liberalPlayersPhoneList.get(1);
            number0 = liberalPlayersPhoneList.get(2);
            number6 = liberalPlayersPhoneList.get(3);
            number10 = liberalPlayersPhoneList.get(4);
            number11 = liberalPlayersPhoneList.get(4);

            MessageSevenPlayers();
            TimeUnit.SECONDS.sleep(3);

            sendMessage("13069861849", number10, "Hi " + liberalPlayer5 + " You are a " + liberal);
            sendMessage("13069861849", number12, "Hi " + liberalPlayer6 + " You are a " + liberal);

            TimeUnit.SECONDS.sleep(3);
            sendMessage("13069861849", number11, "Hi " + fasicstPlayer3 + " You are a " + fasicst
                    + " Other Fasicsts Are: " + fasicstPlayer2 + " And " + fasicstPlayer3 + ", Hitler Is: " + hitlerPlayer);

        }
    }

    /**
     *
     * @throws NexmoClientException
     * @throws InterruptedException
     * @throws IOException
     */
    public static void MessageSevenPlayers() throws NexmoClientException, InterruptedException, IOException {
        //Sending Text's Now to liberals
        sendMessage("13069861849", number1, "Hi " + liberalPlayer1 + " You are a " + liberal);

        //Pausing the code for 3 seconds, coz API is not free and results in THROTTLED error message if no dealay..
        TimeUnit.SECONDS.sleep(3);

        sendMessage("13069861849", number2, "Hi " + liberalPlayer2 + " You are a " + liberal);
        TimeUnit.SECONDS.sleep(3);

        sendMessage("13069861849", number0, "Hi " + liberalPlayer3 + " You are a " + liberal);
        TimeUnit.SECONDS.sleep(3);

        sendMessage("13069861849", number6, "Hi " + liberalPlayer4 + " You are a " + liberal);

        //Sending Text's Now to Hitler
        TimeUnit.SECONDS.sleep(3);
        sendMessage("13069861849", number5, "Hi " + hitlerPlayer + " You are a " + hitler
                + " Faciscts Are : " + fasicstPlayer + " And " + fasicstPlayer2);

        //Sending Text's Now to Facisct
        TimeUnit.SECONDS.sleep(3);
        sendMessage("13069861849", number8, "Hi " + fasicstPlayer + " You are a " + fasicst
                + " Hitler IS  " + hitlerPlayer + "Other Fasicst Is: " + fasicstPlayer2);

        //Sending Text's Now to Facisct
        TimeUnit.SECONDS.sleep(3);
        sendMessage("13069861849", number9, "Hi " + fasicstPlayer2 + " You are a " + fasicst
                + " Hitler IS  " + hitlerPlayer + "Other Fasicst Is: " + fasicstPlayer);
    }

    /**
     *
     * @param input
     */
    public static void FivePlayerNameInput(Scanner input) {
        System.out.println("Enter Player's Name's And Their Phone Numbers..");
        System.out.println();

        System.out.println("Enter 1st player Name");
        name1 = input.next();
        System.out.println("Enter 1st player Phone Number");
        number1 = input.next();

        System.out.println("Enter 2nd player Name");
        name2 = input.next();
        System.out.println("Enter 2nd player Phone Number");
        number2 = input.next();

        System.out.println("Enter 3rd player Name");
        name3 = input.next();
        System.out.println("Enter 3rd player Phone Number");
        number3 = input.next();

        System.out.println("Enter 4th player Name");
        name4 = input.next();
        System.out.println("Enter 4tg player Phone Number");
        number4 = input.next();

        System.out.println("Enter 5th player Name");
        name5 = input.next();
        System.out.println("Enter 5th player Phone Number");
        number5 = input.next();
    }

    /**
     * This method sends text message upto five players, telling their roles in
     * the games..
     *
     * @throws InterruptedException
     * @throws NexmoClientException
     * @throws IOException
     */
    public static void sendMessageFivePlayers() throws InterruptedException, NexmoClientException, IOException {

//Sending Text's Now to liberals
        sendMessage("13069861849", number1, "Hi " + liberalPlayer1 + " You are a " + liberal);

        //Pausing the code for 3 seconds, coz API is not free and results in THROTTLED error message if no dealay..
        TimeUnit.SECONDS.sleep(3);

        sendMessage("13069861849", number2, "Hi " + liberalPlayer2 + " You are a " + liberal);
        TimeUnit.SECONDS.sleep(3);

        sendMessage("13069861849", number0, "Hi " + liberalPlayer3 + " You are a " + liberal);

        //Sending Text's Now to Hitler
        TimeUnit.SECONDS.sleep(3);
        sendMessage("13069861849", number5, "Hi " + hitlerPlayer + " You are a " + hitler
                + " Facisct IS  " + fasicstPlayer);

        //Sending Text's Now to Facisct
        TimeUnit.SECONDS.sleep(3);
        sendMessage("13069861849", number4, "Hi " + fasicstPlayer + " You are a " + fasicst
                + " Hitler IS  " + hitlerPlayer);
    }

    /**
     ** This method sends text message to 7 players, telling their roles in the
     * games..
     *
     * @param fromPhone
     * @param toPhone
     * @param text
     * @throws IOException
     * @throws NexmoClientException
     */
    public static void sendMessage(String fromPhone, String toPhone, String text) throws IOException, NexmoClientException {

        //Calling client using api ket and api secret key
        NexmoClient client = new NexmoClient.Builder()
                .apiKey("965625a8")
                .apiSecret("gSquTMNQMo7FOupc")
                .build();

        //Adding parameter to text message
        TextMessage message = new TextMessage(fromPhone, toPhone, text);

        //sending sms using response method
        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
            System.out.println(responseMessage);
        }

    }

}
