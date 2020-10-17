public class PhysicsCalculator {

    public static boolean isBeyondBoundaries(float value, float distanceFromCenter, float max) {
        if ((value - distanceFromCenter < 0 || value + distanceFromCenter > max)) {
            return true;
        }
        return false;
    }

}
