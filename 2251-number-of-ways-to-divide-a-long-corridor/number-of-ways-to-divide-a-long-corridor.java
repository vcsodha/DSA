class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;

        int totalSeats = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') totalSeats++;
        }
        // If total seats are zero or odd, no valid division
        if (totalSeats == 0 || totalSeats % 2 != 0) {
            return 0;
        }
        long ways = 1;
        int seatCount = 0;
        int plantCount = 0;
        boolean countingPlants = false;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;

                if (seatCount % 2 == 1 && countingPlants) {
                    ways = (ways * (plantCount + 1)) % MOD;
                    plantCount = 0;
                    countingPlants = false;
                }
            } else { 
                if (seatCount % 2 == 0 && seatCount > 0) {
                    plantCount++;
                    countingPlants = true;
                }
            }
        }
        return (int) ways;
    }
}
