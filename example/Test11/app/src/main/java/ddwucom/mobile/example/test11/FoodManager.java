package ddwucom.mobile.example.test11;

import java.util.ArrayList;

public class FoodManager {
    private ArrayList<Food> foodList;

    public FoodManager(){
        foodList = new ArrayList<Food>();

        foodList.add(new Food("김치찌개", "한국"));
        foodList.add(new Food("된장찌개", "한국"));
        foodList.add(new Food("훠궈", "중국"));
        foodList.add(new Food("딤섬", "중국"));
        foodList.add(new Food("초밥", "일본"));
        foodList.add(new Food("오코노미야키", "일본"));
    }

    public void add(Food food){
        foodList.add(food);
    }

    public void remove(int idx){
        foodList.remove(idx);
    }
    public ArrayList<Food> getList(){
        return foodList;
    }
}
