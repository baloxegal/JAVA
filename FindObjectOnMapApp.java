package homework_8;

public class FindObjectOnMapApp {

	public static void main(String[] args) {
		int hsize = 19;
		int vsize = 22;
		int x = 16;
		int y = 6;
		int cx = 9;
		int cy = 20;
		if(x > hsize || cx > hsize || y > vsize || cy > vsize) {
			System.out.println("Coordinates cannot be larger than map size");
		}
		else if(x == cx && y == cy){
			System.out.println("The observer and the object cannot have the same coordinate");
		}
		else {
			System.out.println("Area of the map is - " + printMapArea(hsize, vsize) + " m.sq");
			System.out.println("The object is in the direction - " + printViewDirection(x, y, cx, cy));
			System.out.printf("Object distance - %.2f", printDistanceToObject(x, y, cx, cy));
			printMap(hsize, vsize, x, y, cx, cy);	
		}
	
	}
	static int printMapArea(int hsize, int vsize) {
		return hsize * vsize;
	}
	static String printViewDirection(int x, int y, int cx, int cy) {
		String a = "";
		if(x == cx && y > cy ) {
			a = "N";
		}
		else if(x == cx && y < cy ) {
			a = "S";
		}
		else if(y == cy && x > cx ) {
			a = "W";
		}
		else if(y == cy && x < cx ) {
			a = "E";
		}
		else if(y > cy && x < cx ) {
			a = "NE";
		}
		else if(y > cy && x > cx ) {
			a = "NW";
		}
		else if(y < cy && x > cx ) {
			a = "SW";
		}
		else if(y < cy && x < cx ) {
			a = "SE";
		}
		return a;
	}
	static double printDistanceToObject(int x, int y, int cx, int cy) {
		double a;
		if(printViewDirection(x, y, cx, cy) == "NW") {
			a = Math.sqrt((x - cx) * (x - cx) + (y - cy) * (y - cy));
		}
		else if(printViewDirection(x, y, cx, cy) == "NE") {
			a = Math.sqrt((cx - x) * (cx - x) + (y - cy) * (y - cy));
		}
		else if(printViewDirection(x, y, cx, cy) == "SW") {
			a = Math.sqrt((x - cx) * (x - cx) + (cy - y) * (cy - y));
		}
		else if(printViewDirection(x, y, cx, cy) == "SE") {
			a = Math.sqrt((cx - x) * (cx - x) + (cy - y) * (cy - y));
		}
		else if(printViewDirection(x, y, cx, cy) == "N") {
			a = y - cy;
		}
		else if(printViewDirection(x, y, cx, cy) == "S") {
			a = cy - y;
		}
		else if(printViewDirection(x, y, cx, cy) == "W") {
			a = x - cx;
		}
		else {
			a = cx - x;
		}
		return a;
	}
	static void printMap(int hsize, int vsize, int x, int y, int cx, int cy) {
		for(int i = 1; i <= vsize + 7; i++) {
			for(int j = 1; j <= hsize + 4; j++) {
				if(i < 5 || i > vsize + 4) {
					if(i == 1 && j == hsize/2 + 4 && hsize%2 != 0) {
						System.out.print("N   ");
					}
					else if(i == 1 && j == hsize/2 + 3 && hsize%2 == 0) {
						System.out.print("  N ");
					}
					else if(i == 2 && j == hsize/2 + 4 && hsize%2 != 0) {
						System.out.print("^   ");
					}
					else if(i == 2 && j == hsize/2 + 3 && hsize%2 == 0) {
						System.out.print("  ^ ");
					}
					else if(i == 3 && x == cx && (j >= x + 2 && j <= x + 3 )) {
						if(j == x + 2) {
							System.out.print("   x,cx ");
						}
						else {
							continue;	
						}
					}
					else if(i == 3 && x != cx && j == x + 3) {
						System.out.print("x   ");
					}
					else if (i == 3 && x != cx && j == cx + 3){
							System.out.print("cx  ");	
					}
					else if(i == 4 && (j > 3 && j <= hsize + 3)) {
						int n = j - 3;
						if(n < 10) {
							System.out.print(n + "   ");
						}
						else {
							System.out.print(n + "  ");
						}
					}
					else if(i == vsize + 6 && j == hsize/2 + 4 && hsize%2 != 0) {
						System.out.print("v   ");
					}
					else if(i == vsize + 6 && j == hsize/2 + 3 && hsize%2 == 0) {
						System.out.print("  v ");
					}
					else if(i == vsize + 7 && j == hsize/2 + 4 && hsize%2 != 0) {
						System.out.print("S   ");
					}
					else if(i == vsize + 7 && j == hsize/2 + 3 && hsize%2 == 0) {
						System.out.print("  S ");
					}
					else {
						System.out.print("    ");
					}
				}
				else {
					if(i == vsize/2 + 5 && j == 1 && vsize%2 != 0) {
						System.out.print("W<  ");
						}
					else if(i == y + 4 && y == cy && j == 2) {
						System.out.print("y,cy");
						}
					else if(i == y + 4 && y != cy && j == 2) {
						System.out.print("  y ");
						}
					else if (i == cy + 4 && y != cy && j == 2) {
						System.out.print(" cy ");	
						}
					else if(i == vsize/2 + 5 && j == hsize + 4 && vsize%2 != 0) {
						System.out.print(" >E ");
						}
					else if(j == 3) {
						int n = i - 4;
						if(n < 10) {
							System.out.print(" " + n + "  ");
						}
						else {
							System.out.print(n + "  ");
						}
					}
					else if(j > 3 && j <= hsize + 3) {
						if ( i == y + 4 && j == x + 3) {
							System.out.print("O   ");
						}
						else if ( i == cy + 4 && j == cx + 3) {
							System.out.print("C   ");
						}
						else {
							System.out.print(".   ");
						}
					}
					else {
						System.out.print("    ");
					}
				}
			}
			System.out.println();
			if(i == vsize/2 + 4 && vsize%2 == 0) {
				System.out.print("W<  ");
				for(int c = 0; c < hsize + 2 ; c++) {
					System.out.print("    ");
				}
				System.out.print(" >E \n");
			}
			else if(i > 4 && i < vsize + 4) {
				System.out.println();
			}
		}
	}

}
