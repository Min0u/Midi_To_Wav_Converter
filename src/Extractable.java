import java.util.List;
import java.util.Objects;

public interface Extractable<T> {
    public void extract(T type);
}
