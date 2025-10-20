public class main {

    public static void main(String[] args) throws InterruptedException {

        TVStation tvStation = new TVStation();
        WeatherStation weatherStation = new WeatherStation(tvStation);
        User tom = new User("tom", (info) ->{
            if(info.equals("晴天")){
                System.out.println("晴天出去玩了");
            }{
                System.out.println("tom在家呆着");
            }
        });

        User jerry = new User("jerry",(info)->{
            if(info.equals("冰雹")){
                System.out.println("jerry出门上班要小心");
            }else{
                System.out.println("jerry出门记得带雨伞");
            }
        });

        tvStation.subscribe(tom);
        tvStation.subscribe(jerry);

        weatherStation.start();
    }
}
