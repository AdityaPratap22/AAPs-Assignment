import java.util.*;

public class ActivitySelection {

    public static int activitySelection(List<Integer> start, List<Integer> end) {
        List<int[]> activities = new ArrayList<>();
        for (int i = 0; i < start.size(); i++) {
            activities.add(new int[]{start.get(i), end.get(i)});
        }
        activities.sort(Comparator.comparingInt(a -> a[1]));

        int lastEnd = activities.get(0)[1];
        int count = 1;
        for (int i = 1; i < activities.size(); i++) {
            if (activities.get(i)[0] >= lastEnd) {
                count++;
                lastEnd = activities.get(i)[1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> start = Arrays.asList(1, 3, 0, 5, 8, 5);
        List<Integer> end = Arrays.asList(2, 4, 6, 7, 9, 9);

        System.out.println(activitySelection(start, end)); 
    }
}
