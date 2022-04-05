public class TV {
    private String brand;
    private int inch;
    private int yee;

    public TV(String brand, int inch, int yee){
        this.brand = brand;
        this.inch = inch;
        this.yee = yee;
    }
    public TV(String brand, int inch){
        this.brand = brand;
        this.inch = inch;
        this.yee = 0;
    }

    public void show(){
        if(this.yee == 0){
            System.out.println("생산년도가 불분명한 "+this.brand+"에서 만든 "+inch+"인치 TV");
        }else{
            System.out.println(this.yee+"년도"+this.brand+"에서 만든"+inch+"인치 TV");
        }
    }
    public static void main(String[] args) {
        TV myTV = new TV("LG", 32, 2021);
        TV mySecondTV = new TV("Samaung", 27);
        myTV.show();
        mySecondTV.show();
    }
}
