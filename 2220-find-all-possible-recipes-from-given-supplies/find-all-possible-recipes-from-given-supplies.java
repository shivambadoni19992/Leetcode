class Solution {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> suppliesList = new ArrayList<>(Arrays.asList(supplies));
        List<String> output = new ArrayList<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> adjacenyList = new HashMap<>();
        for (int i = 0; i < ingredients.size(); i++) {
            String recipe = recipes[i];
            int items = ingredients.get(i).size();
            inDegree.put(recipe, items);
            for (int j = 0; j < items; j++) {
                String key = ingredients.get(i).get(j);
                if (!adjacenyList.containsKey(key)) {
                    adjacenyList.put(key, new ArrayList<>());
                }
                adjacenyList.get(key).add(recipe);
            }
        }
        for (int i = 0; i < suppliesList.size(); i++) {
            String supply = suppliesList.get(i);
            if(adjacenyList.containsKey(supply)){
                List<String> recipe = adjacenyList.get(supply);
                for (int j = 0; j < recipe.size(); j++) {
                    String ele = recipe.get(j);
                    int inDeg = inDegree.get(ele) - 1;
                    inDegree.put(ele,inDeg);
                    if(inDeg == 0){
                        output.add(ele);
                        suppliesList.add(ele);
                    }
                }
            }
        }

        return output;
    }
}
