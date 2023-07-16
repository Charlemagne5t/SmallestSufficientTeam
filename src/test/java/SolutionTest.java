import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void smallestSufficientTeamTest1() {
        String[] req_skills = {"java", "nodejs", "reactjs"};
        List<List<String>> people = new ArrayList<>(List.of(
                new ArrayList<>(List.of("java")),
                new ArrayList<>(List.of("nodejs")),
                new ArrayList<>(List.of("nodejs", "reactjs"))));

        int[] expected = {0, 2};
        int[] actual = new Solution().smallestSufficientTeam(req_skills, people);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void smallestSufficientTeamTest2() {
        String[] req_skills = {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        List<List<String>> people = new ArrayList<>(List.of(
                new ArrayList<>(List.of("algorithms", "math", "java")),
                new ArrayList<>(List.of("algorithms", "math", "reactjs")),
                new ArrayList<>(List.of("java", "csharp", "aws")),
                new ArrayList<>(List.of("reactjs", "csharp")),
                new ArrayList<>(List.of("csharp", "math")),
                new ArrayList<>(List.of("csharp", "math")),
                new ArrayList<>(List.of("aws", "java"))
        ));

        int[] expected = {1, 2};
        int[] actual = new Solution().smallestSufficientTeam(req_skills, people);

        Assertions.assertArrayEquals(expected, actual);
    }

}
