package oncall.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import oncall.util.ErrorMessage;

public class AllocationGroup {
    private final List<Allocation> allocations;

    public AllocationGroup(List<Allocation> allocations) {
        this.allocations = reAllocate(allocations);
    }

    public List<Allocation> getAllocations() {
        return Collections.unmodifiableList(allocations);
    }

    public List<Allocation> reAllocate(List<Allocation> allocations) {
        List<Allocation> changedAllocations = new ArrayList<>(allocations);
        for (int i = 1; i < changedAllocations.size(); i++) {
            int prevIndex = i - 1;
            int thisIndex = i;
            Allocation prevAllocation = changedAllocations.get(prevIndex);
            Allocation thisAllocation = changedAllocations.get(thisIndex);
            if (thisAllocation.equals(prevAllocation)) {
                Allocation targetAllocation = findTargetAllocation(changedAllocations, thisIndex, thisAllocation);
                thisAllocation.changeEmployee(targetAllocation);
            }
        }
        return changedAllocations;
    }

    private Allocation findTargetAllocation(List<Allocation> changedAllocations, int thisIndex,
                                            Allocation thisAllocation) {
        return changedAllocations.stream()
                .skip(thisIndex + 1)
                .filter(allocation -> allocation.isEqualWorkdayGroup(thisAllocation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_CHANGE.getMessage()));
    }
}
