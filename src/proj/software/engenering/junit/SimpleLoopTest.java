package proj.software.engenering.junit;

import static org.junit.Assert.*;
import org.junit.Test;
import proj.software.engenering.GradingRubric;

public class SimpleLoopTest {

	@Test
	public void simpleLoopTest() {
		GradingRubric gradingRubric = new GradingRubric();

		double[] test1 = { 1.0 };
		double[] test2 = { 1.0, 99.0 };
		double[] test3 = { 1.0, 50.0, 99.0 };
		double[] test100 = new double[100];
		for (int i = 0; i < 100; i++) {
			test100[i] = i;
		}
		double[] test999999 = new double[999999];
		for (int i = 0; i < 999999; i++) {
			test999999[i] = i;
		}

		// check for loop in GradingRubric.UpdateGrade()
		assertNull(gradingRubric.UpdateGrade(null));
		assertNull(gradingRubric.UpdateGrade(new double[0]));
		for (char c : gradingRubric.UpdateGrade(test1)) {
			assertTrue(checkResultRange(c));
		}
		for (char c : gradingRubric.UpdateGrade(test2)) {
			assertTrue(checkResultRange(c));
		}
		for (char c : gradingRubric.UpdateGrade(test3)) {
			assertTrue(checkResultRange(c));
		}
		for (char c : gradingRubric.UpdateGrade(test100)) {
			assertTrue(checkResultRange(c));
		}
		for (char c : gradingRubric.UpdateGrade(test999999)) {
			assertTrue(checkResultRange(c));
		}
	}

	public boolean checkResultRange(char c) {
		return (c >= 'A' && c <= 'F') ? true : false;

	}
}
