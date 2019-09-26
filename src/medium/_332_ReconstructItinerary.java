package medium;
import java.util.*;

public class _332_ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();

        for(List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new ArrayList<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }


        dfs(ans, map, "JFK", tickets.size() + 1);
        return ans;
    }

    private boolean dfs(List<String> ans, Map<String, ArrayList<String>> map, String curr, int total) {
        ans.add(curr);
        if (ans.size() >= total) {
            return true;
        }
        if (!map.containsKey(curr) || map.get(curr).isEmpty()) {
            return false;
        }
        ArrayList<String> arrivals = map.get(curr);
        for (int i = 0; i < arrivals.size(); i++) {
            String arrival = map.get(curr).remove(i);
            if (dfs(ans, map, arrival, total)) {
                return true;
            }
            ans.remove(ans.size() - 1);
            arrivals.add(i, arrival);
        }
        return false;
    }

    public static void main(String[] args) {
        _332_ReconstructItinerary r = new _332_ReconstructItinerary();

        List<String> temp = Arrays.asList(new String[]{"JFK","KUL"});
        List<String> temp1 = Arrays.asList(new String[]{"JFK","NRT"});
        List<String> temp2 = Arrays.asList(new String[]{"NRT","JFK"});
        List<List<String>> list = new ArrayList<>();
        list.add(temp);
        list.add(temp1);
        list.add(temp2);

        r.findItinerary(list);
    }
}
