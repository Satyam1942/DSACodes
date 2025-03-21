class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> recipeSet = new HashSet<>();
        HashSet<String> supplySet = new HashSet<>();
        HashMap<String, List<String>> adjList = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        int numberOfRecipes = recipes.length;
        int numberOfSupplies = supplies.length;

        for (int i = 0; i < numberOfSupplies; i++) {
            supplySet.add(supplies[i]);
        }

        for (int i = 0; i < numberOfRecipes; i++) {
            String recipeName = recipes[i];
            int numberOfIngredients = ingredients.get(i).size();
            recipeSet.add(recipeName);
            if (!indegree.containsKey(recipeName)) {
                indegree.put(recipeName, 0);
            }
            if (!adjList.containsKey(recipeName)) {
                adjList.put(recipeName, new ArrayList<>());
            }
            for (int j = 0; j < numberOfIngredients; j++) {
                String ingredient = ingredients.get(i).get(j);
                if (!indegree.containsKey(ingredient)) {
                    indegree.put(ingredient, 0);
                }
                if (!adjList.containsKey(ingredient)) {
                    adjList.put(ingredient, new ArrayList<>());
                }
                if (!supplySet.contains(recipeName)) {
                    adjList.get(ingredient).add(recipeName);
                    int curIndegree = indegree.get(recipeName);
                    indegree.put(recipeName, curIndegree + 1);
                }
            }
        }

        Queue<String> q = new LinkedList<>();
        List<String> recipesPrepared = new ArrayList<>();
        for (Map.Entry<String, Integer> i : indegree.entrySet()) {
            String node = i.getKey();
            int indegreeVal = i.getValue();
            if (supplySet.contains(node) && indegreeVal == 0) {
                q.add(node);
            }
        }
       
        while (!q.isEmpty()) {
            String recipe = q.poll();
            
            if (recipeSet.contains(recipe)) {
                recipesPrepared.add(recipe);
            }
            List<String> adjNodeList = adjList.get(recipe);
            for (int i = 0; i < adjNodeList.size(); i++) {
                String adjNode = adjNodeList.get(i);
                int curIndegree = indegree.get(adjNode);
                if (curIndegree == 1) {
                    indegree.remove(adjNode);
                    q.add(adjNode);
                } else {
                    indegree.put(adjNode, curIndegree - 1);
                }
            }
        }
        return recipesPrepared;
    }
}