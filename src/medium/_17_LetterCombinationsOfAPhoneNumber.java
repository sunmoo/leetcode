package medium;
import java.util.*;

public class _17_LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) return res;

        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList(new Character[]{'a', 'b', 'c'}));
        map.put('3', Arrays.asList(new Character[]{'d', 'e', 'f'}));
        map.put('4', Arrays.asList(new Character[]{'g', 'h', 'i'}));
        map.put('5', Arrays.asList(new Character[]{'j', 'k', 'l'}));
        map.put('6', Arrays.asList(new Character[]{'m', 'n', 'o'}));
        map.put('7', Arrays.asList(new Character[]{'p', 'q', 'r', 's'}));
        map.put('8', Arrays.asList(new Character[]{'t', 'u', 'v'}));
        map.put('9', Arrays.asList(new Character[]{'w', 'x', 'y','z'}));

        helper(map, res, new StringBuilder(), digits, 0);

        return res;
    }

    private void helper(Map<Character, List<Character>> map, List<String> res, StringBuilder sb, String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        Character curr = digits.charAt(index);
        List<Character> list = map.get(curr);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            helper(map, res, sb, digits, index + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        _17_LetterCombinationsOfAPhoneNumber r = new _17_LetterCombinationsOfAPhoneNumber();
        r.letterCombinations("24");
    }

}
