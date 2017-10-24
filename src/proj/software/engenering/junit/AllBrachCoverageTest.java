package proj.software.engenering.junit;

import static org.junit.Assert.*;
import org.junit.Test;
import proj.software.engenering.GradingRubric;

public class AllBrachCoverageTest {

	@Test
	public void allBrachCoverageTest() {
		GradingRubric gradingRubric = new GradingRubric();

		double max = 100, min = 0;
		double GradeA = 90;
		double GradeB = 80;
		double GradeC = 70;
		double GradeD = 60;

		double[] invalidtest = { -0.000000000001, -1.0, -9999999999999.0, -1e200, 100.000000000001, 101.0, 1e200 };

		double[] testA = { max, max - 0.000000000001, max - 1, (max + GradeA) / 2, GradeA + 1, GradeA + 0.000000000001,
				GradeA };
		double[] testB = { GradeA - 0.000000000001, GradeA - 1, (GradeA + GradeB) / 2, GradeB + 1,
				GradeB + 0.000000000001, GradeB };
		double[] testC = { GradeB - 0.000000000001, GradeB - 1, (GradeB + GradeC) / 2, GradeC + 1,
				GradeC + 0.000000000001, GradeC };
		double[] testD = { GradeC - 0.000000000001, GradeC - 1, (GradeC + GradeD) / 2, GradeD + 1,
				GradeD + 0.000000000001, GradeD };
		double[] testE = { GradeD - 0.000000000001, GradeD - 1, (GradeD + min) / 2, min + 1, min + 0.000000000001, min };

		// null input
		assertNull(gradingRubric.UpdateGrade(null));
		assertNull(gradingRubric.UpdateGrade(new double[0]));

		// invalid input
		for (char c : gradingRubric.UpdateGrade(invalidtest)) {
			assertTrue('F' == c);
		}

		// correct input
		for (char c : gradingRubric.UpdateGrade(testA)) {
			assertTrue('A' == c);
		}
		for (char c : gradingRubric.UpdateGrade(testB)) {
			assertTrue('B' == c);
		}
		for (char c : gradingRubric.UpdateGrade(testC)) {
			assertTrue('C' == c);
		}
		for (char c : gradingRubric.UpdateGrade(testD)) {
			assertTrue('D' == c);
		}
		for (char c : gradingRubric.UpdateGrade(testE)) {
			assertTrue('E' == c);
		}
	}
}
