package oncall.domain;

import java.util.Collections;
import java.util.List;

public class AllocationGroup {
    private final List<Allocation> allocations;

    public AllocationGroup(List<Allocation> allocations) {
        this.allocations = allocations;
    }

    public List<Allocation> getAllocations() {
        return Collections.unmodifiableList(allocations);
    }
}
