public class TowerSolver {

    private TowerModel model;

    public TowerSolver() {
        // constructor left blank
    }

    public void solve(TowerModel model) {
        this.model = model;
        int count = model.getHeight();
        solve(count, 0, 2, 1);
    }

    private void solve(int disks, int from, int to, int spare) {
        if (disks == 0) return;

        solve(disks - 1, from, spare, to);
        model.move(from, to);
        solve(disks - 1, spare, to, from);
    }
}
