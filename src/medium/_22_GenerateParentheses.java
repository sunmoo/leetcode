package medium;
import java.util.*;

public class _22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        helper(sb, res, 0, 0, n);
        return res;
    }

    private void helper(StringBuilder sb, List<String> res, int open, int close, int n) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            helper(sb, res, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            helper(sb, res, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}
