public class w11problem1 {
    public static void main(String[] args) {
        int[][] roads = {
            {0,3,2,0},
            {3,0,0,5},
            {2,0,0,9},
            {0,5,9,0}
        };
        City test = new City(roads);

        
    }
}
class City {
    int[][] roads = {};
    public City(int[][] roads) {
        this.roads = roads;
    }

}