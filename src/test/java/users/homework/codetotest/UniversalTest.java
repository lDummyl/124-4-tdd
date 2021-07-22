package users.homework.codetotest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SuppressWarnings("UnstableApiUsage")
public class UniversalTest {

    private final Supplier<? extends Interpolator> interpolator;
    private final List<Point> invalidPoints;
    private final List<Point> validPoints;

    private final Float PRECISION = 0.001f;

    public UniversalTest(Supplier<? extends Interpolator> interpolator) throws IOException {
        this.interpolator = interpolator;
        ObjectMapper mapper = new ObjectMapper();
        CollectionType pointType = mapper.getTypeFactory()
                .constructCollectionType(List.class, Point.class);
        String invalidPointsArrayString = Resources.toString(Resources.getResource("invalid_points.json"), StandardCharsets.UTF_8);
        String validPointsArrayString = Resources.toString(Resources.getResource("valid_points.json"), StandardCharsets.UTF_8);
        this.validPoints = mapper.readValue(validPointsArrayString, pointType);
        this.invalidPoints = mapper.readValue(invalidPointsArrayString, pointType);
    }

    public void testValidPoints() {
        Interpolator interpolator = getInterpolator();
        this.validPoints.forEach(p -> assertEquals(p.y, interpolator.getY(p.x), PRECISION));
    }

    public void testInvalidPoints() {
        Interpolator interpolator = getInterpolator();
        this.invalidPoints.forEach(p -> assertNotEquals(p.y, interpolator.getY(p.x), PRECISION));
    }

    private Interpolator getInterpolator() {
        Interpolator interpolator = this.interpolator.get();
        // три точки параболы - (-4, 16), (0, 0), (2, 4)
        List<Point> points = Stream.of(new Point(-4f, 16f),
                new Point(0f, 0f),
                new Point(2f, 4f))
                .collect(Collectors.toList());
        interpolator.setPoints(points);
        return interpolator;
    }
}
