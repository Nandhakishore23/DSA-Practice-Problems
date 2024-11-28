import java.util.*;

class CourseSchedule{
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int processedCourses = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processedCourses++;
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return processedCourses == numCourses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of courses: ");
        int numCourses = sc.nextInt();
        System.out.print("Enter the number of prerequisite pairs: ");
        int n = sc.nextInt();
        int[][] prerequisites = new int[n][2];
        System.out.println("Enter the prerequisite pairs (e.g., for [1,0] input 1 0):");
        for (int i = 0; i < n; i++) {
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }
        boolean result = canFinish(numCourses, prerequisites);
        if (result) {
            System.out.println("Yes, you can finish all courses.");
        } else {
            System.out.println("No, it's not possible to finish all courses.");
        }
        sc.close();
    }
}
