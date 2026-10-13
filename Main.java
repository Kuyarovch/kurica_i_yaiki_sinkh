public class Main{
    public static String pobeda="";
    public static void main(String[] args){
yaiko yaikin = new yaiko("яйцо");
kurishe kurishe = new kurishe("курица");
yaikin.start();
kurishe.start();
try{
    yaikin.join();
    kurishe.join();
    if(pobeda.equals(kurishe.getName())){
        System.out.println("Спор окончен. Победила: "+pobeda);
    }
    else System.out.println("Спор окончен. Победило "+pobeda);
} catch (InterruptedException e) {
    System.out.println("вас прервали, сударь");
}
    }
}
class yaiko extends Thread{
    public yaiko(String yaiko){
        super(yaiko);
    }
    public void run(){

        for (int i = 0; i<10;i++){
            synchronized (Main.class) {
                System.out.println(getName());
                Main.pobeda = getName();
            }
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
class kurishe extends Thread{
    public kurishe(String kurishe){
        super(kurishe);
    }
    public void run(){
        for(int i = 0;i<10;i++){
            synchronized (Main.class) {
                System.out.println(getName());
                Main.pobeda = getName();
            }
            try{
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}