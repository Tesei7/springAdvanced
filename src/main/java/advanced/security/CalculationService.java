package advanced.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Integer calculate(Integer val1, Integer val2) {
        return val1 + val2;
    }
}
