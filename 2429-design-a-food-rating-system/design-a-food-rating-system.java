class Pair
{
    String cuisine;
    int rating;
    Pair(String cuisine, int rating)
    {
        this.cuisine = cuisine ;
        this.rating =rating;
    }
}

class FoodRatings {
    HashMap<String,TreeMap<Integer,TreeSet<String>>> menu = new HashMap<>();
    HashMap<String,Pair> rating = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int length = ratings.length;
        for(int i=0;i<length;i++)
        {
            if(!menu.containsKey(cuisines[i])) menu.put(cuisines[i],new TreeMap<>());
           if(!menu.get(cuisines[i]).containsKey(ratings[i]))
            menu.get(cuisines[i]).put(ratings[i],new TreeSet<>());
            menu.get(cuisines[i]).get(ratings[i]).add(foods[i]);
            rating.put(foods[i],new Pair(cuisines[i],ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        int oldRating = rating.get(food).rating;
        String curCuisine = rating.get(food).cuisine;
        rating.put(food,new Pair(curCuisine,newRating));

        if(menu.get(curCuisine).get(oldRating).size()==1) menu.get(curCuisine).remove(oldRating);
        else menu.get(curCuisine).get(oldRating).remove(food);

        if(!menu.get(curCuisine).containsKey(newRating)) 
        menu.get(curCuisine).put(newRating,new TreeSet<String>());

        menu.get(curCuisine).get(newRating).add(food);

    }
    
    public String highestRated(String cuisine) {
        int key = menu.get(cuisine).lastKey();
        return menu.get(cuisine).get(key).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */