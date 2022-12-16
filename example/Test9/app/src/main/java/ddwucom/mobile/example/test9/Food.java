package ddwucom.mobile.example.test9;

public class Food {
    String foodName;
    String nation;

    public Food(String foodName, String nation) {
        this.foodName = foodName;
        this.nation = nation;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String toString() {
        return foodName + "\t\t(" + nation + ")";
    }
}
