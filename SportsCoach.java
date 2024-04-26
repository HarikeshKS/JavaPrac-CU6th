public class SportsCoach {

    public static int solution(String commands) {
        int students = commands.length();
        int[] directions = new int[students];  // 1 represents facing right, -1 represents facing left

        int countSameDirection = 0;

        for (char command : commands.toCharArray()) {
            if (command == 'L') {
                for (int i = 0; i < students; i++) {
                    directions[i] *= -1;  // Reverse the direction for all students
                }
            } else if (command == 'R') {
                // No change in direction for all students
            } else if (command == 'A') {
                int temp = directions[0];
                directions[0] = directions[1] * -1;
                directions[1] = temp * -1;

                for (int i = 2; i < students; i++) {
                    directions[i] *= -1;  // Invert direction for other students
                }
            }

            if (allSameDirection(directions, 1) || allSameDirection(directions, -1)) {
                countSameDirection++;
            }
        }

        return countSameDirection;
    }

    private static boolean allSameDirection(int[] directions, int direction) {
        for (int d : directions) {
            if (d != direction) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String commands = "LLARL";
        int result = solution(commands);
        System.out.println("Number of commands after which students face the same direction: " + result);
    }
}
