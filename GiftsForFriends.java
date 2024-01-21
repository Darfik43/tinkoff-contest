import java.util.*;

public class GiftsForFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Gift> gifts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int di = scanner.nextInt();
            int ci = scanner.nextInt();
            int si = scanner.nextInt();

            gifts.add(new Gift(di, ci, si));
        }

        Collections.sort(gifts, Comparator.comparingInt(g -> g.si));

        int currentDay = 0;

        for (Gift gift : gifts) {
            if (currentDay < gift.di) {
                currentDay = gift.di;
            }

            if (currentDay + gift.ci > gift.si) {
                System.out.println("NO");
                return;
            }

            currentDay += gift.ci;
        }

        System.out.println("YES");
    }

    static class Gift {
        int di;
        int ci;
        int si;

        public Gift(int di, int ci, int si) {
            this.di = di;
            this.ci = ci;
            this.si = si;
        }
    }
}
