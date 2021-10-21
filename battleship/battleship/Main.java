package battleship;
import java.util.*;

public class Main {
    private static int bombX = 0; //入力された爆弾の位置x
    private static int bombY = 0; //入力された爆弾の位置y
    public static void main(String[] args) {
        //タイトルの表示
        dispTitle();

        //船の数分ループして位置を決める
        Ship[] ships = new Ship[3];
        for(int i=0; i<3; i++){
            //インスタンス作成
            ships[i] = new Ship();

            //位置を決める
            do{
                ships[i].determinPos();
            }while(isDuplicateShipPos(ships[i], ships));
        }

        Scanner scanner = new Scanner(System.in);

        while(isShipAlive(ships)){
            //爆弾の位置を決めます
            inputBombPos(scanner);
            //船3つに対してそれぞれ当たり判定を行う
            for(int i=0; i<3; i++){
                int result = ships[i].judgeForBomb(bombX, bombY);
                //判定を受けての処理
                actionForJudge(result, ships[i], ships);
            }
        }
        scanner.close();
    }

    //タイトルを表示する
    public static void dispTitle(){
        System.out.println("戦艦ゲーム");
    }

    //爆弾の位置を決めます
    public static void inputBombPos(Scanner scanner){
        System.out.println("爆弾のX位置を入力してください！");
        bombX = scanner.nextInt();
        System.out.println("爆弾のY位置を入力してください！");
        bombY = scanner.nextInt();
    }

    //判定の結果を受けて必要な処理を行う
    //引数：result(爆弾判定結果)、myShip(対象の船)、ships(船の配列)
    public static void actionForJudge(int result, Ship myShip, Ship[] ships){
        if( result == Ship.HIT){
            //位置を決める
            do{
                myShip.determinPos();
            }while(isDuplicateShipPos(myShip, ships));
        }
    }

    //被りチェックメソッド
    //戻り値: true:被りがある, false:被りがない
    public static boolean isDuplicateShipPos(Ship myShip, Ship[] otherShips){
        boolean isSamePos = false;
        //チェックする船の数分ループする
        for(int i=0; i<otherShips.length; i++){
            //自分のインスタンスと同じか？
            if(myShip != otherShips[i] && otherShips[i] != null){
                //位置情報を比較する
                if(
                    myShip.getx() == otherShips[i].getx() &&
                    myShip.gety() == otherShips[i].gety()
                ){
                    //位置が被っている
                    isSamePos = true;
                    break;  //被っているものがあればループを抜ける
                }
            }
        }
        return isSamePos;
    }

    //船がまだ残っているかのチェック
    //引数：ships(船の配列)
    //戻り値：true(船が生き残っている), false(船は全滅している)
    public static boolean isShipAlive(Ship[] ships){
        boolean isAlive = false;

        for(Ship ship : ships){
            //船が沈んでいるか？
            if(ship.isSink() == false){
                //生き残っている船がいる
                isAlive = true;
                break;
            }
        }
        return isAlive;
    }
}
