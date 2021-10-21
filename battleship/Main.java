import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;
        int y;
        int t = 1;

        //戦艦作成、配置
        Ship s1 = new Ship(1);
        Ship s2 = new Ship(2);
        Ship s3 = new Ship(3);

        //出力
        System.out.println("********************");
        System.out.println("戦艦ゲーム");
        System.out.println("********************");
        while(s1.hp!=0 || s2.hp!=0 || s3.hp!=0){
            System.out.println("-----"+"["+"ターン"+t+"]"+"-----");
            System.out.println("爆弾のx座標を入力してください(1-5)");
            x = sc.nextInt();
            System.out.println("爆弾のy座標を入力してください(1-5)");
            y = sc.nextInt();
            s1.check(x, y);
            s2.check(x, y);
            s3.check(x, y);
            t++;
        }
        System.out.println("終了");
        sc.close();

    }
}
