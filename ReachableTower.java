public class ReachableTower {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int bestQuality = -1;
        int bestX = -1;
        int bestY = -1;
        for (int[] tower : towers) {
            int x = tower[0];
            int y = tower[1];
            int q = tower[2];
            int dist = Math.abs(x - center[0]) + Math.abs(y - center[1]);
            if (dist > radius) {
                continue;
            }
            if (q > bestQuality || (q == bestQuality && (x < bestX || (x == bestX && y < bestY)))) {
                bestQuality = q;
                bestX = x;
                bestY = y;
            }
        }
        if (bestQuality == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{bestX, bestY};
    }
}
