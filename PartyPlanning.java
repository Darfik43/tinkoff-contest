import java.util.*;



public class PartyPlanning {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int g = scanner.nextInt();

        List<Dragon> dragons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int interest = scanner.nextInt();
            int voracity = scanner.nextInt();
            dragons.add(new Dragon(interest, voracity));
        }

        List<List<Integer>> friends = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            friends.get(u).add(v);
            friends.get(v).add(u);
        }

        Set<Integer> invitedDragons = new HashSet<>();
        PriorityQueue<Dragon> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (!invitedDragons.contains(i)) {
                Set<Integer> currentParty = new HashSet<>();
                int totalVoracity = 0;

                priorityQueue.add(dragons.get(i));
                currentParty.add(i);
                totalVoracity += dragons.get(i).voracity;

                for (int friend : friends.get(i)) {
                    if (!currentParty.contains(friend)) {
                        priorityQueue.add(dragons.get(friend));
                        currentParty.add(friend);
                        totalVoracity += dragons.get(friend).voracity;
                    }
                }

                while (!priorityQueue.isEmpty() && totalVoracity > g) {
                    Dragon leastInteresting = priorityQueue.poll();
                    totalVoracity -= leastInteresting.voracity;
                    currentParty.remove(dragons.indexOf(leastInteresting));
                }

                invitedDragons.addAll(currentParty);
            }
        }

        int totalInterest = invitedDragons.stream().mapToInt(i -> dragons.get(i).interest).sum();
        System.out.println(totalInterest);
    }
}

class Dragon implements Comparable<Dragon> {
    int interest;
    int voracity;

    public Dragon(int interest, int voracity) {
        this.interest = interest;
        this.voracity = voracity;
    }

    @Override
    public int compareTo(Dragon other) {
        return Integer.compare(other.interest, this.interest);
    }
}