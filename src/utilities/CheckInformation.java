package utilities;

@FunctionalInterface
public interface CheckInformation<T> {
    T check(T checkedInformation);
}
