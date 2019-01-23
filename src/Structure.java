public enum Structure {
  // https://gist.github.com/urschrei/f6753e265a4cc025150b47a0b8037cdd
  
  // Field	Footprint 5x5 (Contour)
  //(Basic) Shape -	Regular:2.6926:
  // -1,-2.5;
  // -2.5,-1;
  // -2.5,1;
  // -1,2.5;
  // 1,2.5;
  // 2.5,1;
  // 2.5,-1;
  // 1,-2.5:
  // 7,0,2;
  // 0,1,2;
  // 1,2,2;
  // 2,3,2;
  // 3,4,2;
  // 4,5,2;
  // 5,6,2;
  // 6,7,2
  Nexus(5, 'N', 2.6926),

  // Field	Footprint 3x3 (Contour)
  //(Basic) Shape -	Regular:1.803:
  // -1.5,-1;
  // -1.5,1;
  // -1,1.5;
  // 1,1.5;
  // 1.5,1;
  // 1.5,-1;
  // 1,-1.5;
  // -1,-1.5:
  // 7,0,2;
  // 0,1,2;
  // 1,2,2;
  // 2,3,2;
  // 3,4,2;
  // 4,5,2;
  // 5,6,2;
  // 6,7,2
  Gateway(3, 'G', 2.1213),

  // Field	Footprint 2x2 (Contour)
  //(Basic) Shape -	Regular:1.1181:
  // -1,0.5;   0
  // -0.5,1;   1
  // 0.5,1;    2
  // 1,0.5;    3
  // 1,-0.5;   4
  // 0.5,-1;   5
  // -0.5,-1;  6
  // -1,-0.5  7
  // :7,0,2;
  // 0,1,2;
  // 1,2,2;
  // 2,3,2;
  // 3,4,2;
  // 4,5,2;
  // 5,6,2;
  // 6,7,2
  Pylon(2, 'P', 2.1213);



  public final int size;
  public final double radius;
  private final char c;

  Structure(final int size, final char c, final double radius) {
    this.size = size;
    this.c = c;
    this.radius = radius;
  }

  void fill(final char[][] output, final int x, final int y) {
    for (int i = 1; i < size - 1; i++) {
      for (int j = 1; j < size - 1; j++) {
        output[x + i][y + j] = ' ';
      }
    }
    output[x + 1][y + 1] = c;
    for (int i = 1; i < size - 1; i++) {
      output[x + i][y + 0] = '─';
      output[x + i][y + size - 1] = '─';
      output[x + 0][y + i] = '│';
      output[x + size - 1][y + i] = '│';
    }
    output[x + 0][y + 0] = '┌';
    output[x + 0][y + size - 1] = '└';
    output[x + size - 1][y + 0] = '┐';
    output[x + size - 1][y + size - 1] = '┘';
  }
}
