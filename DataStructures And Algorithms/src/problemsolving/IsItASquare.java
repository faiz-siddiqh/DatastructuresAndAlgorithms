package problemsolving;

/**
 * Given coordinates of four points in a plane, find if the four points form a
 * square or not.
 *
 */
class Point {
	int x;
	int y;

	public Point(int a, int b) {
		this.x = a;
		this.y = b;
	}

}

public class IsItASquare {

	/**
	 * Check if the 4 points form a square
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 * @return
	 */
	private static boolean isSquare(Point p1, Point p2, Point p3, Point p4) {

		int d2 = findDistance(p1, p2);
		int d3 = findDistance(p1, p3);
		int d4 = findDistance(p1, p4);

		if (d2 == 0 || d3 == 0 || d4 == 0)// if any side is 0 then its not a quadrilateral
			return false;

		// if the adjacent side are equal and the diagonal is twice the side for any two
		// points then its a square
		if (d2 == d4 && d3 == 2 * d2 && d2 == findDistance(p2, p3) && d2 * 2 == findDistance(p2, p4))
			return true;

		return false;
	}

	public static int findDistance(Point A, Point B) {
		// return the sum of the square of the points
		// We are multiplying here so as to remove the square root in d/
		return (A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y);
	}

	public static void main(String[] args) {

		Point P1 = new Point(2, 2);
		Point P3 = new Point(4, 2);
		Point P2 = new Point(4, 4);
		Point P4 = new Point(2, 4);
		// the order of the points in parameter is important
		System.out.println(isSquare(P1, P2, P3, P4) ? "Yes .Is a Square" : "Its not a Square");

	}

}
