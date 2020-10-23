public class PhysicsCalculator {

    public static boolean isBeyondBoundaries(float value, float distanceFromCenter, float max) {
        return (value - distanceFromCenter) < 0) || (value + distanceFromCenter) > max;
    }

}
