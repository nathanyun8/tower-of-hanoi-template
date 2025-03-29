public class TowerModel {

    private IntegerStack[] towers;
    private int towerHeight;
    private int moveLog = 0;
    private int printLog = 0;

    public TowerModel(int height) {
        this.towerHeight = height;
        towers = new IntegerStack[3];

        for (int i = 0; i < 3; i++) {
            towers[i] = new IntegerStack(height);
        }

        for (int disk = height; disk >= 1; disk--) {
            towers[0].push(disk);
        }
    }

    public int getHeight() {
        return towerHeight;
    }

    public IntegerStack[] getTowers() {
        return towers;
    }

    public void move(int source, int destination) {
        System.out.println("Move #" + (++moveLog) + " from " + source + " to " + destination);

        int sourceDisk = towers[source].peek();
        int destinationDisk = towers[destination].peek();

        boolean canMove = sourceDisk != 0 && (destinationDisk == 0 || sourceDisk < destinationDisk);

        if (canMove) {
            towers[source].pop();
            towers[destination].push(sourceDisk);
        }
    }

    public void print() {
        System.out.println("Print #" + (++printLog) + " State");

        for (int row = towerHeight - 1; row >= 0; row--) {
            System.out.println();
            for (int col = 0; col < 3; col++) {
                int val = towers[col].get(row);
                System.out.print(val == 0 ? " |" : " " + val);
            }
        }

        System.out.println();
        System.out.println(" = = =");
    }
}
