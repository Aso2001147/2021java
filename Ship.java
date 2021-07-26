import java.util.*;

public class Ship {
    Random r = new Random();

    //マップ作成、初期化
    public int[][] map = new int[7][7];
    public void setmap(){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                map[i][j] = 0;
            }
        }
    }

    //インスタンス変数
    public int x;
    public int y;
    public int n;
    public int hp = 3;

    //値設定
    public Ship(int n){
        this.x = r.nextInt(5)+1;
        this.y = r.nextInt(5)+1;
        this.n = n;
        map[this.x][this.y] = this.n;
    }

    //判定
    public void check(int x, int y){
        if(map[x][y]==this.n){
            this.hp--;
            if(this.hp!=0){
                System.out.println("戦艦"+this.n+"：生存、移動");
                this.move();
            }else{
                System.out.println("戦艦"+this.n+"：撃沈");
                this.move();
            }
        }else if(map[x+1][y]==this.n){
            System.out.println("戦艦"+this.n+"：波高し");
        }else if(map[x-1][y]==this.n){
            System.out.println("戦艦"+this.n+"：波高し");
        }else if(map[x][y+1]==this.n){
            System.out.println("戦艦"+this.n+"：波高し");
        }else if(map[x][y-1]==this.n){
            System.out.println("戦艦"+this.n+"：波高し");
        }else{
            System.out.println("戦艦"+this.n+"：はずれ");
        }
    }

    //移動
    public void move(){
        map[this.x][this.y] = 0;
        if(this.hp!=0){
            boolean b = true;
            while(b){
                this.x = r.nextInt(5)+1;
                this.y = r.nextInt(5)+1;
                if(map[this.x][this.y]==0){
                    map[this.x][this.y] = this.n;
                    b = false;
                }
            }
        }
    }

}
