import java.util.*;

public class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        List<Integer> resultList = new ArrayList<>(60);
        for (int i = 0; i < 60; i++) {
            resultList.add(1);
        }
        int skillsSize = req_skills.length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < skillsSize; i++) {
            sb.append(1);
        }
        String target = sb.toString();
        List<String> peopleBitMasked = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            List<String> person = people.get(i);
            sb.setLength(0);
            for (int j = 0; j < req_skills.length; j++) {
                if(person.contains(req_skills[j])){
                    sb.append(1);
                }else sb.append(0);
            }
            peopleBitMasked.add(sb.toString());
        }

        sb.setLength(0);
        for (int i = 0; i < skillsSize; i++) {
            sb.append(0);
        }
        String key = sb.toString();
        Set<String> memo = new HashSet<>();
        dfs(target, peopleBitMasked, 0, new ArrayList<>(), resultList, key);
        int size = resultList.size();
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }

    private void dfs(String target, List<String> peopleBitMasked, int index, List<Integer> currentList, List<Integer> resultList, String key){

        if(key.equals(target)){
            if(currentList.size() < resultList.size()){
                resultList.clear();
                resultList.addAll(currentList);
            }
            return;
        }
        if(index == peopleBitMasked.size()){
            return;
        }

        String temp = key;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < peopleBitMasked.get(index).length(); i++) {
            if(peopleBitMasked.get(index).charAt(i) == '1' || key.charAt(i) == '1'){
                sb.append(1);
            }else {
                sb.append(0);
            }
        }
        key = sb.toString();
        currentList.add(index);
        dfs(target, peopleBitMasked, index + 1, currentList, resultList, key);
        key = temp;
        currentList.remove(currentList.size() - 1);

        dfs(target, peopleBitMasked, index + 1, currentList, resultList, key);

    }
}
