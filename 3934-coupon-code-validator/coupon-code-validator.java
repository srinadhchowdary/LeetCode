class Pair {
    String code;
    String businessLine;

    Pair(String code, String businessLine) {
        this.code = code;
        this.businessLine = businessLine;
    }
}

class Solution {

    public boolean isValid(String code) {
        if (code == null || code.isEmpty()) return false;

        for (char ch : code.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && ch != '_') {
                return false;
            }
        }
        return true;
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        int n = code.length;

        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isValid(code[i]) &&
                businessLine[i] != null &&
                order.containsKey(businessLine[i]) &&
                isActive[i]) {

                list.add(new Pair(code[i], businessLine[i]));
            }
        }

        // ✅ Sorting (allows duplicates)
        Collections.sort(list, (a, b) -> {
            int cmp = Integer.compare(order.get(a.businessLine), order.get(b.businessLine));
            if (cmp == 0) {
                return a.code.compareTo(b.code);
            }
            return cmp;
        });

        List<String> res = new ArrayList<>();
        for (Pair p : list) {
            res.add(p.code);
        }

        return res;
    }
}