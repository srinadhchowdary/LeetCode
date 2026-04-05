class Triple {
    int position;
    int health;
    char direction;
    int index; 

    Triple(int position, int health, char direction, int index) {
        this.position = position;
        this.health = health;
        this.direction = direction;
        this.index = index;
    }
}

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        List<List<Triple>> l = new ArrayList<>();
        int no_of_robots = positions.length;

        // initialize list
        for (int i = 0; i < no_of_robots; i++) {
            l.add(new ArrayList<>());
        }

        // add robots
        for (int i = 0; i < no_of_robots; i++) {
            l.get(i).add(new Triple(positions[i], healths[i], directions.charAt(i), i));
        }

        // sort based on position
        Collections.sort(l, (a, b) -> a.get(0).position - b.get(0).position);

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < l.size(); i++) {

            Triple curr = l.get(i).get(0);

            if (stk.isEmpty()) {
                stk.push(i);
                continue;
            }

            while (!stk.isEmpty()) {

                int top = stk.peek();
                Triple t = l.get(top).get(0);

                // collision condition
                if (t.direction == 'R' && curr.direction == 'L') {

                    if (t.health == curr.health) {
                        stk.pop();
                        curr.health = 0; 
                        break;
                    }
                    else if (t.health > curr.health) {
                        t.health--;
                        curr.health = 0;
                        break;
                    }
                    else {
                        curr.health--;
                        stk.pop();
                    }
                }
                else {
                    if (curr.health > 0) stk.push(i);
                    break;
                }
            }

            if (curr.health > 0 && stk.isEmpty()) {
                stk.push(i);
            }
        }

        // store result in original order
        int[] res = new int[no_of_robots];

        for (Integer it : stk) {
            Triple t = l.get(it).get(0);
            res[t.index] = t.health;
        }

        List<Integer> ans = new ArrayList<>();

        for (int val : res) {
            if (val > 0) ans.add(val);
        }

        return ans;
    }
}