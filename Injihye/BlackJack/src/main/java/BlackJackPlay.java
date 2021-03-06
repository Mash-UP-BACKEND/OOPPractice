
import java.util.Scanner;

public class BlackJackPlay
{

    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);

        BlackJack player = new BlackJack();
        BlackJack dealer = new BlackJack();

        System.out.println("player의 카드");

        //첫번째 카드
        player.generatorRandom();
        player.cardMarked();
        player.setPoint();
        player.display();

        //두번째 카드
        player.generatorRandom();
        player.cardMarked();
        player.setPoint();
        player.display();

        System.out.println("player의 점수는 " + player.getPoint());
        System.out.println("카드 한 장 더?(yes/no):");
        String userType = sc.nextLine();
        userType.toLowerCase();

        while(userType.equals("yes") && (player.getPoint() <= 21)){
            //카드 한 장 더
            player.generatorRandom();
            player.cardMarked();
            player.setPoint();
            player.display();

            System.out.println("player의 점수는 " + player.getPoint());
            System.out.println("카드 한 장 더? (yes/no):");
            userType = sc.nextLine();
        }

        if(player.getPoint() > 21) {
            System.out.println("21점이 넘어 게임 끝");
        }
        else {
            System.out.println("player의 점수는 : " + player.getPoint());

            System.out.println("딜러가 가진 카드 ");
            //첫번째 카드
            dealer.generatorRandom();
            dealer.cardMarked();
            dealer.setPoint();
            dealer.display();
            //두번째 카드
            dealer.generatorRandom();
            dealer.cardMarked();
            dealer.setPoint();
            dealer.display();

            System.out.println("Dealer의 점수는 : " + dealer.getPoint());

            while(dealer.getPoint() <=17) {
                //dealer의 카드가 17이하이면 카드를  더 받는다
                dealer.generatorRandom();
                dealer.cardMarked();
                dealer.setPoint();
                System.out.println("dealer가 가지고 있는 카드는 ");
                dealer.display();
                System.out.println("dealer의 점수는 " + dealer.getPoint());
            }

            if(dealer.getPoint() > 21)
                System.out.println("dealer가 21점이 넘어 게임 끝.\n player의 승리!");

        }


        if ((dealer.getPoint())<=21 && (player.getPoint()<= 21))
        { if (player.getPoint() > dealer.getPoint())
            System.out.println("player의 승리");
        else if (player.getPoint() < dealer.getPoint())
            System.out.println("dealer의 승리");
        else System.out.println("무승부");

        }
    }
}
