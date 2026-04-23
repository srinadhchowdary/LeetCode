import java.util.*;

class Pair {

    int position;
    List<Integer> l;
    int minSpeed;

    public Pair(int position, List<Integer> l, int minSpeed) {

        this.position = position;
        this.l = new ArrayList<>(l);
        this.minSpeed = minSpeed;
    }
}

class Solution {

    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // position -> Pair
        Map<Integer, Pair> mp = new HashMap<>();

        // store all cars in map
        for (int i = 0; i < n; i++) {

            if (mp.containsKey(position[i])) {

                Pair existing = mp.get(position[i]);

                existing.l.add(i);

                existing.minSpeed =
                        Math.min(existing.minSpeed, speed[i]);

            } else {

                List<Integer> l = new ArrayList<>();
                l.add(i);

                Pair p =
                        new Pair(position[i], l, speed[i]);

                mp.put(position[i], p);
            }
        }

        // sort positions descending
        List<Integer> positions = new ArrayList<>(mp.keySet());

        Collections.sort(positions, Collections.reverseOrder());

        int fleets = 0;

        double prevTime = -1;

        for (int pos : positions) {

            Pair p = mp.get(pos);

            // fleet speed = minimum speed
            double time =
                    (double)(target - p.position) / p.minSpeed;

            // new fleet
            if (time > prevTime) {

                fleets++;
                prevTime = time;
            }
        }

        return fleets;
    }
}