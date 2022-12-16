package ddwucom.mobile.week09.adapterclicktest;

import java.util.ArrayList;

public class FoodManager {
    ArrayList<String> foodList;

    public FoodManager(){
        foodList = new ArrayList<String>();

        foodList.add("떡볶이");
        foodList.add("쌀국수");
        foodList.add("치킨");
        foodList.add("닭발");
        foodList.add("계란찜");
    }

    public ArrayList<String> getFoodList(){
        return foodList;
    }

    public String getFood(int idx){
        return foodList.get(idx);
    }

    public void addFood(String newFood){
        foodList.add(newFood);
    }

    public void removeFood(int idx){
        foodList.remove(idx);
    }
 }
