package proj.software.engenering;

public class GradingRubric {
	private double GradeA = 90;
	private double GradeB = 80;
	private double GradeC = 70;
	private double GradeD = 60;	

	public char[] UpdateGrade(double[] percentage) {
		if (percentage == null || percentage.length <= 0) {
			return null;
		}
		char[] c = new char[percentage.length];
		for (int i = 0; i < percentage.length; i++) {
			if (percentage[i] < 0 || percentage[i] > 100) {
				c[i] = 'F';
			} else if (percentage[i] < GradeD) {
				c[i] = 'E';
			} else if (percentage[i] < GradeC) {
				c[i] = 'D';
			} else if (percentage[i] < GradeB) {
				c[i] = 'C';
			} else if (percentage[i] < GradeA) {
				c[i] = 'B';
			} else {
				c[i] = 'A';
			}
		}
		return c;
	}

}
