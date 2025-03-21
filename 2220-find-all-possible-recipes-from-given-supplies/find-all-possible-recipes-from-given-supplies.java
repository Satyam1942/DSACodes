class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> recipeSet = new HashSet<>();
        HashSet<String> supplySet = new HashSet<>();
        HashMap<String, List<String>> adjList = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        int numberOfRecipes = recipes.length;
        int numberOfSupplies = supplies.length;

        for (int i = 0; i < numberOfSupplies; i++) {
            String supplyName = supplies[i];
            supplySet.add(supplyName);
            indegree.put(supplyName, 0);
            adjList.put(supplyName, new ArrayList<>());
        }

        for (int i = 0; i < numberOfRecipes; i++) {
            String recipeName = recipes[i];
            recipeSet.add(recipeName);
            indegree.put(recipeName, 0);
            adjList.put(recipeName, new ArrayList<>());
        }

        for (int i = 0; i < numberOfRecipes; i++) {
            String recipeName = recipes[i];
            int numberOfIngredients = ingredients.get(i).size();
            if (!supplySet.contains(recipeName)) {
                int curIndegree = indegree.get(recipeName);
                indegree.put(recipeName, curIndegree + numberOfIngredients);
                for (int j = 0; j < numberOfIngredients; j++) {
                    String ingredient = ingredients.get(i).get(j);
                    if(!adjList.containsKey(ingredient)) {
                        continue;
                    }
                    adjList.get(ingredient).add(recipeName);
                }
            }
        }

        Queue<String> q = new LinkedList<>();
        List<String> recipesPrepared = new ArrayList<>();
        
        for (Map.Entry<String, Integer> i : indegree.entrySet()) {
            String node = i.getKey();
            int indegreeVal = i.getValue();
            if (indegreeVal == 0) {
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