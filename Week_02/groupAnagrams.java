class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList();
        }
        Map<String,List<String>> resDic = new HashMap<String,List<String>>();
        for(int i = 0; i < strs.length;i++){
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String key = String.valueOf(s);
            if(resDic.get(key) == null){
                resDic.put(key,new ArrayList<String>());
            }
            resDic.get(key).add(strs[i]);
        }
        List<List<String>> res = new ArrayList();
        for(String key : resDic.keySet()){
            res.add(resDic.get(key));
        }
        return res;
    }
}