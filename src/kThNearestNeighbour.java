import java.util.List;

public class kThNearestNeighbour {
    public static int KNearestNeighbour(int n, int k, List<List<Integer>> points) {
        // Step 1: Create arrays to store the distances and their indices
        // We need n-1 spaces because we're measuring distances from point 0 to all other points
        int[] distances = new int[n-1];
        int[] indices = new int[n-1];

        // Step 2: Get the first point's coordinates (the reference point)
        int x0 = points.get(0).get(0); // x-coordinate of reference point
        int y0 = points.get(0).get(1); // y-coordinate of reference point

        // Step 3: Calculate the distance from first point to every other point
        for (int i = 1; i < n; i++) {
            int xi = points.get(i).get(0); // x-coordinate of current point
            int yi = points.get(i).get(1); // y-coordinate of current point

            // Square of distance (Using the given formula D² = (xi-x0)² + (yi-y0)²)
            // We don't need square root since we only care about relative distances
            int dist = (xi - x0) * (xi - x0) + (yi - y0) * (yi - y0);

            // Store the distance and original index
            // Note: we use i-1 as array index since we start storing from point 1, not 0
            distances[i-1] = dist;
            indices[i-1] = i;
        }

        // Step 4: Sort distances using selection sort (we only need to sort up to k elements)
        // This is more efficient than sorting the entire array if k is small
        for (int i = 0; i < k; i++) {
            int minIndex = i;

            // Find the smallest remaining distance
            for (int j = i + 1; j < n-1; j++) {
                if (distances[j] < distances[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap to put the smallest distance at position i
            int temporaryDistance = distances[i];
            distances[i] = distances[minIndex];
            distances[minIndex] = temporaryDistance;

            // Also swap the corresponding indices
            int temporaryIndex = indices[i];
            indices[i] = indices[minIndex];
            indices[minIndex] = temporaryIndex;
        }

        // Step 5: Return the index of the k-th closest point
        // We use k-1 because array indices start at 0
        return indices[k-1];
    }
}